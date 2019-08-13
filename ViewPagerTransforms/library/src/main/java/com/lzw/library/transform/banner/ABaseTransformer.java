/*
 * Copyright 2014 Toxic Bakery
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lzw.library.transform.banner;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 * @Description 抽象的基类，主要是封装了PageTransformer的view的动画的默认值
 *
 * 用来处理ViewPager的切换动画的
 */
public abstract class ABaseTransformer implements  ViewPager.PageTransformer{

    /**
     * Apply a property transformation to the given page.
     *
     * @param page     Apply the transformation to this page
     * @param position Position of page relative to the current front-and-center
     *                 position of the pager. 0 is front and center. 1 is one full
     *                 page position to the right, and -1 is one page position to the left.
     */
    @Override
    public void transformPage(View page, float position) {
        onPreTransform(page, position);
        onTransform(page, position);
        onPostTransform(page, position);
    }

    /**
     * Called each {@link #transformPage(View, float)} before {{@link #onTransform(View, float)}.
     * <p>
     * The default implementation attempts to reset all view properties.
     * This is useful when toggling transforms that do not modify the same page properties.
     * For instance changing from a transformation that applies rotation to a transformation that
     * fades can inadvertently leave a fragment stuck with a rotation or with some degree of
     * applied alpha.
     *
     * @param page     Apply the transformation to this page
     * @param position Position of page relative to the current front-and-center position of the pager.
     *                 0 is front and center. 1 is one full page position to the right,
     *                 and -1 is one page position to the left.
     */
    protected void onPreTransform(View page, float position) {
        final float width = page.getWidth();

        page.setPivotX(0);//x轴中心点
        page.setPivotY(0);//y中心点

        page.setRotationX(0);
        page.setRotationY(0);
        page.setRotation(0);

        page.setScaleX(1);
        page.setScaleY(1);

        page.setTranslationY(0);
        page.setTranslationX(isPagingEnabled() ? 0f : -width * position);

        if (hideOffscreenPages()) {
            page.setAlpha(position <= -1f || position >= 1f ? 0f : 1f);
            //			page.setEnabled(false);
        } else {
            //			page.setEnabled(true);
            page.setAlpha(1f);
        }
    }

    /**
     * Called each {@link #transformPage(View, float)} after {@link #onTransform(View, float)}.
     *
     * @param page     Apply the transformation to this page
     * @param position Position of page relative to the current front-and-center position of the pager.
     *                0 is front and center. 1 is one full page position to the right,
     *                and -1 is one page position to the left.
     */
    protected abstract void onTransform(View page, float position);

    /**
     * Called each {@link #transformPage(View, float)} after {@link #onTransform(View, float)}.
     *
     * @param page     Apply the transformation to this page
     * @param position Position of page relative to the current front-and-center position of the pager.
     *                0 is front and center. 1 is one full page position to the right,
     *                and -1 is one page position to the left.
     */
    protected void onPostTransform(View page, float position) {
    }


    /**
     * @Description
     * 如果fragment的位置偏移小于-1或大于1，则返回true，将fragment的alpha设置为0F。
     * 否则fragment的alpha总是默认为1F。
     * @return
     */
    protected boolean hideOffscreenPages() {
        return true;
    }

    /**
     *
     * @Description 表示view pager 默认的动画是否被使用
     * @return
     */
    protected boolean isPagingEnabled() {
        return false;
    }


    /**
     * @Description Same as {@link Math#min(double, double)} without double casting,
     *                zero closest to infinity handling, or NaN support.
     *
     * @param val
     * @param minValue
     * @return
     */
    protected static final float min(float val, float minValue) {
        return val < minValue ? minValue : val;
    }

}
