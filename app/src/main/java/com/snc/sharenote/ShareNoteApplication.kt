package com.snc.sharenote

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class ShareNoteApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // 다른 초기화 코드들

        // Kakao SDK 초기화
        KakaoSdk.init(this, "dd23c2750d6bd625c03699d26f999737")
    }
}