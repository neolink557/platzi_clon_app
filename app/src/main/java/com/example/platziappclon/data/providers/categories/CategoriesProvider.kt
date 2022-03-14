package com.example.platziappclon.data.providers.categories

import com.example.platziappclon.data.model.CategoriesModel
import javax.inject.Inject


class CategoriesProvider @Inject constructor(){

    fun getCategories():List<CategoriesModel>{
        return createCategories()
    }

    private fun createCategories():List<CategoriesModel>{
        val model = CategoriesModel("Desarrollo e Ingeniería","#83D988","null")
        val model1 = CategoriesModel("Diseño y UX","#CD8EE7","null")
        val model2 = CategoriesModel("Marketing","#6CC3F0","null")
        val model3 = CategoriesModel("Negocios y Emprendimiento","#F8CF63","null")
        val model4 = CategoriesModel("Contenido Digital","#F79564","null")
        val model5 = CategoriesModel("Habilidades Blandas","#F17E81","null")
        val model6 = CategoriesModel("Startups","#73E7D0","null")
        val model7 = CategoriesModel("Ingles","#EC82C2","null")



        return listOf(model,model1,model2,model3,model4,model5,model6,model7)
    }

}