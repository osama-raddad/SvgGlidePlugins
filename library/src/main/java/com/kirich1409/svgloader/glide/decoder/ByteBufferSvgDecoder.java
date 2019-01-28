/*
 * Copyright 2018 Kirill Rozov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kirich1409.svgloader.glide.decoder;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.ByteBufferUtil;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import com.kirich1409.svgloader.glide.utils.SizeUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class ByteBufferSvgDecoder extends SvgDecoder<ByteBuffer> {

    @Override
    SVG loadSvg(ByteBuffer source, int width, int height, @NonNull Options options)
            throws Exception {
        try (InputStream is = ByteBufferUtil.toStream(source)) {
            return SVG.getFromInputStream(is);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    protected int getSize(@NonNull ByteBuffer source) {
        return SizeUtils.getSize(source);
    }
}
