package com.example.onlinebook.api.repository

import androidx.lifecycle.MutableLiveData
import com.example.onlinebook.api.NetworkingMenejer
import com.example.onlinebook.model.*
import com.example.onlinebook.model.base.BaseResponce
import com.example.onlinebook.util.PrefUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


class ShopRepository {

    val compositeDisposable = CompositeDisposable()

    fun getCategories(
        error: MutableLiveData<String>,
        progress: MutableLiveData<Boolean>,
        categoryData: MutableLiveData<List<CategoryModel>>,
    ) {
       progress.value = true
        compositeDisposable.add(
            NetworkingMenejer.getApiServer().get_categories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<BaseResponce<List<CategoryModel>>>(){
                    override fun onNext(t: BaseResponce<List<CategoryModel>>) {
                        progress.value = false
                        if (t.success){
                            categoryData.value = t.data
                        }else{
                            error.value = t.message
                        }
                    }
                    override fun onError(e: Throwable) {
                        error.value = e.localizedMessage
                    }
                    override fun onComplete() {
                    }
                })
        )
    }

    fun getProduct(
        error: MutableLiveData<String>,
        progress: MutableLiveData<Boolean>,
        productData: MutableLiveData<List<ProductModel>>,
    ) {
        progress.value = true
        compositeDisposable.add(
            NetworkingMenejer.getApiServer().get_product()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<BaseResponce<List<ProductModel>>>(){
                    override fun onNext(t: BaseResponce<List<ProductModel>>) {
                        progress.value = false
                        if (t.success){
                            productData.value = t.data
                        }else{
                            error.value = t.message
                        }

                    }

                    override fun onError(e: Throwable) {
                        error.value = e.localizedMessage
                    }

                    override fun onComplete() {

                    }

                })
        )
    }

    fun getOffers(
        error: MutableLiveData<String>,
        progress: MutableLiveData<Boolean>,
        offersData: MutableLiveData<List<OffersModel>>,
    ) {
        progress.value = true
        compositeDisposable.add(
            NetworkingMenejer.getApiServer().getOffers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableObserver<BaseResponce<List<OffersModel>>>(){
                    override fun onNext(t: BaseResponce<List<OffersModel>>) {
                        progress.value = false
                        if (t.success){
                            offersData.value = t.data
                        }else{
                            error.value = t.message
                        }
                    }

                    override fun onError(e: Throwable) {
                        error.value = e.message
                    }

                    override fun onComplete() {

                    }

                })
        )
    }

    fun getCategoryById(
        id: Int,
        error: MutableLiveData<String>,
        progress: MutableLiveData<Boolean>,
        productData: MutableLiveData<List<ProductModel>>,
    ) {
        progress.value = true
        compositeDisposable.add(
            NetworkingMenejer.getApiServer().getCategoryById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableObserver<BaseResponce<List<ProductModel>>>(){
                    override fun onNext(t: BaseResponce<List<ProductModel>>) {
                        progress.value = false
                        if (t.success){
                            productData.value = t.data
                        }else{
                            error.value = t.message
                        }
                    }

                    override fun onError(e: Throwable) {
                        error.value = e.localizedMessage
                    }

                    override fun onComplete() {

                    }

                })
        )

    }

    fun getProductsByIds(
        ids: List<Int>,
        error: MutableLiveData<String>,
        progress: MutableLiveData<Boolean>,
        productData: MutableLiveData<List<ProductModel>>
    ){
        progress.value = true
        compositeDisposable.add(
            NetworkingMenejer.getApiServer().getCart(GetProductByIdsRequest(ids))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<BaseResponce<List<ProductModel>>>() {
                    override fun onNext(t: BaseResponce<List<ProductModel>>) {
                        progress.value = false
                        if (t.success){
                            t.data.forEach {
                                it.cartCount = PrefUtils.getCartCount(it)
                            }
                            productData.value = t.data
                        }else{
                            error.value = t.message
                        }
                    }

                    override fun onError(e: Throwable) {
                        error.value = e.message
                    }

                    override fun onComplete() {
                    }

                })
        )
    }
}