package world.model

class City(val name: String, val countryCode: String, val district: String, val population: Integer) {
  override def toString() = "(" + this.name + ", " + this.countryCode + ", " + this.district + ", " + this.population + ")"
}
class Country(val name: String, val region: String, val surfaceArea: Double, val population: Integer) {
  override def toString() = "(" + this.name + ", " + this.region + ", " + this.surfaceArea + ", " + this.population + ")"
}
class CountryLanguage(val countryCode: String, val language: String, val isOfficial: Boolean, val percentage: Double) {
  override def toString() = "(" + this.countryCode + ", " + this.language + ", " + this.isOfficial + ", " + this.percentage + ")"
}