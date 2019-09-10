package com.frangovers.petsociety.support

import io.realm.DynamicRealm
import io.realm.RealmMigration

class VizstatsRealmMigrations : RealmMigration {

    override fun migrate(realm: DynamicRealm, oldVersion: Long, newVersion: Long) {

        var oldVersionLocal = oldVersion

        // DynamicRealm exposes an editable schema
        val schema = realm.schema

        if (oldVersionLocal == 0L) {

        }

        if (oldVersionLocal == 1L) {
//            schema.get("Match")!!
//                .addField("seasonId", Int::class.javaPrimitiveType!!)
//            oldVersionLocal++
        }
    }
}