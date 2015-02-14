package helpers

import world.model.City

object PageHelper {

  // Number of pages required, given the number of records and records per page
	def pagesRequired(records : Int, perPage: Int) : Int = {
    val hasRemainder = if(records % perPage > 0) 1 else 0
    (records / perPage) + hasRemainder
  }
  
  // Helper to display page navigator
  def rangeRequired(total: Int, current: Int, max: Int): (Int, Int) = {
    if(max > total) (1, total)
    else if(current + max <= total) (current, current + (max - 1))
    else((total - max) + 1, total)
  }
  
  def citiesCounter(totalCities: Int, totalPages : Int, currentPage: Int, perPage: Int) = {
    val recordFrom = ((currentPage * perPage) + 1) - perPage
    val recordTo = if(currentPage * perPage > totalCities) totalCities else currentPage * perPage
    s"Displaying $recordFrom to $recordTo of $totalCities cities"  
    
  }
	
}