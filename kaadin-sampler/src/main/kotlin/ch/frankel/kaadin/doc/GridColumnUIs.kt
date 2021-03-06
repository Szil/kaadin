package ch.frankel.kaadin.doc

import ch.frankel.kaadin.*
import com.vaadin.data.util.*
import com.vaadin.server.*
import com.vaadin.ui.*
import java.text.SimpleDateFormat
import java.util.*

// tag::gridcolumnui[]
class GridColumnLambdaUI() : UI() {
    val data = BeanItemContainer<Person>(Person::class.java, Person.all)
    override fun init(request: VaadinRequest) {
        grid(dataSource = data) {
            column("firstName") {
                expandRatio = 20
                setLastFrozenColumn()
            }
        }
    }
}
// end::gridcolumnui[]

class GridColumnRendererUI() : UI() {
    val data = BeanItemContainer<Person>(Person::class.java, Person.all)
    override fun init(request: VaadinRequest) {
        // tag::gridcolumnrenderui[]
        grid(dataSource = data) {
            column("firstName").buttonRenderer { println(it) }
        }
        // end::gridcolumnrenderui[]
    }
}

class GridColumnConverterUI() : UI() {
    val data = BeanItemContainer<Person>(Person::class.java, Person.all)
    override fun init(request: VaadinRequest) {
        // tag::gridcolumnconvertui[]
        grid(dataSource = data) {
            column("birthDate").dateConverter()
        }
        // end::gridcolumnconvertui[]
    }
}

class GridColumnCustomConverterUI() : UI() {
    val data = BeanItemContainer<Person>(Person::class.java, Person.all)
    override fun init(request: VaadinRequest) {
        // tag::gridcolumncustomconvertui[]
        val dateFormat = "dd.MM.yyyy"
        grid(dataSource = data) {
            column("birthDate").converter(
                    Date::class.java, //<1>
                    String::class.java, //<2>
                    { date -> SimpleDateFormat(dateFormat).format(date) } //<3>
            )
        }
        // end::gridcolumncustomconvertui[]
    }
}
