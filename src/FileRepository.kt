package com.example.demo


data class Item(val id:String,val message:String)

interface Repository{
    fun addFile(item: Item):Item
    fun getAllFile():List<Item>
    fun removeFile(id:String)
}

class FileRepository:Repository{

    private val dataSource= mutableMapOf<String,Item>()

    override fun addFile(item: Item): Item {
        dataSource[item.id]=item
        return item
    }

    override fun getAllFile(): List<Item> {
        return dataSource.values.toList()
    }

    override fun removeFile(id: String) {
        dataSource.remove(id)
    }

}