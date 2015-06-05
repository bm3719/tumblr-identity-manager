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
                        :third-singular-object "xim"
                        :reflexive "ximself"}
    :social-justice-causes ["manspreading"
                            "class struggle"
                            "white able-bodied heterosexual cisgender male privilege"]
    :trigger-words ["food"
                    "dessert"
                    "homogenous"
                    "cake"]
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
                            "sexual consent"
                            "slut shaming"]
    :nounself-pronouns {:third-singular-subject "accipatheriposimuisea"
                        :third-singular-object "accipatheriposimoisiam"
                        :reflexive "accipatheriposimousoself"}
    :trigger-words ["uncle"
                    "mucus"
                    "penetration"
                    "rigid"]
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
                        :reflexive "zhiself"}
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
    :trans-ethnicity "dhampir"
    :shift-capabilities {:e-shift true
                         :m-shift true
                         :p-shift true}
    :social-justice-causes []
    :nounself-pronouns {:third-singular-subject "xie"
                        :third-singular-object "xier"
                        :reflexive "xierself"}
    :trigger-words ["food"
                    "dessert"
                    "homogenous"
                    "cake"]
    :disabilities ["IBS"
                   "leg beard"]
    :headmates []
    :tuplas []}
   {:_id 5
    :name "Galaxy G2"
    :preferred-name "G2"
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
    :nounself-pronouns {:third-singular-subject "galaxi"
                        :third-singular-object "galaxim"
                        :reflexive "galaximself"}
    :trigger-words ["collision"
                    "heat death"
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
    :trans-ethnicity "pony"
    :shift-capabilities {:e-shift true
                         :m-shift true
                         :p-shift true}
    :social-justice-causes []
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
    :trigger-words ["collision"
                    "heat death"
                    "GRB"
                    "supernova"]
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
    :trans-ethnicity "samoan"
    :shift-capabilities {:e-shift true
                         :m-shift true
                         :p-shift true}
    :social-justice-causes ["alternative medicine"
                            "anti-vax"]
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
    :preferred-name "Sonice"
    :identity-types ["fictive" "otherkin"]
    :therian-species "hedgehog"
    :sexuality ""
    :gender ""
    :trans-size ""
    :trans-ethnicity ""
    :shift-capabilities {:e-shift true
                         :m-shift true
                         :p-shift true}
    :social-justice-causes []
    :nounself-pronouns {:third-singular-subject "he"
                        :third-singular-object "him"
                        :reflexive "sonicthehedgehogself"}
    :trigger-words ["Eggman"
                    "chili dog"]
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
    :trans-ethnicity "Italian/Eyptian"
    :shift-capabilities {:e-shift true
                         :m-shift true
                         :p-shift true}
    :social-justice-causes ["chic lit"]
    :nounself-pronouns {:third-singular-subject "she"
                        :third-singular-object "her"
                        :reflexive "herself"}
    :trigger-words ["sale"]
    :disabilities []
    :headmates []
    :tuplas []}])
