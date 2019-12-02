package com.frangovers.petsociety.helpers

enum class ArticleCategories(val string: String, var selected: Boolean = false) {
    TRAINING("training"),
    CARE("care"),
    HEALTH("health"),
    BREEDS("breeds"),
    FOOD("food")
}