package com.wordnik.client.api

import com.wordnik.client.model.Order
import com.wordnik.client.model.Error
import java.math.BigDecimal
import java.util.Date
import com.wordnik.client.model.Inline_response_200_1

import java.io.File

import org.scalatra.{ TypedParamSupport, ScalatraServlet }
import org.scalatra.swagger._
import org.json4s._
import org.json4s.JsonDSL._
import org.scalatra.json.{ JValueResult, JacksonJsonSupport }
import org.scalatra.servlet.{FileUploadSupport, MultipartConfig, SizeConstraintExceededException}

import scala.collection.JavaConverters._

class OrderApi (implicit val swagger: Swagger) extends ScalatraServlet 
    with FileUploadSupport
    with JacksonJsonSupport
    with SwaggerSupport {
  protected implicit val jsonFormats: Formats = DefaultFormats

  protected val applicationDescription: String = "OrderApi"
  override protected val applicationName: Option[String] = Some("Order")

  before() {
    contentType = formats("json")
    response.headers += ("Access-Control-Allow-Origin" -> "*")
  }
  

  val order.getOrdersOperation = (apiOperation[List[Order]]("order.getOrders")
      summary "Get your orders."
      parameters(queryParam[String]("symbol").description("").optional,
        queryParam[String]("filter").description("").optional,
        queryParam[String]("columns").description("").optional,
        queryParam[BigDecimal]("count").description("").optional.defaultValue(100),
        queryParam[BigDecimal]("start").description("").optional.defaultValue(0),
        queryParam[Boolean]("reverse").description("").optional.defaultValue(false),
        queryParam[Date]("startTime").description("").optional,
        queryParam[Date]("endTime").description("").optional)
  )

  get("/order",operation(order.getOrdersOperation)) {
    
    
    
        
      
      val symbol = params.getAs[String]("symbol")
            

    
    println("symbol: " + symbol)
  
    
    
        
      
      val filter = params.getAs[String]("filter")
            

    
    println("filter: " + filter)
  
    
    
        
      
      val columns = params.getAs[String]("columns")
            

    
    println("columns: " + columns)
  
    
    
        
      
      val count = params.getAs[BigDecimal]("count")
            

    
    println("count: " + count)
  
    
    
        
      
      val start = params.getAs[BigDecimal]("start")
            

    
    println("start: " + start)
  
    
    
        
      
      val reverse = params.getAs[Boolean]("reverse")
            

    
    println("reverse: " + reverse)
  
    
    
        
      
      val startTime = params.getAs[Date]("startTime")
            

    
    println("startTime: " + startTime)
  
    
    
        
      
      val endTime = params.getAs[Date]("endTime")
            

    
    println("endTime: " + endTime)
  
  }

  

  val order.amendOperation = (apiOperation[Order]("order.amend")
      summary "Amend the quantity or price of an open order."
      parameters(formParam[String]("orderID").description("").optional,
        formParam[String]("clOrdID").description("").optional,
        formParam[Double]("simpleOrderQty").description("").optional,
        formParam[BigDecimal]("orderQty").description("").optional,
        formParam[Double]("simpleLeavesQty").description("").optional,
        formParam[BigDecimal]("leavesQty").description("").optional,
        formParam[Double]("price").description("").optional,
        formParam[Double]("stopPx").description("").optional,
        formParam[Double]("pegOffsetValue").description("").optional,
        formParam[String]("text").description("").optional)
  )

  put("/order",operation(order.amendOperation)) {
    
    
    
                
      val orderID = params.getAs[String]("orderID")
    

    
    println("orderID: " + orderID)
  
    
    
                
      val clOrdID = params.getAs[String]("clOrdID")
    

    
    println("clOrdID: " + clOrdID)
  
    
    
                
      val simpleOrderQty = params.getAs[Double]("simpleOrderQty")
    

    
    println("simpleOrderQty: " + simpleOrderQty)
  
    
    
                
      val orderQty = params.getAs[BigDecimal]("orderQty")
    

    
    println("orderQty: " + orderQty)
  
    
    
                
      val simpleLeavesQty = params.getAs[Double]("simpleLeavesQty")
    

    
    println("simpleLeavesQty: " + simpleLeavesQty)
  
    
    
                
      val leavesQty = params.getAs[BigDecimal]("leavesQty")
    

    
    println("leavesQty: " + leavesQty)
  
    
    
                
      val price = params.getAs[Double]("price")
    

    
    println("price: " + price)
  
    
    
                
      val stopPx = params.getAs[Double]("stopPx")
    

    
    println("stopPx: " + stopPx)
  
    
    
                
      val pegOffsetValue = params.getAs[Double]("pegOffsetValue")
    

    
    println("pegOffsetValue: " + pegOffsetValue)
  
    
    
                
      val text = params.getAs[String]("text")
    

    
    println("text: " + text)
  
  }

  

  val order.newOperation = (apiOperation[Order]("order.new")
      summary "Create a new order."
      parameters(formParam[String]("symbol").description(""),
        formParam[String]("side").description("").optional,
        formParam[Double]("simpleOrderQty").description("").optional,
        formParam[BigDecimal]("quantity").description("").optional,
        formParam[BigDecimal]("orderQty").description("").optional,
        formParam[Double]("price").description("").optional,
        formParam[BigDecimal]("displayQty").description("").optional,
        formParam[Double]("stopPrice").description("").optional,
        formParam[Double]("stopPx").description("").optional,
        formParam[String]("clOrdID").description("").optional,
        formParam[String]("clOrdLinkID").description("").optional,
        formParam[Double]("pegOffsetValue").description("").optional,
        formParam[String]("pegPriceType").description("").optional,
        formParam[String]("type").description("").optional,
        formParam[String]("ordType").description("").optional.defaultValue(Limit),
        formParam[String]("timeInForce").description("").optional,
        formParam[String]("execInst").description("").optional,
        formParam[String]("contingencyType").description("").optional,
        formParam[String]("text").description("").optional)
  )

  post("/order",operation(order.newOperation)) {
    
    
    
                
      val symbol = params.getAs[String]("symbol")
    

    
    println("symbol: " + symbol)
  
    
    
                
      val side = params.getAs[String]("side")
    

    
    println("side: " + side)
  
    
    
                
      val simpleOrderQty = params.getAs[Double]("simpleOrderQty")
    

    
    println("simpleOrderQty: " + simpleOrderQty)
  
    
    
                
      val quantity = params.getAs[BigDecimal]("quantity")
    

    
    println("quantity: " + quantity)
  
    
    
                
      val orderQty = params.getAs[BigDecimal]("orderQty")
    

    
    println("orderQty: " + orderQty)
  
    
    
                
      val price = params.getAs[Double]("price")
    

    
    println("price: " + price)
  
    
    
                
      val displayQty = params.getAs[BigDecimal]("displayQty")
    

    
    println("displayQty: " + displayQty)
  
    
    
                
      val stopPrice = params.getAs[Double]("stopPrice")
    

    
    println("stopPrice: " + stopPrice)
  
    
    
                
      val stopPx = params.getAs[Double]("stopPx")
    

    
    println("stopPx: " + stopPx)
  
    
    
                
      val clOrdID = params.getAs[String]("clOrdID")
    

    
    println("clOrdID: " + clOrdID)
  
    
    
                
      val clOrdLinkID = params.getAs[String]("clOrdLinkID")
    

    
    println("clOrdLinkID: " + clOrdLinkID)
  
    
    
                
      val pegOffsetValue = params.getAs[Double]("pegOffsetValue")
    

    
    println("pegOffsetValue: " + pegOffsetValue)
  
    
    
                
      val pegPriceType = params.getAs[String]("pegPriceType")
    

    
    println("pegPriceType: " + pegPriceType)
  
    
    
                
      val type = params.getAs[String]("type")
    

    
    println("type: " + type)
  
    
    
                
      val ordType = params.getAs[String]("ordType")
    

    
    println("ordType: " + ordType)
  
    
    
                
      val timeInForce = params.getAs[String]("timeInForce")
    

    
    println("timeInForce: " + timeInForce)
  
    
    
                
      val execInst = params.getAs[String]("execInst")
    

    
    println("execInst: " + execInst)
  
    
    
                
      val contingencyType = params.getAs[String]("contingencyType")
    

    
    println("contingencyType: " + contingencyType)
  
    
    
                
      val text = params.getAs[String]("text")
    

    
    println("text: " + text)
  
  }

  

  val order.cancelOperation = (apiOperation[List[Order]]("order.cancel")
      summary "Cancel order(s). Send multiple order IDs to cancel in bulk."
      parameters(formParam[String]("orderID").description("").optional,
        formParam[String]("clOrdID").description("").optional,
        formParam[String]("text").description("").optional)
  )

  delete("/order",operation(order.cancelOperation)) {
    
    
    
                
      val orderID = params.getAs[String]("orderID")
    

    
    println("orderID: " + orderID)
  
    
    
                
      val clOrdID = params.getAs[String]("clOrdID")
    

    
    println("clOrdID: " + clOrdID)
  
    
    
                
      val text = params.getAs[String]("text")
    

    
    println("text: " + text)
  
  }

  

  val order.cancelAllOperation = (apiOperation[Inline_response_200_1]("order.cancelAll")
      summary "Cancels all of your orders."
      parameters(formParam[String]("symbol").description("").optional,
        formParam[String]("filter").description("").optional,
        formParam[String]("text").description("").optional)
  )

  delete("/order/all",operation(order.cancelAllOperation)) {
    
    
    
                
      val symbol = params.getAs[String]("symbol")
    

    
    println("symbol: " + symbol)
  
    
    
                
      val filter = params.getAs[String]("filter")
    

    
    println("filter: " + filter)
  
    
    
                
      val text = params.getAs[String]("text")
    

    
    println("text: " + text)
  
  }

  

  val order.amendBulkOperation = (apiOperation[List[Order]]("order.amendBulk")
      summary "Amend multiple orders."
      parameters(formParam[String]("orders").description("").optional)
  )

  put("/order/bulk",operation(order.amendBulkOperation)) {
    
    
    
                
      val orders = params.getAs[String]("orders")
    

    
    println("orders: " + orders)
  
  }

  

  val order.newBulkOperation = (apiOperation[List[Order]]("order.newBulk")
      summary "Create multiple new orders."
      parameters(formParam[String]("orders").description("").optional)
  )

  post("/order/bulk",operation(order.newBulkOperation)) {
    
    
    
                
      val orders = params.getAs[String]("orders")
    

    
    println("orders: " + orders)
  
  }

  

  val order.cancelAllAfterOperation = (apiOperation[Inline_response_200_1]("order.cancelAllAfter")
      summary "Automatically cancel all your orders after a specified timeout."
      parameters(formParam[Double]("timeout").description(""))
  )

  post("/order/cancelAllAfter",operation(order.cancelAllAfterOperation)) {
    
    
    
                
      val timeout = params.getAs[Double]("timeout")
    

    
    println("timeout: " + timeout)
  
  }

  

  val order.closePositionOperation = (apiOperation[Order]("order.closePosition")
      summary "Close a position. [Deprecated, use POST /order with execInst: 'Close']"
      parameters(formParam[String]("symbol").description(""),
        formParam[Double]("price").description("").optional)
  )

  post("/order/closePosition",operation(order.closePositionOperation)) {
    
    
    
                
      val symbol = params.getAs[String]("symbol")
    

    
    println("symbol: " + symbol)
  
    
    
                
      val price = params.getAs[Double]("price")
    

    
    println("price: " + price)
  
  }

}