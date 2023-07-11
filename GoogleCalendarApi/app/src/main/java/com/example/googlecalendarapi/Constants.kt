package com.example.googlecalendarapi

object Constants {

    const val CLIENT_ID = "463328813991-angnc81c38voutmamr3j740bmsflp1ko.apps.googleusercontent.com"

    const val AUTHORIZATION_ENDPOINT = "https://accounts.google.com/o/oauth2/v2/auth"

    const val TOKEN_ENDPOINT = "https://oauth2.googleapis.com/token"

    const val REDIRECT_URI = "com.example.googlecalendarapi:/oauth2redirect"

    const val CALENDAR_EVENTS_SCOPE = "https://www.googleapis.com/auth/calendar.events.readonly"

    const val CODE_VERIFIER_CHALLENGE_METHOD = "S256"
    const val MESSAGE_DIGEST_ALGORITHM = "SHA-256"

    const val SHARED_PREFERENCES_NAME = "AUTH_STATE_PREFERENCE"
    const val AUTH_STATE = "AUTH_STATE"

    const val CALENDAR_API = "https://www.googleapis.com/calendar/v3/calendars/primary/events?key=AIzaSyCxkDWf2W7oETglA3XGJ6R4DpL872p4_tg"

}