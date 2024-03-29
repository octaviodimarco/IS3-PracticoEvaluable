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

   stage ('SonarCloud'){
      withEnv(["MVN_HOME=$mvnHome"]) {
      sh 'cd payroll/server && "$MVN_HOME/bin/mvn" verify sonar:sonar \
         -Dsonar.projectKey=octaviodimarco_IS3-PracticoEvaluable \
         -Dsonar.organization=octaviodimarco \
         -Dsonar.host.url=https://sonarcloud.io \
         -Dsonar.login=ad056e5a32040b87e2b0891cbc0411672ab6af11 \
         -Dmaven.test.failure.ignore=true'
      }
   }


   stage('Push Image') {
     docker.withRegistry('', 'dockerhub') {
	   image.push()
	 }
   }

   stage('Push Image Heroku') {
      withCredentials([usernamePassword(credentialsId: 'herokuCredentials', passwordVariable: 'password',
      usernameVariable: 'user')]){
     sh 'docker login --username=_ --password=${password} registry.heroku.com'
     sh 'docker tag octaviodimarco/pipeline registry.heroku.com/salty-brook-03114/web'
     sh 'docker push registry.heroku.com/salty-brook-03114/web'
     sh 'heroku container:release web --app=salty-brook-03114'
      }
	 }

   stage('Integration test'){
      sleep 20
      sh 'cd payroll/server/src/test/payroll-test && npx codeceptjs run --steps --reporter mocha-multi'
   }


      stage('Results') {
      archiveArtifacts 'payroll/server/target/*.jar'
      archiveArtifacts 'payroll/server/src/test/payroll-test/output/result.xml'
      junit '**/target/surefire-reports/TEST-*.xml'
      archiveArtifacts 'payroll/server/target/surefire-reports/*.xml'

   }

}
