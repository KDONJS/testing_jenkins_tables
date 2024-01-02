import groovy.sql.Sql

pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'EJECUTANDO DDL'
            }
        }
    
        stage('Execute SQL Script') {
            steps { 

                withCredentials([string(credentialsId: '1', variable: 'DB_PASSWORD')]) {
                    sh """
                    set +x
                    mysql -u ROOT -p ${DB_PASSWORD} -h localhost productosplazavea < ./DDL_CREATE_TABLE.sql
                    """
                }
            }
        }
    }
}