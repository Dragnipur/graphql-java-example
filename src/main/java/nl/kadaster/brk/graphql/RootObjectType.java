/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 oEmbedler Inc. and Contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 *  rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 *  persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package nl.kadaster.brk.graphql;

import com.oembedler.moon.graphql.engine.stereotype.GraphQLField;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLIn;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLObject;
import nl.kadaster.brk.graphql.kadastraalobject.KadastraalObject;
import nl.kadaster.brk.graphql.kadastraalobject.KadastraleAanduiding;
import org.apache.commons.lang3.StringUtils;

@GraphQLObject("Root")
public class RootObjectType {

    @GraphQLField
    public KadastraalObject kadastraalObject(@GraphQLIn("kadastraalObjectId") final String kadastraalObjectId) {
        KadastraalObject ko = null;
        if (StringUtils.isNotBlank(kadastraalObjectId)) {
            ko = new KadastraalObject();
            ko.aanduiding = new KadastraleAanduiding();
            ko.aanduiding.kadastraleGemeente = "Rotterdam";
            ko.aanduiding.sectie = "A";
            ko.aanduiding.perceelNummer = "1234";
            ko.identificatie = new Identificatie("NL.KadastraalObject." + kadastraalObjectId, kadastraalObjectId);
        }
        return ko;
    }

}
