package com.blackmensa.ddtool.data.local.mapper

import com.blackmensa.ddtool.data.local.entity.CharacterEntity
import com.blackmensa.ddtool.domain.model.CharacterProfile

fun CharacterProfile.toEntity(ownerEmail: String): CharacterEntity {
    return CharacterEntity(
        id = id,
        ownerEmail = ownerEmail,
        name = name,
        charClass = charClass,
        level = level,
        hitPoints = hitPoints,
        currentGold = currentGold,
        strength = strength,
        dexterity = dexterity,
        constitution = const,
        intelligence = intelligence,
        wisdom = wisdom,
        charisma = charisma,
        strengthSave = savingThrows[0],
        dexteritySave = savingThrows[1],
        constitutionSave = savingThrows[2],
        intelligenceSave = savingThrows[3],
        wisdomSave = savingThrows[4],
        charismaSave = savingThrows[5],
        acrobatics = skills[0],
        animalHandling = skills[1],
        arcana = skills[2],
        athletics = skills[3],
        deception = skills[4],
        history = skills[5],
        insight = skills[6],
        intimidation = skills[7],
        investigation = skills[8],
        medicine = skills[9],
        nature = skills[10],
        perception = skills[11],
        performance = skills[12],
        persuasion = skills[13],
        religion = skills[14],
        sleightOfHand = skills[15],
        stealth = skills[16],
        survival = skills[17]
    )
}

fun CharacterEntity.toDomain(): CharacterProfile {
    return CharacterProfile(
        id = id,
        name = name,
        charClass = charClass,
        strength = strength,
        dexterity = dexterity,
        const = constitution,
        intelligence = intelligence,
        wisdom = wisdom,
        charisma = charisma,
        level = level,
        savingThrows = booleanArrayOf(
            strengthSave,
            dexteritySave,
            constitutionSave,
            intelligenceSave,
            wisdomSave,
            charismaSave
        ),
        skills = booleanArrayOf(
            acrobatics,
            animalHandling,
            arcana,
            athletics,
            deception,
            history,
            insight,
            intimidation,
            investigation,
            medicine,
            nature,
            perception,
            performance,
            persuasion,
            religion,
            sleightOfHand,
            stealth,
            survival
        ),
        currentGold = currentGold,
        hitPoints = hitPoints
    )
}