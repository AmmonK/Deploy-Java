pipeline {
  agent any
  stages {    
    stage('compile') {
      agent { docker { image 'maven:3.3.3' } }
      steps {
        sh 'mvn clean install'
        junit 'target/surefire-reports/*.xml'
        archiveArtifacts(artifacts: 'target/deploy-java-0.0.1.jar', onlyIfSuccessful: true, fingerprint: true)                   
      }
    }
    stage('docker') {      
      steps {
        sh "docker build -f Dockerfile ./"
      }
    }  
  }    
}
