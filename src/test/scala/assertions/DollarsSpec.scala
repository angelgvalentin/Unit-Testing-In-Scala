package assertions

import com.h2.entities.Dollars
import org.scalatest.flatspec.AnyFlatSpec

class DollarsSpec extends AnyFlatSpec{
  behavior of "A Dollar"

  it should "create a Dollar object for number 10 as input" in {
   val tenDollars =  Dollars(10)

    assert("$10" == tenDollars.toString)
  }

  it should "correctly identify that $10 > $5" in {
    val tenDollars = Dollars(10)
    val fiveDollars = Dollars(5)
    assert(tenDollars > fiveDollars)
  }

  it should "correctly identify that $2 < $10" in {
    val tenDollars = Dollars(10)
    val twoDollars = Dollars(2)
    assert(  twoDollars < tenDollars)
  }


  it should "correctly add two Dollar amounts" in {
    val tenDollars = Dollars(10)
    val twoDollars = Dollars(2)
   assertResult("$12") {
     (tenDollars + twoDollars).toString
   }
  }

  it should "correctly subtract two Dollar amounts" in {
    val tenDollars = Dollars(10)
    val twoDollars = Dollars(2)
    assertResult("$8") {
      (tenDollars - twoDollars).toString
    }
  }

  it should "correctly identify 4 Dollars equals 4 Dollars" in {
    val fourDollars = Dollars(4)
    assertResult(true) {
      fourDollars == fourDollars
    }
  }

  it should "throw an exception when an invalid integer is provided" in {
    assertThrows[ArithmeticException]{
      Dollars(10 / 0)
    }
  }

  it should "have every dollar more than 0" in {
//    val dollars  = List(Dollars(20), Dollars(100), Dollars(10))
    val dollars : List[Dollars] = List.empty

    assume(dollars.nonEmpty, "--> the dollars coming from api should not be empty")

    dollars.foreach(d => {
      assert( d.amount > 0)
    })
  }
}
