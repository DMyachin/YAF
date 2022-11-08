package xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces

interface TIViewHasChildren {
    /** Утверждение, что вью имеет ровно [count] дочерних объектов. Внучатые не учитываются */
    fun childrenCountIs(count: Int)

    /** Утверждение, что вью имеет как минимум [count] дочерних объектов. Внучатые не учитываются */
    fun childrenCountAtLeast(count: Int)

    /** Получение количества детей */
    fun childrenCount(): Int
}