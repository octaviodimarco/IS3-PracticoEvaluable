node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/octaviodimarco/IS3-PracticoEvaluable'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'M3'
   }
   stage('Build') {
      // Run the maven build
      withEnv(["MVN_HOME=$mvnHome"]) {
      
            sh 'cd payroll/server && "$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean package'
            
      }
   }
   stage('Results') {
      archiveArtifacts 'payroll/server/target/*.jar'
   }
   stage 'SonarCloud'
// Split https://github.com/organization/repository/pull/123
def urlcomponents = env.CHANGE_URL.split("/")
def org = urlcomponents[3]
def repo = urlcomponents[4]
withSonarQubeEnv('SonarCloud') {
    sh "./mvnw sonar:sonar \
    -Dsonar.pullrequest.provider=GitHub \
    -Dsonar.pullrequest.github.repository=${org}/${repo} \
    -Dsonar.pullrequest.key=${env.CHANGE_ID} \
    -Dsonar.pullrequest.branch=${env.CHANGE_BRANCH}"
}

}
