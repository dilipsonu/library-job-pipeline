def libraryServiceComponentSegmentJob = job('Library-Service-Component-Segment') {
  environmentVariables {
    env('APP_GIT_URL', 'https://github.com/dilipsonu/library-service')
  }
   scm {
     git {
       remote {
         url('${APP_GIT_URL}.git')
         credentials('github_credential')
       }
       branch("master")
     }
   }
   steps {
     gradle {
       useWrapper(true)
       makeExecutable(true)
       description('Run Unit Tests')
       tasks('test')
       fromRootBuildScriptDir(true)
     }
   }
   triggers {
     scm('* * * * *') {
       ignorePostCommitHooks()
     }
   }
   publishers {
     git {
       pushOnlyIfSuccess()
     }
     downstreamParameterized {
       trigger('Library-Service-ISO-Segment') {
         condition('SUCCESS')
         triggerWithNoParameters(true)
         parameters {
           gitRevision()
         }
       }
     }
   }
 }
