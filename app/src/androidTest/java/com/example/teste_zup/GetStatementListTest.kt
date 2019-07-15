package com.example.teste_zup


import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import com.example.teste_zup.ui.activity.LoginActivity
import org.junit.Rule


import org.junit.Test

@LargeTest
class GetStatementListTest {

        @Rule
        @JvmField
        var statementRule : IntentsTestRule<LoginActivity> = IntentsTestRule(LoginActivity::class.java)

        @Test
        fun verificarListaStatement(){

                onView(withId(R.id.edtLogin)).perform(typeText("test_user"))

                onView(withId(R.id.edtPassword)).perform(typeText("Test@1"))

                onView(withId(R.id.btnLogin)).perform(closeSoftKeyboard(),click())

                Thread.sleep(4000)

                intended(hasComponent("com.example.teste_zup.ui.activity.MainActivity"))

        }

}