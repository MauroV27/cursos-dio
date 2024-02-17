enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario (val userID:String, val userName:String, val id:Int = companion.generateNewUserID()){
    object companion {
        private var lastUserID:Int = 0
        
        fun generateNewUserID() : Int {
            lastUserID++
            return lastUserID
        }
    }   
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel : Nivel, val id:Int = companion.generateNewCEID()){
    object companion {
        private var lastCE_ID:Int = 0 // CE => Conteúdo Educacional
        
        fun generateNewCEID() : Int {
            lastCE_ID++
            return lastCE_ID
        }
    } 
}

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
//         TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        if ( this.isUsuarioMatriculado(usuario) == false ){
            this.inscritos.add(usuario)
        }
    }
    
    fun totalInscritos() : Int = this.inscritos.size
    
    fun isUsuarioMatriculado( user:Usuario ) : Boolean {
        // Função que verficia se um usuário está inscrito ou não na formação
        for ( insc in this.inscritos ){
            if ( insc.id == user.id ) {
                return true
            }
        }
        return false
    }
}

fun main() {
//     TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
//     TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    
    // Usuários de teste : 
    val us1 = Usuario("MauroV27", "Mauro Victor")
    val us2 = Usuario("AnaMaria", "Ana Maria")
    val us3 = Usuario("Joao123", "João da Silva")
    
    // Verificando os dados dos usuários
    println(us1)
    println(us2)
    println(us3)
     
    // Conteúdos educacionais : 
    val ce1 = ConteudoEducacional("Introdução a Kotlin", nivel=Nivel.BASICO)
    val ce2 = ConteudoEducacional("Introdução a Banco de Dados relacionais", nivel=Nivel.INTERMEDIARIO)
    val ce3 = ConteudoEducacional("Introdução a Python", nivel=Nivel.BASICO)
    
    // Formações de teste : 
    val fm1 = Formacao("Kotlin para Backend", listOf(ce1, ce2))
    val fm2 = Formacao("Python para Backend", listOf(ce2, ce3))
    
    // Adicionando usuários as formações : 
    // Nesse exemplo o us1 vai estar em ambas as formações e us2 e us3 apenas em uma
    
    fm1.matricular(us1)
    fm1.matricular(us2)
    
    println("Dados sobre a formação 1: $fm1")
    
    fm2.matricular(us1)
    fm2.matricular(us3)
    
    println("Dados sobre a formação 2: $fm2")
    
    // Adicionando usuario já cadastrado em uma formação
    
    println("Quantidades alunos formação 1: ${fm1.totalInscritos()}")
    println("Adicionando usuario já cadastrado na formação 1")
    fm1.matricular(us1)
    println("Quantidades alunos formação 1: ${fm1.totalInscritos()}")
}


