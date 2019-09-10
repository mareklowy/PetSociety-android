package com.frangovers.petsociety.realm.models

import io.realm.Realm
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class ExampleRealmModel(

    @PrimaryKey var id: Int = 0,
    var name: String = ""

) : RealmObject() {

    companion object {

        fun getAll(): List<ExampleRealmModel> {
            return Realm.getDefaultInstance().where(ExampleRealmModel::class.java).findAll()
                .toList()
        }

        fun getOne(): ExampleRealmModel? {
            return Realm.getDefaultInstance().where(ExampleRealmModel::class.java).findFirst()
        }
    }
}