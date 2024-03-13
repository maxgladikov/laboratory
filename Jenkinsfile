pipeline {
    
    agent {label 'host'}
        
    
    tools { gradle 'gradle_8.6'
            }

//     triggers {
//                 pollSCM('* * * * *')
//             }
    
    stages {

		 stage("Stop all containers") {
            steps { 
                 sh "docker compose down"
              }
            }
					
        stage("Build gateway service") {
                steps {
                    sh "gradle gateway-service:build"
                  }
                }

        stage("Build discovery service") {
                steps {
                    sh "gradle discovery-service:build"
                  }
                }

        stage("Build admin service") {
            steps { 
                sh "gradle admin-service:build"
              }
            }

//         stage("Build user service") {
//             steps {
//                 sh "gradle user-service:build"
//               }
//             }
//
//         stage("Build student service") {
//             steps {
//                 sh "gradle student-service:build"
//               }
//             }
//
//         stage("Build teacher service") {
//             steps {
//                 sh "gradle teacher-service:build"
//               }
//             }

           } 
   post { 
        always { 
             sh "docker compose up -d"
        } 
        success {
            echo 'Successfully!'
        } 
        failure {
            echo 'Failed!'
        }
	}                 
}
