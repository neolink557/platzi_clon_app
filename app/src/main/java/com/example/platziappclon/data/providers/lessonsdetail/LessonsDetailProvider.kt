package com.example.platziappclon.data.providers.lessonsdetail

import com.example.platziappclon.data.model.LessonsListModel
import com.example.platziappclon.data.model.LessonsModuleModel
import javax.inject.Inject


class LessonsDetailProvider @Inject constructor(){

    fun getLessonsDetail():List<LessonsModuleModel>{
        return createLessonsDetail()
    }

    fun createLessonsDetail():List<LessonsModuleModel>{
        val model = LessonsModuleModel("Hora de aprender con platzi",createLessonsItem1())
        val model2 = LessonsModuleModel("Modulo dos: Pancho Panchito",createLessonsItem2())
        val model3 = LessonsModuleModel("Modulo tres: Frailejon Hernesto Perez",createLessonsItem3())

        return listOf(model,model2,model3)
    }

    fun createLessonsItem1():List<LessonsListModel>{
        val model = LessonsListModel("Aprendiendo a desaprender","5 min")
        val model2 = LessonsListModel("Desaprendiendo lo aprendido","3 min")
        val model3 = LessonsListModel("Desaprendiendo el aprender a desaprender","10 min")
        val model4 = LessonsListModel("Destruyendo una casa con napalm","12 min")
        val model5 = LessonsListModel("Aprendiendo a contruir una casa desde 0","7 min")

        return listOf(model,model2,model3,model4,model5)
    }

    fun createLessonsItem2():List<LessonsListModel>{
        val model = LessonsListModel("Pancho Panchito: realmente es feliz?","12 min")
        val model2 = LessonsListModel("Como elegir sombreros: live class de Pancho Panchito","59 min")
        val model3 = LessonsListModel("Donde está el sombrero de Pancho Panchito?","8 min")
        val model4 = LessonsListModel("Como correr por el maiz sin perder tu sombrerito?","3 min")

        return listOf(model,model2,model3,model4,model)
    }

    fun createLessonsItem3():List<LessonsListModel>{
        val model = LessonsListModel("Porqué debemos cuidar los frailejones?","5 min")
        val model2 = LessonsListModel("Que es un frailejon?","3 min")
        val model3 = LessonsListModel("Porqué pusimos mal el orden de las clases?","10 min")
        val model4 = LessonsListModel("Frailejon Hernesto Perez ¿es un proxeneta?","12 min")
        val model5 = LessonsListModel("Viaje para ver frilejones","7 min")

        return listOf(model,model2,model3,model4,model5)
    }

}