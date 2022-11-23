import org.scalatest.flatspec.AnyFlatSpec

class HelloWorldSpec extends AnyFlatSpec {
  behavior of "Hello World"

  it should "Start with the word 'Hello'" in {
    assert("Hello World".startsWith("Hello"))
  }

  it should "emd with the word 'World'" in {
    assert("Hello World".endsWith("World"))
  }
}