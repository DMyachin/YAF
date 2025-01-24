package xyz.myachin.yaf.core.exceptions

open class TException(message: String) : Exception(message)

class TLaunchActivityNotExistsError(pkgName: String) :
    TException("Package $pkgName has not own launch activity")