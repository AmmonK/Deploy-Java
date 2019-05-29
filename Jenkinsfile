pipeline {
agent { docker { image 'maven:3.3.3' } }
  stages {
    stage('compile') {
      steps {
        sh 'mvn clean install'
      }
    }
    stage('archive') {
      steps {
        parallel(
          "Junit": {
            junit 'target/surefire-reports/*.xml'
            
          },
          "Archive": {
            archiveArtifacts(artifacts: 'target/deploy-java-0.0.1.jar', onlyIfSuccessful: true, fingerprint: true)
            archiveArtifacts(artifacts: 'target/deploy-java-0.0.1*javadoc.jar', fingerprint: true)
            
          }
        )
      }
    }
  }
}
