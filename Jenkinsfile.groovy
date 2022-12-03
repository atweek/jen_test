pipeline {
    agent any
    parameters {
        booleanParam(name: 'test', defaultValue: true, description: 'Toggle this value')
//        choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')
    }
    stages {
        stage('init') {
            environment {
                TOKEN = credentials('36d3b42a-d868-4709-bb29-0be3986cc994')
	   }//env
            steps {
		script {
		    echo "account"
		    sh 'uname -a'
	            sh 'doctl auth init -t $TOKEN'
                    sh 'doctl account get'
                 }//script
	     }//steps
        }//stage
    }//stages
}
