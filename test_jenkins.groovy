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
                script {
                    
                    def sql = Sql.newInstance("jdbc:mysql://localhost:3306/productosplazavea", "root",  DB_PASSWORD , "com.mysql.jdbc.Driver")

                    def script = readFile('./DDL_CREATE_TABLE.sql')

                    sql.execute(script)

                    sql.close()
                }
            }
        }
    }
}