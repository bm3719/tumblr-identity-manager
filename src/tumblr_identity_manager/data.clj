(ns tumblr-identity-manager.data)

;; This simulates an identity table in a database.
(def identities
  [{:_id 1
    :name "Bruce C. Miller"
    :preferred-name "Blake Delacroix"
    :identity-types ["sanguivore" "plantkin" "vampirekin" "fictive"]
    :therian-species "blood flower"
    :sexuality "lithromantic"
    :gender "trigender"
    :trans-size "transthin"
    :trans-ethnicity "dhampir"
    :shift-capabilities {:e-shift true
                         :m-shift true
                         :p-shift false}
    :nounself-pronouns {:third-singular-subject "xe"
                        :third-singular-object "xir"
                        :reflexive "xirself"}
    :social-justice-causes ["manspreading"
                            "microaggressions"
                            "white able-bodied heterosexual cisgender species-normative male privilege"]
    :trigger-words ["uncle"
                    "mucus"
                    "penetration"
                    "rigid"]
    :disabilities ["trans-autism"
                   "trans-immobile"
                   "blood addiction"]
    :headmates [4 5]
    :tuplas [6]}
   {:_id 2
    :name "Erik J. Seppanen"
    :preferred-name "Meeko"
    :identity-types ["furry" "fictive" "otherkin"]
    :therian-species "shloof"
    :sexuality "pomosexual"
    :gender "genderfluid"
    :trans-size "rubenesque"
    :trans-ethnicity "elven felid"
    :shift-capabilities {:e-shift true
                         :m-shift true
                         :p-shift false}
    :social-justice-causes ["HAES/FA"
                            "shirtgate"
                            "slut shaming"]
    :nounself-pronouns {:third-singular-subject "ziuxi"
                        :third-singular-object "ziuxous"
                        :reflexive "ziuxouself"}
    :trigger-words ["handsome"
                    "dessert"
                    "homogenous"
                    "food"]
    :disabilities ["transobesity"]
    :headmates [7]
    :tuplas [8]}
   {:_id 3
    :name "Angelica T. Garcia"
    :preferred-name "Biscuit"
    :identity-types ["factive" "otherkin" "pandakin"]
    :therian-species "panda"
    :sexuality "autosexual"
    :gender "bi-androgynous"
    :trans-size "rubenesque"
    :trans-ethnicity "Guatemalan"
    :shift-capabilities {:e-shift true
                         :m-shift true
                         :p-shift false}
    :social-justice-causes ["cultural appropriation"
                            "lookism"
                            "safe spaces"]
    :nounself-pronouns {:third-singular-subject "zhe"
                        :third-singular-object "zhir"
                        :reflexive "zhirself"}
    :trigger-words ["meat"
                    "doctor"
                    "hello"]
    :disabilities ["transautism"
                   "schizophrenia"
                   "OCD"]
    :headmates [9]
    :tuplas [10]}
   {:_id 4
    :name "Steelfang Ringtails"
    :preferred-name "Steelfang"
    :identity-types ["therian" "werekin" "otherkin"]
    :therian-species "werewolf"
    :sexuality "skoliosexual"
    :gender "pangender"
    :trans-size "curvy"
    :trans-ethnicity "skinwalker"
    :shift-capabilities {:e-shift true
                         :m-shift true
                         :p-shift true}
    :social-justice-causes ["transracial acceptance"]
    :nounself-pronouns {:third-singular-subject "xie"
                        :third-singular-object "xier"
                        :reflexive "xierself"}
    :trigger-words ["fetch"
                    "sit"]
    :disabilities ["IBS"
                   "leg beard"]
    :headmates []
    :tuplas []}
   {:_id 5
    :name "Galaxy M2"
    :preferred-name "M2"
    :identity-types ["galaxykin" "otherkin"]
    :therian-species "galaxy"
    :sexuality "galactosexual"
    :gender "astrogender"
    :trans-size "microscopic"
    :trans-ethnicity "globular cluster"
    :shift-capabilities {:e-shift true
                         :m-shift true
                         :p-shift true}
    :social-justice-causes []
    :nounself-pronouns {:third-singular-subject "galaxhe"
                        :third-singular-object "galaxhim"
                        :reflexive "galaxhimself"}
    :trigger-words ["collision"
                    "GRB"
                    "supernova"]
    :disabilities ["chronic dizziness"]
    :headmates []
    :tuplas []}
   {:_id 6
    :name "Jock Sterling"
    :preferred-name "Fluttershy"
    :identity-types ["brony" "otherkin" "ponykin"]
    :therian-species "pony"
    :sexuality "ponysexual"
    :gender "female"
    :trans-size "2-dimensional"
    :trans-ethnicity "African Canadian"
    :shift-capabilities {:e-shift true
                         :m-shift true
                         :p-shift true}
    :social-justice-causes ["equine cruelty"]
    :nounself-pronouns {:third-singular-subject "shee"
                        :third-singular-object "hir"
                        :reflexive "hirself"}
    :trigger-words ["speech"
                    "saddle"]
    :disabilities ["no hands"
                   "social anxiety"]
    :headmates []
    :tuplas []}
   {:_id 7
    :name "The Universe"
    :preferred-name "Steve"
    :identity-types ["astrokin" "realitykin" "otherkin"]
    :therian-species "universe"
    :sexuality "asexual"
    :gender "astrogender"
    :trans-size "multiversal"
    :trans-ethnicity "fluidic space"
    :shift-capabilities {:e-shift true
                         :m-shift true
                         :p-shift true}
    :social-justice-causes []
    :nounself-pronouns {:third-singular-subject "galaxi"
                        :third-singular-object "galaxim"
                        :reflexive "galaximself"}
    :trigger-words ["sidereal"
                    "brane"
                    "heat death"]
    :disabilities ["chronic dizziness"]
    :headmates []
    :tuplas []}
   {:_id 8
    :name "Rainbow Crystal"
    :preferred-name "Indigo"
    :identity-types ["indigo child" "interdimensional child"]
    :therian-species "human"
    :sexuality "asexual"
    :gender "agendered"
    :trans-size "bodyless"
    :trans-ethnicity "Atlantean"
    :shift-capabilities {:e-shift true
                         :m-shift true
                         :p-shift true}
    :social-justice-causes ["alternative medicine"
                            "anti-vax"
                            "pretty privilege"]
    :nounself-pronouns {:third-singular-subject "qui"
                        :third-singular-object "quir"
                        :reflexive "quirself"}
    :trigger-words ["government"
                    "terrestrial"
                    "vaccine"]
    :disabilities ["auric sensitivity"
                   "hyper-synesthetic"]
    :headmates []
    :tuplas []}
   {:_id 9
    :name "Sonic the Hedgehog"
    :preferred-name "Sonic"
    :identity-types ["fictive" "otherkin"]
    :therian-species "hedgehog"
    :sexuality "nobrosexual"
    :gender "voidfluid"
    :trans-size "sphere"
    :trans-ethnicity "multi-tailed hedgehog"
    :shift-capabilities {:e-shift true
                         :m-shift true
                         :p-shift true}
    :social-justice-causes []
    :nounself-pronouns {:third-singular-subject "he"
                        :third-singular-object "him"
                        :reflexive "sonicthehedgehogself"}
    :trigger-words ["Eggman"
                    "chili dogs"]
    :disabilities ["ADD"
                   "ADHD"]
    :headmates []
    :tuplas []}
   {:_id 10
    :name "Tiffany Ashmawy"
    :preferred-name "Tiff-tiff"
    :identity-types ["princess"]
    :therian-species "human"
    :sexuality "cishet"
    :gender "female"
    :trans-size "athletic"
    :trans-ethnicity "Italian/Egyptian"
    :shift-capabilities {:e-shift false
                         :m-shift false
                         :p-shift false}
    :social-justice-causes ["chic lit"]
    :nounself-pronouns {:third-singular-subject "she"
                        :third-singular-object "her"
                        :reflexive "herself"}
    :trigger-words ["sale"]
    :disabilities []
    :headmates []
    :tuplas []}])
