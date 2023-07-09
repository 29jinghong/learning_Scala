package org.programingscala.chapter01

object Chapter01 {

		def step1(): Unit = 
	{
		println("STEP 1 :")

		print("20 + 30 = ")//printing the function out
		println(20 + 30)//caculating the function and print answer to the screen

		print("10 - 20 = ")
		println(10 - 20)//doing minus function and printing it
		println()
	}


	def step2(): Unit =
	{
		println("STEP 2 :")
		//step one initiating variables
		
		val n1: String = "jinghong" //this line inisilize with val which means it can't be changed
		//after the val is the name of the variable in this case is "N1"
		//next up is the "": String" which is type of the varable in this case is a string varables which
		//contains a list of chars
		
		var a1: Int = 20 //this line inisilize with var which means this varable can be changed and reasinged
		//after the var is the name.
		//next up is the ": Int" which means that this is a Int type
		//Int type can only store intigers which is numbers.

		println(n1)//here you print the n1 which is "jinghong"

		println(a1)//here you print the a1 which sould be the number "20"
	}

	//step3
	def step3(): Unit = 
	{
		var N1 : String = "jinghong"//initiating varable N1
    	val A1 : Int = 20//initiating varable A1
		
		var N2: String = "jingyang"//initiating varable N2
		val A2 : Int = 13//initiating varable A2
		
		println("Hello from Chapter 01")
		println(sayHello(N1, A1))//inputing varable N1, A1 into the sayHello functiong and printing the result
		println(sayHello(N2, A2))//inputing varable N2,A2 into the sayHello fuctiong and print the result
		print(s"The oldest Age between $N1 and $N2 is : ")
		println(max(A1, A2))//inputing the A1,A2 into max function
	}

	//used in step3 
	def sayHello(Name: String, Age: Int): String = //defining the sayHello function and returning a string
	{ 
		(s"Hello said from $Name at the age of: $Age")//returning a string with the input name and age 
	}

	//used in step3
	def max(x: Int, y: Int): Int = //defining the max function and returning Int for the function
	{
		if (x>y) {
    		x
		} else {
	    	y
		}
	}

}
