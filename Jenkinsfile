
def projectName = 'tampa3rest'
def version = "0.0.${currentBuild.number}"
def dockerImageTag = "${projectName}:${version}"

pipeline {
  agent any


//Will build project in docker
  stages {


//     stage('Test') {
//       steps {
//         //sh 'chmod a+x mvn'
//         sh 'mvn clean test'
//       }
//     }
//
//     stage('Build') {
//       steps {
//         sh 'mvn package'
//       }
//     }

//Building with docker
    stage('Build Container') {
      steps {
        sh "docker build -t ${dockerImageTag} ."
      }
    }

    stage('Deploy Container To Openshift') {
      steps {
        sh "oc login https://localhost:8443 --username admin --password admin --insecure-skip-tls-verify=true"
        sh "oc project ${projectName} || oc new-project ${projectName}"
        sh "oc delete all --selector app=${projectName} || echo 'Unable to delete all previous openshift resources'"
        sh "oc new-app ${dockerImageTag} -l version=${version}"
        sh "oc expose svc/${projectName}"
      }
    }
  }
}