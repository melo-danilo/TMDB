package com.draccoapp.movieapp.api.credentials

import com.draccoapp.movieapp.utils.Constants
import com.draccoapp.movieapp.utils.Env

class ApiCredentials {

    companion object {
        const val publicKey = Env.publicKey
        const val privateKey = Env.privateKey
    }

}