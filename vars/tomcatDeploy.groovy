def call(ip,user,credId){
  
  //copy file to tomcat server
  sshagent([credId]) {
  sh "scp -o StrictHostKeyChecking=no target/*.war ${user}@${ip}:/opt/tomcat/webapps/app.war"
  sh "ssh ${user}@${ip} /opt/tomcat/bin/shutdown.sh"
  sh "ssh ${user}@${ip} /opt/tomcat/bin/startup.sh"
        }
}
     
