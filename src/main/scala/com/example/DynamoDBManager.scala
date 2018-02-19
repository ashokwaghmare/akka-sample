//package com.example
//
//import java.util
//
//import com.amazonaws.client.builder.AwsClientBuilder
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
//import com.amazonaws.services.dynamodbv2.document.DynamoDB
//import com.amazonaws.services.dynamodbv2.model._
//
//object DynamoDBManager extends App{
//
///*
//    val client = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
//      "http://localhost:8000", "us-west-2")).build()
//    val db = new DynamoDB(client)
//
//  db
//*/
//
//  /*TableCollection<ListTablesResult> tables = dynamoDB.listTables();
//  Iterator<Table> iterator = tables.iterator();
//
//  val table = db.getTable(tableName);*/
//
//
//
//  /*val tableName = "Products";
//
//  try {
//    System.out.println("Creating the table, wait...");
//    val table = db.createTable(tableName,
//      util.Arrays.asList (
//        new KeySchemaElement("ID", KeyType.HASH), // the partition key
//        // the sort key
//        new KeySchemaElement("Nomenclature", KeyType.RANGE)
//      ),
//      util.Arrays.asList (
//        new AttributeDefinition("ID", ScalarAttributeType.N),
//        new AttributeDefinition("Nomenclature", ScalarAttributeType.S)
//      ),
//      new ProvisionedThroughput(10L, 10L)
//    );
//
//    table.waitForActive();
//    println("Table created successfully.  Status: " +table.getDescription().getTableStatus());
//
//  } catch {
//    case e: Exception =>
//      println(e.getMessage())
//  }*/
//
//}
