job('Library-Service-ISO-Segment') {
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
       description('Run BDD Tests')
       tasks('featureComponents')
       fromRootBuildScriptDir(true)
     }

   }
 }
