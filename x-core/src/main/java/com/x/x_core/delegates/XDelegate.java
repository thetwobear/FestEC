package com.x.x_core.delegates;

/**
 * Created by 熊猿猿 on 2017/8/8/008.
 */

public abstract class XDelegate extends PermissionCheckerDelegate {

    @SuppressWarnings("unused")
    public <T extends XDelegate> T getParentDelegate() {
        return (T) getParentFragment();
    }
}
