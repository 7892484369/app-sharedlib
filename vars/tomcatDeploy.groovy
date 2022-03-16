def call(ip,user,credId){
  sshagent([credId]) {
    ips.each {
      echo "deploying on ${it}" 
      sh "scp -o StrictHostKeyChecking=no target/*.war ${user}@${it}:/opt/tomcat/webapps/app.war"
      sh "ssh ${user}@${it} /opt/tomcat/bin/shutdown.sh"
      sh "ssh ${user}@${it} /opt/tomcat/bin/startup.sh"
     }
  }
}
     
