enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val id: Int, val nome: String){
    override fun equals(other: Any?): Boolean{
        if(this === other) return true
        if(other !is Usuario) return false
        if(id != other.id) return false

        return true
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun desmatricular(usuario: Usuario){
        inscritos.remove(usuario)
    }
}

fun main() {
    val conteudoEdu1 = ConteudoEducacional("Kotlin POO")
    val conteudoEdu2 = ConteudoEducacional("Scrum")

    val usuario1 = Usuario(1, "Dorival Jr")
    val usuario2 = Usuario(2, "Zé Vaqueiro")

    var formacao = Formacao("Kotlin Básico", Nivel.BASICO, mutableListOf(conteudoEdu1, conteudoEdu2));
    println(formacao)
    println()

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    println(formacao.inscritos)
    println()

    val usuario1Clone = Usuario(1, "Dorival Jr")
    formacao.desmatricular(usuario1Clone);
    println(formacao.inscritos)
}