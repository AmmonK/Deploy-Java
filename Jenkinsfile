pipeline {

  stages {
    
    stage('compile') {
      agent { docker { image 'maven:3.3.3' } }
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
          }
        )
      }
    }
            stage('docker') {      
        steps {
                        sh "docker build -f Dockerfile ./"
                    }
    }  
  }

  
  
}
