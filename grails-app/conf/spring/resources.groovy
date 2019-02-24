import com.giri.validity.MetaPhoneAlgorithm

// Place your Spring DSL code here
beans = {
    metaPhoneAlgorithm(MetaPhoneAlgorithm) {
        maxCodecLength = 4
    }
}
