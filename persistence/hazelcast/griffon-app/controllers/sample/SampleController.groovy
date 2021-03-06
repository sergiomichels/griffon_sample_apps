package sample

import com.hazelcast.client.HazelcastClient

@griffon.plugins.hazelcast.HazelcastAware
class SampleController {
   def model

   def onStartupEnd = { app ->
      withHazelcast { String clientName, HazelcastClient client ->
         List tmpList = []
         tmpList.addAll client.getMap('people').values()
         execInsideUIAsync { model.people.addAll tmpList }
      }
   }
}
