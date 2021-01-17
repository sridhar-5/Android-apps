open class item(val name:String,val price:Int)

class Noodles:item("Noodles",10){
    override fun toString():String{
        return name
    }
}
class vegetables(vararg val toppings:String):item("vegetables",5){
    override fun toString():String{
        if(toppings.isEmpty()){
            return "$name chef's choice"
        }
        else{
            return name + " " + toppings.joinToString()
        }
    }
}
class order(val ordernumber:Int){
   private val itemlist = mutableListOf<item>()
   
   fun additem(newitem:item):order{
       itemlist.add(newitem)
       return this
   }
   fun addallitem(newitem:List<item>):order{
       itemlist.addAll(newitem)
       return this
   }
   fun print(){
       println("order #${ordernumber}")
       var total = 0
       for(item in itemlist){
           println("${item} : $${item.price}")
           total = total + item.price
       }
       println("Total : $${total}")
   }
}

fun main(){
    val orderlist = mutableListOf<order>()
    
    //here is the order 1
    val order1 = order(1)
    order1.additem(Noodles())
    orderlist.add(order1)
    
    //printing the order
    for(order in orderlist){
        order.print()
        println()
    }
}