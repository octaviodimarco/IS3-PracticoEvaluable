node {
   def mvnHome
   def image
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/octaviodimarco/IS3-PracticoEvaluable.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'M3'
   }
stage('Build') {
      withEnv(["MVN_HOME=$mvnHome"]) {
        sh 'cd payroll/server && "$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean package'
		  image = docker.build("octaviodimarco/pipeline")
      }
   }

   // stage ('SonarCloud'){
   //    withEnv(["MVN_HOME=$mvnHome"]) {
   //    sh 'cd payroll/server && "$MVN_HOME/bin/mvn" verify sonar:sonar \
   //       -Dsonar.projectKey=octaviodimarco_IS3-PracticoEvaluable \
   //       -Dsonar.organization=octaviodimarco \
   //       -Dsonar.host.url=https://sonarcloud.io \
   //       -Dsonar.login=ad056e5a32040b87e2b0891cbc0411672ab6af11 \
   //       -Dmaven.test.failure.ignore=true'
   //    }
   // }



   // stage('Push Image') {
   //   docker.withRegistry('', 'dockerhub') {
	//    image.push()
	//  }
   // }

   stage('Push Image Heroku') {
     heroku container:push web --app=salty-brook-03114
     heroku container:release web --app=salty-brook-03114

	 }
   
      stage('Results') {
      archiveArtifacts 'payroll/server/target/*.jar'
      junit '**/target/surefire-reports/TEST-*.xml'

   }

}
