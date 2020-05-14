package com.example.linguagensapp.repository

import com.example.linguagensapp.Models.LanguageModel

object LangMapper {
    fun langToLanguage(lang: Lang): LanguageModel{
        return LanguageModel(
            lang.id,
            lang.name,
            lang.creators,
            lang.release_date,
            lang.typing_discipline,
            lang.image
        )
    }

    fun languageToLang(language: LanguageModel): Lang{
        return Lang(
            language.id,
            language.name,
            language.creators,
            language.release_date,
            language.typing_discipline,
            language.image
        )
    }
}