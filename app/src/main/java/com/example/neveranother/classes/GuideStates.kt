package com.example.neveranother.classes

import com.example.neveranother.R
// Jannik
enum class GuideStates(
    val guide: com.example.neveranother.classes.MeasurementGuide
) {

    OVER_BUST(
        MeasurementGuide(
            title = "Omfang over brystet",

            video = R.raw.overb,

            illustration =
                R.drawable.picoverb,

            explanation =
                "Placér målebåndet rundt om overkroppen og over den fyldigste del af brystet.",

            info =
                "Stå oprejst, slap af i kroppen, og pust ud." +
                        "Målebåndet skal sidde parallelt med gulvet hele vejen rundt om kroppen." +
                        "Tjek dette ved at kigge i spejlet."
        )
    ),

    UNDER_BUST(
        MeasurementGuide(
            title = "Omfang under brystet",

            video = R.raw.underb,

            illustration =
                R.drawable.picunderb,

            explanation =
                "Placér målebåndet rundt om kroppen lige under brystet dér, hvor bøjlen i en BH normalt sidder. " +
                        "Hvis du har en BH med bøjle på, skal målebåndet placeres lige under bøjlen.",


            info =
                "Stå oprejst, slap af i kroppen, og pust ud." +
                        "Målebåndet skal sidde parallelt med gulvet hele vejen rundt om kroppen." +
                        "Tjek dette ved at kigge i spejlet."
        )
    ),

    BREAST_WIDTH(
        MeasurementGuide(
            title = "Bryst bredde",

            video = R.raw.widthb,

            illustration =
                R.drawable.picwidthb,

            explanation =
                "Placér målebåndet i en lige vandret linje hen over brystets kurve.",

            info =
                "Du skal finde tre punkter:" +
                        " Det yderste punkt, hvor din bøjle slutter" +
                        " Brystets fyldigste punkt" +
                        " Midten mellem brysterne" +
                        " Mål fra det yderste punkt, hen over brystets fyldigste punkt og ind til midten mellem brysterne i en vandret linje." +
                        "Stram ikke målebåndet, men sørg for, at det ligger tæt ind mod brystet"
        )
    ),

    BREAST_HEIGHT(
        MeasurementGuide(
            title = "Bryst højde",

            video = R.raw.heigthb,

            illustration =
                R.drawable.picheigthb,

            explanation =
                "Denne måling afgør højden på din BH-skål. Hvis du har en BH med bøjle på, skal du måle fra lige under brystet ikke fra under bøjlen.",

            info =
                "Du skal finde tre punkter:" +
                        " Punktet under brystet, lige dér hvor brystet begynder" +
                        " Brystets fyldigste punkt" +
                        " Højden, hvor BH-skålen skal slutte – vi anbefaler omkring armhøjde/ved armhulen" +
                        " Mål fra punktet under brystet, hen over brystets fyldigste punkt og op til skålhøjden i en lige lodret linje." +
                        "Hold målebåndet tæt ind mod brystet, så det giver et let løft."
        )
    ),
}