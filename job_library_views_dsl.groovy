nestedView('Build Pipelines') {
  columns {
    weather()
  }
  views {
    deliveryPipelineView("Library-Service") {
      pipelines {
        component("Test/Build", "Library-Service-Component-Segment")
        component("Deployments", "Library-Service-Deploy-to-Environment")
       }
     }
   }
 }

 listView('Library Service Jobs') {
     columns {
         status()
         weather()
         name()
         lastSuccess()
         lastFailure()
         lastDuration()
         buildButton()
     }
     jobs {
         name('Library-Service-Component-Segment')
         name('Library-Service-ISO-Segment')
     }
 }
