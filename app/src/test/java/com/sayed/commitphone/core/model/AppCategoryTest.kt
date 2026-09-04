package com.sayed.commitphone.core.model

import org.junit.Assert.assertEquals
import org.junit.Test

class AppCategoryTest {
    @Test
    fun coreCategoryExists() {
        assertEquals(AppCategory.CORE, AppCategory.valueOf("CORE"))
    }

    @Test
    fun allCategoriesAreDefined() {
        assertEquals(8, AppCategory.entries.size)
    }

    @Test
    fun disallowedCategoryExists() {
        assertEquals(AppCategory.DISALLOWED, AppCategory.valueOf("DISALLOWED"))
    }
}
