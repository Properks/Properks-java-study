####Type of Inner class

######Instatnce inner class
    Define : First declare instance form in outer class and define class in outer class.
    Can use : non-static and static variable in outer class, non-static variable in innerclass. CAN'T USE STATIC IN INNER CLASS. (Because Instance inner class is created after outer class is created)
    Create : After create outer.

#####Static inner class
    Define : Define in outer class. not declare instance form in outer class.
    Can use : Only Static variable.
    Create : Regardless of Outer class.

######Local inner class
    Define : Define in method.
    Can use : non-static and static variable in outer class, non-static variable in innerclass. CAN'T USE STATIC IN INNER CLASS.
    Create : By using method.

######anonymous inner class
    Define : Define in method or with variable.
    Can use : non-static and static variable in outer class, non-static variable in innerclass. CAN'T USE STATIC IN INNER CLASS.
    Create : By declaring variable with using method in outer class.