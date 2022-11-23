package assertions

import com.h2.entities.Email
import org.scalatest.flatspec.AnyFlatSpec

class EmailsSpec extends AnyFlatSpec {
  behavior of "An Email"

  it should "return an Email object for a valid String" in {
    val email = Email("howdy@google.com")

    assert(email.localPart == "howdy", "Expected local part to be howdy")
    assert(email.domain == "google.com")
  }

  it should "return another Email object for another valid String" in {
    assertResult("jim", "expected local part is jim") {
      Email("jim@google.com").localPart
    }
  }

  it should "throw an exception where an email does not contain the '@' symbol" in {
    withClue("expected exception since email does not have @") {
    assertThrows[IllegalArgumentException] {
      Email("jim.com")
    }
  }
  }

  it should "throw an exception where an email contains more than one '@' symbol" in {
    assertThrows[IllegalArgumentException] {
      Email("jim@@.com")
    }
  }

  it should "intercept the correct error message when no '@' symbol is provided" in {
    val exception = intercept[IllegalArgumentException]{
      Email("google.com")
    }

    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("does not contain '@'"))
  }

  it should "intercept the correct error message when more then one '@' symbol is provided" in {
    val exception = intercept[IllegalArgumentException] {
      Email("jim@2@google.com")
    }

    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("should not contain '@'"))
  }


}
