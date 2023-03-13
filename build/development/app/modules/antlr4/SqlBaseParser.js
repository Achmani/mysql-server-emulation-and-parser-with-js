"use strict";
// Generated from app/modules/antlr4/SqlBase.g4 by ANTLR 4.9.0-SNAPSHOT
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    Object.defineProperty(o, k2, { enumerable: true, get: function() { return m[k]; } });
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (k !== "default" && Object.hasOwnProperty.call(mod, k)) __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.NonReservedContext = exports.IntegerLiteralContext = exports.DoubleLiteralContext = exports.DecimalLiteralContext = exports.NumberContext = exports.DigitIdentifierContext = exports.BackQuotedIdentifierContext = exports.QuotedIdentifierContext = exports.UnquotedIdentifierContext = exports.IdentifierContext = exports.RolesContext = exports.UnspecifiedPrincipalContext = exports.RolePrincipalContext = exports.UserPrincipalContext = exports.PrincipalContext = exports.SpecifiedPrincipalContext = exports.CurrentRoleGrantorContext = exports.CurrentUserGrantorContext = exports.GrantorContext = exports.TableNameWithAliasesContext = exports.QualifiedNameContext = exports.PrivilegeContext = exports.NamedArgumentContext = exports.PositionalArgumentContext = exports.CallArgumentContext = exports.SerializableContext = exports.RepeatableReadContext = exports.ReadCommittedContext = exports.ReadUncommittedContext = exports.LevelOfIsolationContext = exports.TransactionAccessModeContext = exports.IsolationLevelContext = exports.TransactionModeContext = exports.ExplainTypeContext = exports.ExplainFormatContext = exports.ExplainOptionContext = exports.BoundedFrameContext = exports.CurrentRowBoundContext = exports.UnboundedFrameContext = exports.FrameBoundContext = exports.WindowFrameContext = exports.OverContext = exports.FilterContext = exports.WhenClauseContext = exports.BaseTypeContext = exports.TypeParameterContext = exports.TypeContext = exports.TypesContext = exports.NormalFormContext = exports.IntervalFieldContext = exports.IntervalContext = exports.BooleanValueContext = exports.ComparisonQuantifierContext = exports.ComparisonOperatorContext = exports.TimeZoneStringContext = exports.TimeZoneIntervalContext = exports.TimeZoneSpecifierContext = exports.NullTreatmentContext = exports.UnicodeStringLiteralContext = exports.BasicStringLiteralContext = exports.StringContext = exports.GroupingOperationContext = exports.ParenthesizedExpressionContext = exports.ExtractContext = exports.NormalizeContext = exports.SubstringContext = exports.CurrentUserContext = exports.SpecialDateTimeFunctionContext = exports.DereferenceContext = exports.ColumnReferenceContext = exports.SubscriptContext = exports.ArrayConstructorContext = exports.CastContext = exports.SearchedCaseContext = exports.SimpleCaseContext = exports.ExistsContext = exports.SubqueryExpressionContext = exports.LambdaContext = exports.FunctionCallContext = exports.RowConstructorContext = exports.PositionContext = exports.ParameterContext = exports.BinaryLiteralContext = exports.StringLiteralContext = exports.BooleanLiteralContext = exports.NumericLiteralContext = exports.TypeConstructorContext = exports.IntervalLiteralContext = exports.NullLiteralContext = exports.PrimaryExpressionContext = exports.ConcatenationContext = exports.ArithmeticBinaryContext = exports.ArithmeticUnaryContext = exports.AtTimeZoneContext = exports.ValueExpressionDefaultContext = exports.ValueExpressionContext = exports.DistinctFromContext = exports.NullPredicateContext = exports.LikeContext = exports.InSubqueryContext = exports.InListContext = exports.BetweenContext = exports.QuantifiedComparisonContext = exports.ComparisonContext = exports.PredicateContext = exports.LogicalBinaryContext = exports.LogicalNotContext = exports.PredicatedContext = exports.BooleanExpressionContext = exports.HavingExpressionContext = exports.UpdateExpressionContext = exports.WhereExpressionContext = exports.ExpressionContext = exports.ParenthesizedRelationContext = exports.LateralContext = exports.UnnestContext = exports.SubqueryRelationContext = exports.TableNameContext = exports.RelationPrimaryContext = exports.ColumnAliasesContext = exports.AliasedRelationContext = exports.SampleTypeContext = exports.SampledRelationContext = exports.JoinCriteriaContext = exports.JoinTypeContext = exports.RelationDefaultContext = exports.JoinRelationContext = exports.RelationContext = exports.SelectAllContext = exports.SelectContext = exports.SelectItemContext = exports.SetQuantifierContext = exports.NamedQueryContext = exports.GroupingSetContext = exports.MultipleGroupingSetsContext = exports.CubeContext = exports.RollupContext = exports.SingleGroupingSetContext = exports.GroupingElementContext = exports.GroupByContext = exports.QuerySpecificationContext = exports.SortItemContext = exports.SubqueryContext = exports.InlineTableContext = exports.TableContext = exports.QueryPrimaryDefaultContext = exports.QueryPrimaryContext = exports.SetOperationContext = exports.QueryTermDefaultContext = exports.QueryTermContext = exports.QueryNoWithContext = exports.ExternalRoutineNameContext = exports.NullCallClauseContext = exports.DeterminismContext = exports.LanguageContext = exports.ExternalBodyReferenceContext = exports.ReturnStatementContext = exports.RoutineBodyContext = exports.AlterRoutineCharacteristicContext = exports.AlterRoutineCharacteristicsContext = exports.RoutineCharacteristicContext = exports.RoutineCharacteristicsContext = exports.SqlParameterDeclarationContext = exports.PropertyContext = exports.PropertiesContext = exports.LikeClauseContext = exports.ColumnDefinitionContext = exports.TableElementContext = exports.QueryWithContext = exports.QueryContext = exports.DescribeOutputContext = exports.DescribeInputContext = exports.ExecuteContext = exports.DeallocateContext = exports.PrepareContext = exports.RollbackContext = exports.CommitContext = exports.StartTransactionContext = exports.ResetSessionContext = exports.SetSessionContext = exports.ShowSessionContext = exports.ShowFunctionsContext = exports.ShowRoleGrantsContext = exports.ShowRolesContext = exports.ShowStatsForQueryContext = exports.ShowStatsContext = exports.ShowColumnsContext = exports.ShowCatalogsContext = exports.ShowSchemasContext = exports.ShowTablesContext = exports.ShowCreateFunctionContext = exports.ShowCreateMaterializedViewContext = exports.ShowCreateViewContext = exports.ShowCreateTableContext = exports.ExplainContext = exports.ShowGrantsContext = exports.RevokeContext = exports.GrantContext = exports.SetRoleContext = exports.RevokeRolesContext = exports.GrantRolesContext = exports.DropRoleContext = exports.CreateRoleContext = exports.CallContext = exports.DropFunctionContext = exports.AlterFunctionContext = exports.CreateFunctionContext = exports.RefreshMaterializedViewContext = exports.DropMaterializedViewContext = exports.CreateMaterializedViewContext = exports.DropViewContext = exports.CreateViewContext = exports.CreateTypeContext = exports.AnalyzeContext = exports.AddColumnContext = exports.DropColumnContext = exports.RenameColumnContext = exports.RenameTableContext = exports.DeleteContext = exports.UpdateContext = exports.InsertIntoContext = exports.DropTableContext = exports.CreateTableContext = exports.CreateTableAsSelectContext = exports.RenameSchemaContext = exports.DropSchemaContext = exports.CreateSchemaContext = exports.UseContext = exports.StatementDefaultContext = exports.StatementContext = exports.StandaloneRoutineBodyContext = exports.StandaloneExpressionContext = exports.SingleStatementContext = exports.SqlBaseParser = void 0;
const ATN_1 = require("antlr4ts/atn/ATN");
const ATNDeserializer_1 = require("antlr4ts/atn/ATNDeserializer");
const FailedPredicateException_1 = require("antlr4ts/FailedPredicateException");
const NoViableAltException_1 = require("antlr4ts/NoViableAltException");
const Parser_1 = require("antlr4ts/Parser");
const ParserRuleContext_1 = require("antlr4ts/ParserRuleContext");
const ParserATNSimulator_1 = require("antlr4ts/atn/ParserATNSimulator");
const RecognitionException_1 = require("antlr4ts/RecognitionException");
const Token_1 = require("antlr4ts/Token");
const VocabularyImpl_1 = require("antlr4ts/VocabularyImpl");
const Utils = __importStar(require("antlr4ts/misc/Utils"));
class SqlBaseParser extends Parser_1.Parser {
    constructor(input) {
        super(input);
        this._interp = new ParserATNSimulator_1.ParserATNSimulator(SqlBaseParser._ATN, this);
    }
    // @Override
    // @NotNull
    get vocabulary() {
        return SqlBaseParser.VOCABULARY;
    }
    // tslint:enable:no-trailing-whitespace
    // @Override
    get grammarFileName() { return "SqlBase.g4"; }
    // @Override
    get ruleNames() { return SqlBaseParser.ruleNames; }
    // @Override
    get serializedATN() { return SqlBaseParser._serializedATN; }
    createFailedPredicateException(predicate, message) {
        return new FailedPredicateException_1.FailedPredicateException(this, predicate, message);
    }
    // @RuleVersion(0)
    singleStatement() {
        let _localctx = new SingleStatementContext(this._ctx, this.state);
        this.enterRule(_localctx, 0, SqlBaseParser.RULE_singleStatement);
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 162;
                this.statement();
                this.state = 163;
                this.match(SqlBaseParser.EOF);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    standaloneExpression() {
        let _localctx = new StandaloneExpressionContext(this._ctx, this.state);
        this.enterRule(_localctx, 2, SqlBaseParser.RULE_standaloneExpression);
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 165;
                this.expression();
                this.state = 166;
                this.match(SqlBaseParser.EOF);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    standaloneRoutineBody() {
        let _localctx = new StandaloneRoutineBodyContext(this._ctx, this.state);
        this.enterRule(_localctx, 4, SqlBaseParser.RULE_standaloneRoutineBody);
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 168;
                this.routineBody();
                this.state = 169;
                this.match(SqlBaseParser.EOF);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    statement() {
        let _localctx = new StatementContext(this._ctx, this.state);
        this.enterRule(_localctx, 6, SqlBaseParser.RULE_statement);
        let _la;
        try {
            this.state = 814;
            this._errHandler.sync(this);
            switch (this.interpreter.adaptivePredict(this._input, 90, this._ctx)) {
                case 1:
                    _localctx = new StatementDefaultContext(_localctx);
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 171;
                        this.query();
                    }
                    break;
                case 2:
                    _localctx = new UseContext(_localctx);
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 172;
                        this.match(SqlBaseParser.USE);
                        this.state = 173;
                        _localctx._schema = this.identifier();
                    }
                    break;
                case 3:
                    _localctx = new UseContext(_localctx);
                    this.enterOuterAlt(_localctx, 3);
                    {
                        this.state = 174;
                        this.match(SqlBaseParser.USE);
                        this.state = 175;
                        _localctx._catalog = this.identifier();
                        this.state = 176;
                        this.match(SqlBaseParser.T__0);
                        this.state = 177;
                        _localctx._schema = this.identifier();
                    }
                    break;
                case 4:
                    _localctx = new CreateSchemaContext(_localctx);
                    this.enterOuterAlt(_localctx, 4);
                    {
                        this.state = 179;
                        this.match(SqlBaseParser.CREATE);
                        this.state = 180;
                        this.match(SqlBaseParser.SCHEMA);
                        this.state = 184;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 0, this._ctx)) {
                            case 1:
                                {
                                    this.state = 181;
                                    this.match(SqlBaseParser.IF);
                                    this.state = 182;
                                    this.match(SqlBaseParser.NOT);
                                    this.state = 183;
                                    this.match(SqlBaseParser.EXISTS);
                                }
                                break;
                        }
                        this.state = 186;
                        this.qualifiedName();
                        this.state = 189;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.WITH) {
                            {
                                this.state = 187;
                                this.match(SqlBaseParser.WITH);
                                this.state = 188;
                                this.properties();
                            }
                        }
                    }
                    break;
                case 5:
                    _localctx = new DropSchemaContext(_localctx);
                    this.enterOuterAlt(_localctx, 5);
                    {
                        this.state = 191;
                        this.match(SqlBaseParser.DROP);
                        this.state = 192;
                        this.match(SqlBaseParser.SCHEMA);
                        this.state = 195;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 2, this._ctx)) {
                            case 1:
                                {
                                    this.state = 193;
                                    this.match(SqlBaseParser.IF);
                                    this.state = 194;
                                    this.match(SqlBaseParser.EXISTS);
                                }
                                break;
                        }
                        this.state = 197;
                        this.qualifiedName();
                        this.state = 199;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.CASCADE || _la === SqlBaseParser.RESTRICT) {
                            {
                                this.state = 198;
                                _la = this._input.LA(1);
                                if (!(_la === SqlBaseParser.CASCADE || _la === SqlBaseParser.RESTRICT)) {
                                    this._errHandler.recoverInline(this);
                                }
                                else {
                                    if (this._input.LA(1) === Token_1.Token.EOF) {
                                        this.matchedEOF = true;
                                    }
                                    this._errHandler.reportMatch(this);
                                    this.consume();
                                }
                            }
                        }
                    }
                    break;
                case 6:
                    _localctx = new RenameSchemaContext(_localctx);
                    this.enterOuterAlt(_localctx, 6);
                    {
                        this.state = 201;
                        this.match(SqlBaseParser.ALTER);
                        this.state = 202;
                        this.match(SqlBaseParser.SCHEMA);
                        this.state = 203;
                        this.qualifiedName();
                        this.state = 204;
                        this.match(SqlBaseParser.RENAME);
                        this.state = 205;
                        this.match(SqlBaseParser.TO);
                        this.state = 206;
                        this.identifier();
                    }
                    break;
                case 7:
                    _localctx = new CreateTableAsSelectContext(_localctx);
                    this.enterOuterAlt(_localctx, 7);
                    {
                        this.state = 208;
                        this.match(SqlBaseParser.CREATE);
                        this.state = 209;
                        this.match(SqlBaseParser.TABLE);
                        this.state = 213;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 4, this._ctx)) {
                            case 1:
                                {
                                    this.state = 210;
                                    this.match(SqlBaseParser.IF);
                                    this.state = 211;
                                    this.match(SqlBaseParser.NOT);
                                    this.state = 212;
                                    this.match(SqlBaseParser.EXISTS);
                                }
                                break;
                        }
                        this.state = 215;
                        this.qualifiedName();
                        this.state = 217;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.T__1) {
                            {
                                this.state = 216;
                                this.columnAliases();
                            }
                        }
                        this.state = 221;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.COMMENT) {
                            {
                                this.state = 219;
                                this.match(SqlBaseParser.COMMENT);
                                this.state = 220;
                                this.string();
                            }
                        }
                        this.state = 225;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.WITH) {
                            {
                                this.state = 223;
                                this.match(SqlBaseParser.WITH);
                                this.state = 224;
                                this.properties();
                            }
                        }
                        this.state = 227;
                        this.match(SqlBaseParser.AS);
                        this.state = 233;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 8, this._ctx)) {
                            case 1:
                                {
                                    this.state = 228;
                                    this.query();
                                }
                                break;
                            case 2:
                                {
                                    this.state = 229;
                                    this.match(SqlBaseParser.T__1);
                                    this.state = 230;
                                    this.query();
                                    this.state = 231;
                                    this.match(SqlBaseParser.T__2);
                                }
                                break;
                        }
                        this.state = 240;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.WITH) {
                            {
                                this.state = 235;
                                this.match(SqlBaseParser.WITH);
                                this.state = 237;
                                this._errHandler.sync(this);
                                _la = this._input.LA(1);
                                if (_la === SqlBaseParser.NO) {
                                    {
                                        this.state = 236;
                                        this.match(SqlBaseParser.NO);
                                    }
                                }
                                this.state = 239;
                                this.match(SqlBaseParser.DATA);
                            }
                        }
                    }
                    break;
                case 8:
                    _localctx = new CreateTableContext(_localctx);
                    this.enterOuterAlt(_localctx, 8);
                    {
                        this.state = 242;
                        this.match(SqlBaseParser.CREATE);
                        this.state = 243;
                        this.match(SqlBaseParser.TABLE);
                        this.state = 247;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 11, this._ctx)) {
                            case 1:
                                {
                                    this.state = 244;
                                    this.match(SqlBaseParser.IF);
                                    this.state = 245;
                                    this.match(SqlBaseParser.NOT);
                                    this.state = 246;
                                    this.match(SqlBaseParser.EXISTS);
                                }
                                break;
                        }
                        this.state = 249;
                        this.qualifiedName();
                        this.state = 250;
                        this.match(SqlBaseParser.T__1);
                        this.state = 251;
                        this.tableElement();
                        this.state = 256;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        while (_la === SqlBaseParser.T__3) {
                            {
                                {
                                    this.state = 252;
                                    this.match(SqlBaseParser.T__3);
                                    this.state = 253;
                                    this.tableElement();
                                }
                            }
                            this.state = 258;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                        }
                        this.state = 259;
                        this.match(SqlBaseParser.T__2);
                        this.state = 262;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.COMMENT) {
                            {
                                this.state = 260;
                                this.match(SqlBaseParser.COMMENT);
                                this.state = 261;
                                this.string();
                            }
                        }
                        this.state = 266;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.WITH) {
                            {
                                this.state = 264;
                                this.match(SqlBaseParser.WITH);
                                this.state = 265;
                                this.properties();
                            }
                        }
                    }
                    break;
                case 9:
                    _localctx = new DropTableContext(_localctx);
                    this.enterOuterAlt(_localctx, 9);
                    {
                        this.state = 268;
                        this.match(SqlBaseParser.DROP);
                        this.state = 269;
                        this.match(SqlBaseParser.TABLE);
                        this.state = 272;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 15, this._ctx)) {
                            case 1:
                                {
                                    this.state = 270;
                                    this.match(SqlBaseParser.IF);
                                    this.state = 271;
                                    this.match(SqlBaseParser.EXISTS);
                                }
                                break;
                        }
                        this.state = 274;
                        this.qualifiedName();
                    }
                    break;
                case 10:
                    _localctx = new InsertIntoContext(_localctx);
                    this.enterOuterAlt(_localctx, 10);
                    {
                        this.state = 275;
                        this.match(SqlBaseParser.INSERT);
                        this.state = 276;
                        this.match(SqlBaseParser.INTO);
                        this.state = 277;
                        this.tableNameWithAliases();
                        this.state = 279;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 16, this._ctx)) {
                            case 1:
                                {
                                    this.state = 278;
                                    this.columnAliases();
                                }
                                break;
                        }
                        this.state = 281;
                        this.query();
                    }
                    break;
                case 11:
                    _localctx = new UpdateContext(_localctx);
                    this.enterOuterAlt(_localctx, 11);
                    {
                        this.state = 283;
                        this.match(SqlBaseParser.UPDATE);
                        this.state = 284;
                        this.tableNameWithAliases();
                        this.state = 285;
                        this.match(SqlBaseParser.SET);
                        this.state = 286;
                        this.updateExpression();
                        this.state = 291;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        while (_la === SqlBaseParser.T__3) {
                            {
                                {
                                    this.state = 287;
                                    this.match(SqlBaseParser.T__3);
                                    this.state = 288;
                                    this.updateExpression();
                                }
                            }
                            this.state = 293;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                        }
                        this.state = 296;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.WHERE) {
                            {
                                this.state = 294;
                                this.match(SqlBaseParser.WHERE);
                                this.state = 295;
                                this.whereExpression();
                            }
                        }
                    }
                    break;
                case 12:
                    _localctx = new DeleteContext(_localctx);
                    this.enterOuterAlt(_localctx, 12);
                    {
                        this.state = 298;
                        this.match(SqlBaseParser.DELETE);
                        this.state = 299;
                        this.match(SqlBaseParser.FROM);
                        this.state = 300;
                        this.qualifiedName();
                        this.state = 303;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.WHERE) {
                            {
                                this.state = 301;
                                this.match(SqlBaseParser.WHERE);
                                this.state = 302;
                                this.whereExpression();
                            }
                        }
                    }
                    break;
                case 13:
                    _localctx = new RenameTableContext(_localctx);
                    this.enterOuterAlt(_localctx, 13);
                    {
                        this.state = 305;
                        this.match(SqlBaseParser.ALTER);
                        this.state = 306;
                        this.match(SqlBaseParser.TABLE);
                        this.state = 309;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 20, this._ctx)) {
                            case 1:
                                {
                                    this.state = 307;
                                    this.match(SqlBaseParser.IF);
                                    this.state = 308;
                                    this.match(SqlBaseParser.EXISTS);
                                }
                                break;
                        }
                        this.state = 311;
                        _localctx._from = this.qualifiedName();
                        this.state = 312;
                        this.match(SqlBaseParser.RENAME);
                        this.state = 313;
                        this.match(SqlBaseParser.TO);
                        this.state = 314;
                        _localctx._to = this.qualifiedName();
                    }
                    break;
                case 14:
                    _localctx = new RenameColumnContext(_localctx);
                    this.enterOuterAlt(_localctx, 14);
                    {
                        this.state = 316;
                        this.match(SqlBaseParser.ALTER);
                        this.state = 317;
                        this.match(SqlBaseParser.TABLE);
                        this.state = 320;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 21, this._ctx)) {
                            case 1:
                                {
                                    this.state = 318;
                                    this.match(SqlBaseParser.IF);
                                    this.state = 319;
                                    this.match(SqlBaseParser.EXISTS);
                                }
                                break;
                        }
                        this.state = 322;
                        _localctx._tableName = this.qualifiedName();
                        this.state = 323;
                        this.match(SqlBaseParser.RENAME);
                        this.state = 324;
                        this.match(SqlBaseParser.COLUMN);
                        this.state = 327;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 22, this._ctx)) {
                            case 1:
                                {
                                    this.state = 325;
                                    this.match(SqlBaseParser.IF);
                                    this.state = 326;
                                    this.match(SqlBaseParser.EXISTS);
                                }
                                break;
                        }
                        this.state = 329;
                        _localctx._from = this.identifier();
                        this.state = 330;
                        this.match(SqlBaseParser.TO);
                        this.state = 331;
                        _localctx._to = this.identifier();
                    }
                    break;
                case 15:
                    _localctx = new DropColumnContext(_localctx);
                    this.enterOuterAlt(_localctx, 15);
                    {
                        this.state = 333;
                        this.match(SqlBaseParser.ALTER);
                        this.state = 334;
                        this.match(SqlBaseParser.TABLE);
                        this.state = 337;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 23, this._ctx)) {
                            case 1:
                                {
                                    this.state = 335;
                                    this.match(SqlBaseParser.IF);
                                    this.state = 336;
                                    this.match(SqlBaseParser.EXISTS);
                                }
                                break;
                        }
                        this.state = 339;
                        _localctx._tableName = this.qualifiedName();
                        this.state = 340;
                        this.match(SqlBaseParser.DROP);
                        this.state = 341;
                        this.match(SqlBaseParser.COLUMN);
                        this.state = 344;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 24, this._ctx)) {
                            case 1:
                                {
                                    this.state = 342;
                                    this.match(SqlBaseParser.IF);
                                    this.state = 343;
                                    this.match(SqlBaseParser.EXISTS);
                                }
                                break;
                        }
                        this.state = 346;
                        _localctx._column = this.qualifiedName();
                    }
                    break;
                case 16:
                    _localctx = new AddColumnContext(_localctx);
                    this.enterOuterAlt(_localctx, 16);
                    {
                        this.state = 348;
                        this.match(SqlBaseParser.ALTER);
                        this.state = 349;
                        this.match(SqlBaseParser.TABLE);
                        this.state = 352;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 25, this._ctx)) {
                            case 1:
                                {
                                    this.state = 350;
                                    this.match(SqlBaseParser.IF);
                                    this.state = 351;
                                    this.match(SqlBaseParser.EXISTS);
                                }
                                break;
                        }
                        this.state = 354;
                        _localctx._tableName = this.qualifiedName();
                        this.state = 355;
                        this.match(SqlBaseParser.ADD);
                        this.state = 356;
                        this.match(SqlBaseParser.COLUMN);
                        this.state = 360;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 26, this._ctx)) {
                            case 1:
                                {
                                    this.state = 357;
                                    this.match(SqlBaseParser.IF);
                                    this.state = 358;
                                    this.match(SqlBaseParser.NOT);
                                    this.state = 359;
                                    this.match(SqlBaseParser.EXISTS);
                                }
                                break;
                        }
                        this.state = 362;
                        _localctx._column = this.columnDefinition();
                    }
                    break;
                case 17:
                    _localctx = new AnalyzeContext(_localctx);
                    this.enterOuterAlt(_localctx, 17);
                    {
                        this.state = 364;
                        this.match(SqlBaseParser.ANALYZE);
                        this.state = 365;
                        this.qualifiedName();
                        this.state = 368;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.WITH) {
                            {
                                this.state = 366;
                                this.match(SqlBaseParser.WITH);
                                this.state = 367;
                                this.properties();
                            }
                        }
                    }
                    break;
                case 18:
                    _localctx = new CreateTypeContext(_localctx);
                    this.enterOuterAlt(_localctx, 18);
                    {
                        this.state = 370;
                        this.match(SqlBaseParser.CREATE);
                        this.state = 371;
                        this.match(SqlBaseParser.TYPE);
                        this.state = 372;
                        this.qualifiedName();
                        this.state = 373;
                        this.match(SqlBaseParser.AS);
                        this.state = 386;
                        this._errHandler.sync(this);
                        switch (this._input.LA(1)) {
                            case SqlBaseParser.T__1:
                                {
                                    this.state = 374;
                                    this.match(SqlBaseParser.T__1);
                                    this.state = 375;
                                    this.sqlParameterDeclaration();
                                    this.state = 380;
                                    this._errHandler.sync(this);
                                    _la = this._input.LA(1);
                                    while (_la === SqlBaseParser.T__3) {
                                        {
                                            {
                                                this.state = 376;
                                                this.match(SqlBaseParser.T__3);
                                                this.state = 377;
                                                this.sqlParameterDeclaration();
                                            }
                                        }
                                        this.state = 382;
                                        this._errHandler.sync(this);
                                        _la = this._input.LA(1);
                                    }
                                    this.state = 383;
                                    this.match(SqlBaseParser.T__2);
                                }
                                break;
                            case SqlBaseParser.ADD:
                            case SqlBaseParser.ADMIN:
                            case SqlBaseParser.ALL:
                            case SqlBaseParser.ANALYZE:
                            case SqlBaseParser.ANY:
                            case SqlBaseParser.ARRAY:
                            case SqlBaseParser.ASC:
                            case SqlBaseParser.AT:
                            case SqlBaseParser.BERNOULLI:
                            case SqlBaseParser.CALL:
                            case SqlBaseParser.CALLED:
                            case SqlBaseParser.CASCADE:
                            case SqlBaseParser.CATALOGS:
                            case SqlBaseParser.COLUMN:
                            case SqlBaseParser.COLUMNS:
                            case SqlBaseParser.COMMENT:
                            case SqlBaseParser.COMMIT:
                            case SqlBaseParser.COMMITTED:
                            case SqlBaseParser.CURRENT:
                            case SqlBaseParser.CURRENT_ROLE:
                            case SqlBaseParser.DATA:
                            case SqlBaseParser.DATE:
                            case SqlBaseParser.DAY:
                            case SqlBaseParser.DEFINER:
                            case SqlBaseParser.DESC:
                            case SqlBaseParser.DETERMINISTIC:
                            case SqlBaseParser.DISTRIBUTED:
                            case SqlBaseParser.EXCLUDING:
                            case SqlBaseParser.EXPLAIN:
                            case SqlBaseParser.EXTERNAL:
                            case SqlBaseParser.FILTER:
                            case SqlBaseParser.FIRST:
                            case SqlBaseParser.FOLLOWING:
                            case SqlBaseParser.FORMAT:
                            case SqlBaseParser.FUNCTION:
                            case SqlBaseParser.FUNCTIONS:
                            case SqlBaseParser.GRANT:
                            case SqlBaseParser.GRANTED:
                            case SqlBaseParser.GRANTS:
                            case SqlBaseParser.GRAPHVIZ:
                            case SqlBaseParser.HOUR:
                            case SqlBaseParser.IF:
                            case SqlBaseParser.IGNORE:
                            case SqlBaseParser.INCLUDING:
                            case SqlBaseParser.INPUT:
                            case SqlBaseParser.INTERVAL:
                            case SqlBaseParser.INVOKER:
                            case SqlBaseParser.IO:
                            case SqlBaseParser.ISOLATION:
                            case SqlBaseParser.JSON:
                            case SqlBaseParser.LANGUAGE:
                            case SqlBaseParser.LAST:
                            case SqlBaseParser.LATERAL:
                            case SqlBaseParser.LEVEL:
                            case SqlBaseParser.LIMIT:
                            case SqlBaseParser.LOGICAL:
                            case SqlBaseParser.MAP:
                            case SqlBaseParser.MATERIALIZED:
                            case SqlBaseParser.MINUTE:
                            case SqlBaseParser.MONTH:
                            case SqlBaseParser.NAME:
                            case SqlBaseParser.NFC:
                            case SqlBaseParser.NFD:
                            case SqlBaseParser.NFKC:
                            case SqlBaseParser.NFKD:
                            case SqlBaseParser.NO:
                            case SqlBaseParser.NONE:
                            case SqlBaseParser.NULLIF:
                            case SqlBaseParser.NULLS:
                            case SqlBaseParser.OFFSET:
                            case SqlBaseParser.ONLY:
                            case SqlBaseParser.OPTION:
                            case SqlBaseParser.ORDINALITY:
                            case SqlBaseParser.OUTPUT:
                            case SqlBaseParser.OVER:
                            case SqlBaseParser.PARTITION:
                            case SqlBaseParser.PARTITIONS:
                            case SqlBaseParser.POSITION:
                            case SqlBaseParser.PRECEDING:
                            case SqlBaseParser.PRIVILEGES:
                            case SqlBaseParser.PROPERTIES:
                            case SqlBaseParser.RANGE:
                            case SqlBaseParser.READ:
                            case SqlBaseParser.REFRESH:
                            case SqlBaseParser.RENAME:
                            case SqlBaseParser.REPEATABLE:
                            case SqlBaseParser.REPLACE:
                            case SqlBaseParser.RESET:
                            case SqlBaseParser.RESPECT:
                            case SqlBaseParser.RESTRICT:
                            case SqlBaseParser.RETURN:
                            case SqlBaseParser.RETURNS:
                            case SqlBaseParser.REVOKE:
                            case SqlBaseParser.ROLE:
                            case SqlBaseParser.ROLES:
                            case SqlBaseParser.ROLLBACK:
                            case SqlBaseParser.ROW:
                            case SqlBaseParser.ROWS:
                            case SqlBaseParser.SCHEMA:
                            case SqlBaseParser.SCHEMAS:
                            case SqlBaseParser.SECOND:
                            case SqlBaseParser.SECURITY:
                            case SqlBaseParser.SERIALIZABLE:
                            case SqlBaseParser.SESSION:
                            case SqlBaseParser.SET:
                            case SqlBaseParser.SETS:
                            case SqlBaseParser.SHOW:
                            case SqlBaseParser.SOME:
                            case SqlBaseParser.SQL:
                            case SqlBaseParser.START:
                            case SqlBaseParser.STATS:
                            case SqlBaseParser.SUBSTRING:
                            case SqlBaseParser.SYSTEM:
                            case SqlBaseParser.TABLES:
                            case SqlBaseParser.TABLESAMPLE:
                            case SqlBaseParser.TEMPORARY:
                            case SqlBaseParser.TEXT:
                            case SqlBaseParser.TIME:
                            case SqlBaseParser.TIMESTAMP:
                            case SqlBaseParser.TO:
                            case SqlBaseParser.TRANSACTION:
                            case SqlBaseParser.TRY_CAST:
                            case SqlBaseParser.TYPE:
                            case SqlBaseParser.UNBOUNDED:
                            case SqlBaseParser.UNCOMMITTED:
                            case SqlBaseParser.USE:
                            case SqlBaseParser.USER:
                            case SqlBaseParser.VALIDATE:
                            case SqlBaseParser.VERBOSE:
                            case SqlBaseParser.VIEW:
                            case SqlBaseParser.WORK:
                            case SqlBaseParser.WRITE:
                            case SqlBaseParser.YEAR:
                            case SqlBaseParser.ZONE:
                            case SqlBaseParser.IDENTIFIER:
                            case SqlBaseParser.DIGIT_IDENTIFIER:
                            case SqlBaseParser.QUOTED_IDENTIFIER:
                            case SqlBaseParser.BACKQUOTED_IDENTIFIER:
                            case SqlBaseParser.TIME_WITH_TIME_ZONE:
                            case SqlBaseParser.TIMESTAMP_WITH_TIME_ZONE:
                            case SqlBaseParser.DOUBLE_PRECISION:
                                {
                                    this.state = 385;
                                    this.type(0);
                                }
                                break;
                            default:
                                throw new NoViableAltException_1.NoViableAltException(this);
                        }
                    }
                    break;
                case 19:
                    _localctx = new CreateViewContext(_localctx);
                    this.enterOuterAlt(_localctx, 19);
                    {
                        this.state = 388;
                        this.match(SqlBaseParser.CREATE);
                        this.state = 391;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.OR) {
                            {
                                this.state = 389;
                                this.match(SqlBaseParser.OR);
                                this.state = 390;
                                this.match(SqlBaseParser.REPLACE);
                            }
                        }
                        this.state = 393;
                        this.match(SqlBaseParser.VIEW);
                        this.state = 394;
                        this.qualifiedName();
                        this.state = 397;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.SECURITY) {
                            {
                                this.state = 395;
                                this.match(SqlBaseParser.SECURITY);
                                this.state = 396;
                                _la = this._input.LA(1);
                                if (!(_la === SqlBaseParser.DEFINER || _la === SqlBaseParser.INVOKER)) {
                                    this._errHandler.recoverInline(this);
                                }
                                else {
                                    if (this._input.LA(1) === Token_1.Token.EOF) {
                                        this.matchedEOF = true;
                                    }
                                    this._errHandler.reportMatch(this);
                                    this.consume();
                                }
                            }
                        }
                        this.state = 399;
                        this.match(SqlBaseParser.AS);
                        this.state = 400;
                        this.query();
                    }
                    break;
                case 20:
                    _localctx = new DropViewContext(_localctx);
                    this.enterOuterAlt(_localctx, 20);
                    {
                        this.state = 402;
                        this.match(SqlBaseParser.DROP);
                        this.state = 403;
                        this.match(SqlBaseParser.VIEW);
                        this.state = 406;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 32, this._ctx)) {
                            case 1:
                                {
                                    this.state = 404;
                                    this.match(SqlBaseParser.IF);
                                    this.state = 405;
                                    this.match(SqlBaseParser.EXISTS);
                                }
                                break;
                        }
                        this.state = 408;
                        this.qualifiedName();
                    }
                    break;
                case 21:
                    _localctx = new CreateMaterializedViewContext(_localctx);
                    this.enterOuterAlt(_localctx, 21);
                    {
                        this.state = 409;
                        this.match(SqlBaseParser.CREATE);
                        this.state = 410;
                        this.match(SqlBaseParser.MATERIALIZED);
                        this.state = 411;
                        this.match(SqlBaseParser.VIEW);
                        this.state = 415;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 33, this._ctx)) {
                            case 1:
                                {
                                    this.state = 412;
                                    this.match(SqlBaseParser.IF);
                                    this.state = 413;
                                    this.match(SqlBaseParser.NOT);
                                    this.state = 414;
                                    this.match(SqlBaseParser.EXISTS);
                                }
                                break;
                        }
                        this.state = 417;
                        this.qualifiedName();
                        this.state = 420;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.COMMENT) {
                            {
                                this.state = 418;
                                this.match(SqlBaseParser.COMMENT);
                                this.state = 419;
                                this.string();
                            }
                        }
                        this.state = 424;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.WITH) {
                            {
                                this.state = 422;
                                this.match(SqlBaseParser.WITH);
                                this.state = 423;
                                this.properties();
                            }
                        }
                        this.state = 426;
                        this.match(SqlBaseParser.AS);
                        this.state = 432;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 36, this._ctx)) {
                            case 1:
                                {
                                    this.state = 427;
                                    this.query();
                                }
                                break;
                            case 2:
                                {
                                    this.state = 428;
                                    this.match(SqlBaseParser.T__1);
                                    this.state = 429;
                                    this.query();
                                    this.state = 430;
                                    this.match(SqlBaseParser.T__2);
                                }
                                break;
                        }
                    }
                    break;
                case 22:
                    _localctx = new DropMaterializedViewContext(_localctx);
                    this.enterOuterAlt(_localctx, 22);
                    {
                        this.state = 434;
                        this.match(SqlBaseParser.DROP);
                        this.state = 435;
                        this.match(SqlBaseParser.MATERIALIZED);
                        this.state = 436;
                        this.match(SqlBaseParser.VIEW);
                        this.state = 439;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 37, this._ctx)) {
                            case 1:
                                {
                                    this.state = 437;
                                    this.match(SqlBaseParser.IF);
                                    this.state = 438;
                                    this.match(SqlBaseParser.EXISTS);
                                }
                                break;
                        }
                        this.state = 441;
                        this.qualifiedName();
                    }
                    break;
                case 23:
                    _localctx = new RefreshMaterializedViewContext(_localctx);
                    this.enterOuterAlt(_localctx, 23);
                    {
                        this.state = 442;
                        this.match(SqlBaseParser.REFRESH);
                        this.state = 443;
                        this.match(SqlBaseParser.MATERIALIZED);
                        this.state = 444;
                        this.match(SqlBaseParser.VIEW);
                        this.state = 445;
                        this.qualifiedName();
                        this.state = 446;
                        this.match(SqlBaseParser.WHERE);
                        this.state = 447;
                        this.booleanExpression(0);
                    }
                    break;
                case 24:
                    _localctx = new CreateFunctionContext(_localctx);
                    this.enterOuterAlt(_localctx, 24);
                    {
                        this.state = 449;
                        this.match(SqlBaseParser.CREATE);
                        this.state = 452;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.OR) {
                            {
                                this.state = 450;
                                this.match(SqlBaseParser.OR);
                                this.state = 451;
                                this.match(SqlBaseParser.REPLACE);
                            }
                        }
                        this.state = 455;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.TEMPORARY) {
                            {
                                this.state = 454;
                                this.match(SqlBaseParser.TEMPORARY);
                            }
                        }
                        this.state = 457;
                        this.match(SqlBaseParser.FUNCTION);
                        this.state = 458;
                        _localctx._functionName = this.qualifiedName();
                        this.state = 459;
                        this.match(SqlBaseParser.T__1);
                        this.state = 468;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (((((_la - 10)) & ~0x1F) === 0 && ((1 << (_la - 10)) & ((1 << (SqlBaseParser.ADD - 10)) | (1 << (SqlBaseParser.ADMIN - 10)) | (1 << (SqlBaseParser.ALL - 10)) | (1 << (SqlBaseParser.ANALYZE - 10)) | (1 << (SqlBaseParser.ANY - 10)) | (1 << (SqlBaseParser.ARRAY - 10)) | (1 << (SqlBaseParser.ASC - 10)) | (1 << (SqlBaseParser.AT - 10)) | (1 << (SqlBaseParser.BERNOULLI - 10)) | (1 << (SqlBaseParser.CALL - 10)) | (1 << (SqlBaseParser.CALLED - 10)) | (1 << (SqlBaseParser.CASCADE - 10)) | (1 << (SqlBaseParser.CATALOGS - 10)) | (1 << (SqlBaseParser.COLUMN - 10)) | (1 << (SqlBaseParser.COLUMNS - 10)) | (1 << (SqlBaseParser.COMMENT - 10)) | (1 << (SqlBaseParser.COMMIT - 10)) | (1 << (SqlBaseParser.COMMITTED - 10)) | (1 << (SqlBaseParser.CURRENT - 10)) | (1 << (SqlBaseParser.CURRENT_ROLE - 10)))) !== 0) || ((((_la - 45)) & ~0x1F) === 0 && ((1 << (_la - 45)) & ((1 << (SqlBaseParser.DATA - 45)) | (1 << (SqlBaseParser.DATE - 45)) | (1 << (SqlBaseParser.DAY - 45)) | (1 << (SqlBaseParser.DEFINER - 45)) | (1 << (SqlBaseParser.DESC - 45)) | (1 << (SqlBaseParser.DETERMINISTIC - 45)) | (1 << (SqlBaseParser.DISTRIBUTED - 45)) | (1 << (SqlBaseParser.EXCLUDING - 45)) | (1 << (SqlBaseParser.EXPLAIN - 45)) | (1 << (SqlBaseParser.EXTERNAL - 45)) | (1 << (SqlBaseParser.FILTER - 45)) | (1 << (SqlBaseParser.FIRST - 45)) | (1 << (SqlBaseParser.FOLLOWING - 45)) | (1 << (SqlBaseParser.FORMAT - 45)) | (1 << (SqlBaseParser.FUNCTION - 45)) | (1 << (SqlBaseParser.FUNCTIONS - 45)))) !== 0) || ((((_la - 77)) & ~0x1F) === 0 && ((1 << (_la - 77)) & ((1 << (SqlBaseParser.GRANT - 77)) | (1 << (SqlBaseParser.GRANTED - 77)) | (1 << (SqlBaseParser.GRANTS - 77)) | (1 << (SqlBaseParser.GRAPHVIZ - 77)) | (1 << (SqlBaseParser.HOUR - 77)) | (1 << (SqlBaseParser.IF - 77)) | (1 << (SqlBaseParser.IGNORE - 77)) | (1 << (SqlBaseParser.INCLUDING - 77)) | (1 << (SqlBaseParser.INPUT - 77)) | (1 << (SqlBaseParser.INTERVAL - 77)) | (1 << (SqlBaseParser.INVOKER - 77)) | (1 << (SqlBaseParser.IO - 77)) | (1 << (SqlBaseParser.ISOLATION - 77)) | (1 << (SqlBaseParser.JSON - 77)) | (1 << (SqlBaseParser.LANGUAGE - 77)) | (1 << (SqlBaseParser.LAST - 77)) | (1 << (SqlBaseParser.LATERAL - 77)) | (1 << (SqlBaseParser.LEVEL - 77)) | (1 << (SqlBaseParser.LIMIT - 77)))) !== 0) || ((((_la - 110)) & ~0x1F) === 0 && ((1 << (_la - 110)) & ((1 << (SqlBaseParser.LOGICAL - 110)) | (1 << (SqlBaseParser.MAP - 110)) | (1 << (SqlBaseParser.MATERIALIZED - 110)) | (1 << (SqlBaseParser.MINUTE - 110)) | (1 << (SqlBaseParser.MONTH - 110)) | (1 << (SqlBaseParser.NAME - 110)) | (1 << (SqlBaseParser.NFC - 110)) | (1 << (SqlBaseParser.NFD - 110)) | (1 << (SqlBaseParser.NFKC - 110)) | (1 << (SqlBaseParser.NFKD - 110)) | (1 << (SqlBaseParser.NO - 110)) | (1 << (SqlBaseParser.NONE - 110)) | (1 << (SqlBaseParser.NULLIF - 110)) | (1 << (SqlBaseParser.NULLS - 110)) | (1 << (SqlBaseParser.OFFSET - 110)) | (1 << (SqlBaseParser.ONLY - 110)) | (1 << (SqlBaseParser.OPTION - 110)) | (1 << (SqlBaseParser.ORDINALITY - 110)) | (1 << (SqlBaseParser.OUTPUT - 110)) | (1 << (SqlBaseParser.OVER - 110)) | (1 << (SqlBaseParser.PARTITION - 110)) | (1 << (SqlBaseParser.PARTITIONS - 110)) | (1 << (SqlBaseParser.POSITION - 110)) | (1 << (SqlBaseParser.PRECEDING - 110)))) !== 0) || ((((_la - 143)) & ~0x1F) === 0 && ((1 << (_la - 143)) & ((1 << (SqlBaseParser.PRIVILEGES - 143)) | (1 << (SqlBaseParser.PROPERTIES - 143)) | (1 << (SqlBaseParser.RANGE - 143)) | (1 << (SqlBaseParser.READ - 143)) | (1 << (SqlBaseParser.REFRESH - 143)) | (1 << (SqlBaseParser.RENAME - 143)) | (1 << (SqlBaseParser.REPEATABLE - 143)) | (1 << (SqlBaseParser.REPLACE - 143)) | (1 << (SqlBaseParser.RESET - 143)) | (1 << (SqlBaseParser.RESPECT - 143)) | (1 << (SqlBaseParser.RESTRICT - 143)) | (1 << (SqlBaseParser.RETURN - 143)) | (1 << (SqlBaseParser.RETURNS - 143)) | (1 << (SqlBaseParser.REVOKE - 143)) | (1 << (SqlBaseParser.ROLE - 143)) | (1 << (SqlBaseParser.ROLES - 143)) | (1 << (SqlBaseParser.ROLLBACK - 143)) | (1 << (SqlBaseParser.ROW - 143)) | (1 << (SqlBaseParser.ROWS - 143)) | (1 << (SqlBaseParser.SCHEMA - 143)) | (1 << (SqlBaseParser.SCHEMAS - 143)) | (1 << (SqlBaseParser.SECOND - 143)) | (1 << (SqlBaseParser.SECURITY - 143)) | (1 << (SqlBaseParser.SERIALIZABLE - 143)) | (1 << (SqlBaseParser.SESSION - 143)) | (1 << (SqlBaseParser.SET - 143)) | (1 << (SqlBaseParser.SETS - 143)) | (1 << (SqlBaseParser.SHOW - 143)))) !== 0) || ((((_la - 175)) & ~0x1F) === 0 && ((1 << (_la - 175)) & ((1 << (SqlBaseParser.SOME - 175)) | (1 << (SqlBaseParser.SQL - 175)) | (1 << (SqlBaseParser.START - 175)) | (1 << (SqlBaseParser.STATS - 175)) | (1 << (SqlBaseParser.SUBSTRING - 175)) | (1 << (SqlBaseParser.SYSTEM - 175)) | (1 << (SqlBaseParser.TABLES - 175)) | (1 << (SqlBaseParser.TABLESAMPLE - 175)) | (1 << (SqlBaseParser.TEMPORARY - 175)) | (1 << (SqlBaseParser.TEXT - 175)) | (1 << (SqlBaseParser.TIME - 175)) | (1 << (SqlBaseParser.TIMESTAMP - 175)) | (1 << (SqlBaseParser.TO - 175)) | (1 << (SqlBaseParser.TRANSACTION - 175)) | (1 << (SqlBaseParser.TRY_CAST - 175)) | (1 << (SqlBaseParser.TYPE - 175)) | (1 << (SqlBaseParser.UNBOUNDED - 175)) | (1 << (SqlBaseParser.UNCOMMITTED - 175)) | (1 << (SqlBaseParser.USE - 175)) | (1 << (SqlBaseParser.USER - 175)) | (1 << (SqlBaseParser.VALIDATE - 175)) | (1 << (SqlBaseParser.VERBOSE - 175)) | (1 << (SqlBaseParser.VIEW - 175)))) !== 0) || ((((_la - 210)) & ~0x1F) === 0 && ((1 << (_la - 210)) & ((1 << (SqlBaseParser.WORK - 210)) | (1 << (SqlBaseParser.WRITE - 210)) | (1 << (SqlBaseParser.YEAR - 210)) | (1 << (SqlBaseParser.ZONE - 210)) | (1 << (SqlBaseParser.IDENTIFIER - 210)) | (1 << (SqlBaseParser.DIGIT_IDENTIFIER - 210)) | (1 << (SqlBaseParser.QUOTED_IDENTIFIER - 210)) | (1 << (SqlBaseParser.BACKQUOTED_IDENTIFIER - 210)))) !== 0)) {
                            {
                                this.state = 460;
                                this.sqlParameterDeclaration();
                                this.state = 465;
                                this._errHandler.sync(this);
                                _la = this._input.LA(1);
                                while (_la === SqlBaseParser.T__3) {
                                    {
                                        {
                                            this.state = 461;
                                            this.match(SqlBaseParser.T__3);
                                            this.state = 462;
                                            this.sqlParameterDeclaration();
                                        }
                                    }
                                    this.state = 467;
                                    this._errHandler.sync(this);
                                    _la = this._input.LA(1);
                                }
                            }
                        }
                        this.state = 470;
                        this.match(SqlBaseParser.T__2);
                        this.state = 471;
                        this.match(SqlBaseParser.RETURNS);
                        this.state = 472;
                        _localctx._returnType = this.type(0);
                        this.state = 475;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.COMMENT) {
                            {
                                this.state = 473;
                                this.match(SqlBaseParser.COMMENT);
                                this.state = 474;
                                this.string();
                            }
                        }
                        this.state = 477;
                        this.routineCharacteristics();
                        this.state = 478;
                        this.routineBody();
                    }
                    break;
                case 25:
                    _localctx = new AlterFunctionContext(_localctx);
                    this.enterOuterAlt(_localctx, 25);
                    {
                        this.state = 480;
                        this.match(SqlBaseParser.ALTER);
                        this.state = 481;
                        this.match(SqlBaseParser.FUNCTION);
                        this.state = 482;
                        this.qualifiedName();
                        this.state = 484;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.T__1) {
                            {
                                this.state = 483;
                                this.types();
                            }
                        }
                        this.state = 486;
                        this.alterRoutineCharacteristics();
                    }
                    break;
                case 26:
                    _localctx = new DropFunctionContext(_localctx);
                    this.enterOuterAlt(_localctx, 26);
                    {
                        this.state = 488;
                        this.match(SqlBaseParser.DROP);
                        this.state = 490;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.TEMPORARY) {
                            {
                                this.state = 489;
                                this.match(SqlBaseParser.TEMPORARY);
                            }
                        }
                        this.state = 492;
                        this.match(SqlBaseParser.FUNCTION);
                        this.state = 495;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 45, this._ctx)) {
                            case 1:
                                {
                                    this.state = 493;
                                    this.match(SqlBaseParser.IF);
                                    this.state = 494;
                                    this.match(SqlBaseParser.EXISTS);
                                }
                                break;
                        }
                        this.state = 497;
                        this.qualifiedName();
                        this.state = 499;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.T__1) {
                            {
                                this.state = 498;
                                this.types();
                            }
                        }
                    }
                    break;
                case 27:
                    _localctx = new CallContext(_localctx);
                    this.enterOuterAlt(_localctx, 27);
                    {
                        this.state = 501;
                        this.match(SqlBaseParser.CALL);
                        this.state = 502;
                        this.qualifiedName();
                        this.state = 503;
                        this.match(SqlBaseParser.T__1);
                        this.state = 512;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if ((((_la) & ~0x1F) === 0 && ((1 << _la) & ((1 << SqlBaseParser.T__1) | (1 << SqlBaseParser.T__4) | (1 << SqlBaseParser.ADD) | (1 << SqlBaseParser.ADMIN) | (1 << SqlBaseParser.ALL) | (1 << SqlBaseParser.ANALYZE) | (1 << SqlBaseParser.ANY) | (1 << SqlBaseParser.ARRAY) | (1 << SqlBaseParser.ASC) | (1 << SqlBaseParser.AT) | (1 << SqlBaseParser.BERNOULLI) | (1 << SqlBaseParser.CALL) | (1 << SqlBaseParser.CALLED) | (1 << SqlBaseParser.CASCADE) | (1 << SqlBaseParser.CASE) | (1 << SqlBaseParser.CAST) | (1 << SqlBaseParser.CATALOGS) | (1 << SqlBaseParser.COLUMN) | (1 << SqlBaseParser.COLUMNS))) !== 0) || ((((_la - 32)) & ~0x1F) === 0 && ((1 << (_la - 32)) & ((1 << (SqlBaseParser.COMMENT - 32)) | (1 << (SqlBaseParser.COMMIT - 32)) | (1 << (SqlBaseParser.COMMITTED - 32)) | (1 << (SqlBaseParser.CURRENT - 32)) | (1 << (SqlBaseParser.CURRENT_DATE - 32)) | (1 << (SqlBaseParser.CURRENT_ROLE - 32)) | (1 << (SqlBaseParser.CURRENT_TIME - 32)) | (1 << (SqlBaseParser.CURRENT_TIMESTAMP - 32)) | (1 << (SqlBaseParser.CURRENT_USER - 32)) | (1 << (SqlBaseParser.DATA - 32)) | (1 << (SqlBaseParser.DATE - 32)) | (1 << (SqlBaseParser.DAY - 32)) | (1 << (SqlBaseParser.DEFINER - 32)) | (1 << (SqlBaseParser.DESC - 32)) | (1 << (SqlBaseParser.DETERMINISTIC - 32)) | (1 << (SqlBaseParser.DISTRIBUTED - 32)) | (1 << (SqlBaseParser.EXCLUDING - 32)) | (1 << (SqlBaseParser.EXISTS - 32)))) !== 0) || ((((_la - 64)) & ~0x1F) === 0 && ((1 << (_la - 64)) & ((1 << (SqlBaseParser.EXPLAIN - 64)) | (1 << (SqlBaseParser.EXTRACT - 64)) | (1 << (SqlBaseParser.EXTERNAL - 64)) | (1 << (SqlBaseParser.FALSE - 64)) | (1 << (SqlBaseParser.FILTER - 64)) | (1 << (SqlBaseParser.FIRST - 64)) | (1 << (SqlBaseParser.FOLLOWING - 64)) | (1 << (SqlBaseParser.FORMAT - 64)) | (1 << (SqlBaseParser.FUNCTION - 64)) | (1 << (SqlBaseParser.FUNCTIONS - 64)) | (1 << (SqlBaseParser.GRANT - 64)) | (1 << (SqlBaseParser.GRANTED - 64)) | (1 << (SqlBaseParser.GRANTS - 64)) | (1 << (SqlBaseParser.GRAPHVIZ - 64)) | (1 << (SqlBaseParser.GROUPING - 64)) | (1 << (SqlBaseParser.HOUR - 64)) | (1 << (SqlBaseParser.IF - 64)) | (1 << (SqlBaseParser.IGNORE - 64)) | (1 << (SqlBaseParser.INCLUDING - 64)) | (1 << (SqlBaseParser.INPUT - 64)) | (1 << (SqlBaseParser.INTERVAL - 64)) | (1 << (SqlBaseParser.INVOKER - 64)))) !== 0) || ((((_la - 96)) & ~0x1F) === 0 && ((1 << (_la - 96)) & ((1 << (SqlBaseParser.IO - 96)) | (1 << (SqlBaseParser.ISOLATION - 96)) | (1 << (SqlBaseParser.JSON - 96)) | (1 << (SqlBaseParser.LANGUAGE - 96)) | (1 << (SqlBaseParser.LAST - 96)) | (1 << (SqlBaseParser.LATERAL - 96)) | (1 << (SqlBaseParser.LEVEL - 96)) | (1 << (SqlBaseParser.LIMIT - 96)) | (1 << (SqlBaseParser.LOCALTIME - 96)) | (1 << (SqlBaseParser.LOCALTIMESTAMP - 96)) | (1 << (SqlBaseParser.LOGICAL - 96)) | (1 << (SqlBaseParser.MAP - 96)) | (1 << (SqlBaseParser.MATERIALIZED - 96)) | (1 << (SqlBaseParser.MINUTE - 96)) | (1 << (SqlBaseParser.MONTH - 96)) | (1 << (SqlBaseParser.NAME - 96)) | (1 << (SqlBaseParser.NFC - 96)) | (1 << (SqlBaseParser.NFD - 96)) | (1 << (SqlBaseParser.NFKC - 96)) | (1 << (SqlBaseParser.NFKD - 96)) | (1 << (SqlBaseParser.NO - 96)) | (1 << (SqlBaseParser.NONE - 96)) | (1 << (SqlBaseParser.NORMALIZE - 96)) | (1 << (SqlBaseParser.NOT - 96)) | (1 << (SqlBaseParser.NULL - 96)) | (1 << (SqlBaseParser.NULLIF - 96)) | (1 << (SqlBaseParser.NULLS - 96)))) !== 0) || ((((_la - 128)) & ~0x1F) === 0 && ((1 << (_la - 128)) & ((1 << (SqlBaseParser.OFFSET - 128)) | (1 << (SqlBaseParser.ONLY - 128)) | (1 << (SqlBaseParser.OPTION - 128)) | (1 << (SqlBaseParser.ORDINALITY - 128)) | (1 << (SqlBaseParser.OUTPUT - 128)) | (1 << (SqlBaseParser.OVER - 128)) | (1 << (SqlBaseParser.PARTITION - 128)) | (1 << (SqlBaseParser.PARTITIONS - 128)) | (1 << (SqlBaseParser.POSITION - 128)) | (1 << (SqlBaseParser.PRECEDING - 128)) | (1 << (SqlBaseParser.PRIVILEGES - 128)) | (1 << (SqlBaseParser.PROPERTIES - 128)) | (1 << (SqlBaseParser.RANGE - 128)) | (1 << (SqlBaseParser.READ - 128)) | (1 << (SqlBaseParser.REFRESH - 128)) | (1 << (SqlBaseParser.RENAME - 128)) | (1 << (SqlBaseParser.REPEATABLE - 128)) | (1 << (SqlBaseParser.REPLACE - 128)) | (1 << (SqlBaseParser.RESET - 128)) | (1 << (SqlBaseParser.RESPECT - 128)) | (1 << (SqlBaseParser.RESTRICT - 128)) | (1 << (SqlBaseParser.RETURN - 128)) | (1 << (SqlBaseParser.RETURNS - 128)) | (1 << (SqlBaseParser.REVOKE - 128)) | (1 << (SqlBaseParser.ROLE - 128)))) !== 0) || ((((_la - 160)) & ~0x1F) === 0 && ((1 << (_la - 160)) & ((1 << (SqlBaseParser.ROLES - 160)) | (1 << (SqlBaseParser.ROLLBACK - 160)) | (1 << (SqlBaseParser.ROW - 160)) | (1 << (SqlBaseParser.ROWS - 160)) | (1 << (SqlBaseParser.SCHEMA - 160)) | (1 << (SqlBaseParser.SCHEMAS - 160)) | (1 << (SqlBaseParser.SECOND - 160)) | (1 << (SqlBaseParser.SECURITY - 160)) | (1 << (SqlBaseParser.SERIALIZABLE - 160)) | (1 << (SqlBaseParser.SESSION - 160)) | (1 << (SqlBaseParser.SET - 160)) | (1 << (SqlBaseParser.SETS - 160)) | (1 << (SqlBaseParser.SHOW - 160)) | (1 << (SqlBaseParser.SOME - 160)) | (1 << (SqlBaseParser.SQL - 160)) | (1 << (SqlBaseParser.START - 160)) | (1 << (SqlBaseParser.STATS - 160)) | (1 << (SqlBaseParser.SUBSTRING - 160)) | (1 << (SqlBaseParser.SYSTEM - 160)) | (1 << (SqlBaseParser.TABLES - 160)) | (1 << (SqlBaseParser.TABLESAMPLE - 160)) | (1 << (SqlBaseParser.TEMPORARY - 160)) | (1 << (SqlBaseParser.TEXT - 160)) | (1 << (SqlBaseParser.TIME - 160)) | (1 << (SqlBaseParser.TIMESTAMP - 160)) | (1 << (SqlBaseParser.TO - 160)) | (1 << (SqlBaseParser.TRANSACTION - 160)) | (1 << (SqlBaseParser.TRUE - 160)))) !== 0) || ((((_la - 192)) & ~0x1F) === 0 && ((1 << (_la - 192)) & ((1 << (SqlBaseParser.TRY_CAST - 192)) | (1 << (SqlBaseParser.TYPE - 192)) | (1 << (SqlBaseParser.UNBOUNDED - 192)) | (1 << (SqlBaseParser.UNCOMMITTED - 192)) | (1 << (SqlBaseParser.USE - 192)) | (1 << (SqlBaseParser.USER - 192)) | (1 << (SqlBaseParser.VALIDATE - 192)) | (1 << (SqlBaseParser.VERBOSE - 192)) | (1 << (SqlBaseParser.VIEW - 192)) | (1 << (SqlBaseParser.WORK - 192)) | (1 << (SqlBaseParser.WRITE - 192)) | (1 << (SqlBaseParser.YEAR - 192)) | (1 << (SqlBaseParser.ZONE - 192)) | (1 << (SqlBaseParser.PLUS - 192)) | (1 << (SqlBaseParser.MINUS - 192)))) !== 0) || ((((_la - 226)) & ~0x1F) === 0 && ((1 << (_la - 226)) & ((1 << (SqlBaseParser.STRING - 226)) | (1 << (SqlBaseParser.UNICODE_STRING - 226)) | (1 << (SqlBaseParser.BINARY_LITERAL - 226)) | (1 << (SqlBaseParser.INTEGER_VALUE - 226)) | (1 << (SqlBaseParser.DECIMAL_VALUE - 226)) | (1 << (SqlBaseParser.DOUBLE_VALUE - 226)) | (1 << (SqlBaseParser.IDENTIFIER - 226)) | (1 << (SqlBaseParser.DIGIT_IDENTIFIER - 226)) | (1 << (SqlBaseParser.QUOTED_IDENTIFIER - 226)) | (1 << (SqlBaseParser.BACKQUOTED_IDENTIFIER - 226)) | (1 << (SqlBaseParser.DOUBLE_PRECISION - 226)))) !== 0)) {
                            {
                                this.state = 504;
                                this.callArgument();
                                this.state = 509;
                                this._errHandler.sync(this);
                                _la = this._input.LA(1);
                                while (_la === SqlBaseParser.T__3) {
                                    {
                                        {
                                            this.state = 505;
                                            this.match(SqlBaseParser.T__3);
                                            this.state = 506;
                                            this.callArgument();
                                        }
                                    }
                                    this.state = 511;
                                    this._errHandler.sync(this);
                                    _la = this._input.LA(1);
                                }
                            }
                        }
                        this.state = 514;
                        this.match(SqlBaseParser.T__2);
                    }
                    break;
                case 28:
                    _localctx = new CreateRoleContext(_localctx);
                    this.enterOuterAlt(_localctx, 28);
                    {
                        this.state = 516;
                        this.match(SqlBaseParser.CREATE);
                        this.state = 517;
                        this.match(SqlBaseParser.ROLE);
                        this.state = 518;
                        _localctx._name = this.identifier();
                        this.state = 522;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.WITH) {
                            {
                                this.state = 519;
                                this.match(SqlBaseParser.WITH);
                                this.state = 520;
                                this.match(SqlBaseParser.ADMIN);
                                this.state = 521;
                                this.grantor();
                            }
                        }
                    }
                    break;
                case 29:
                    _localctx = new DropRoleContext(_localctx);
                    this.enterOuterAlt(_localctx, 29);
                    {
                        this.state = 524;
                        this.match(SqlBaseParser.DROP);
                        this.state = 525;
                        this.match(SqlBaseParser.ROLE);
                        this.state = 526;
                        _localctx._name = this.identifier();
                    }
                    break;
                case 30:
                    _localctx = new GrantRolesContext(_localctx);
                    this.enterOuterAlt(_localctx, 30);
                    {
                        this.state = 527;
                        this.match(SqlBaseParser.GRANT);
                        this.state = 528;
                        this.roles();
                        this.state = 529;
                        this.match(SqlBaseParser.TO);
                        this.state = 530;
                        this.principal();
                        this.state = 535;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        while (_la === SqlBaseParser.T__3) {
                            {
                                {
                                    this.state = 531;
                                    this.match(SqlBaseParser.T__3);
                                    this.state = 532;
                                    this.principal();
                                }
                            }
                            this.state = 537;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                        }
                        this.state = 541;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.WITH) {
                            {
                                this.state = 538;
                                this.match(SqlBaseParser.WITH);
                                this.state = 539;
                                this.match(SqlBaseParser.ADMIN);
                                this.state = 540;
                                this.match(SqlBaseParser.OPTION);
                            }
                        }
                        this.state = 546;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.GRANTED) {
                            {
                                this.state = 543;
                                this.match(SqlBaseParser.GRANTED);
                                this.state = 544;
                                this.match(SqlBaseParser.BY);
                                this.state = 545;
                                this.grantor();
                            }
                        }
                    }
                    break;
                case 31:
                    _localctx = new RevokeRolesContext(_localctx);
                    this.enterOuterAlt(_localctx, 31);
                    {
                        this.state = 548;
                        this.match(SqlBaseParser.REVOKE);
                        this.state = 552;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 53, this._ctx)) {
                            case 1:
                                {
                                    this.state = 549;
                                    this.match(SqlBaseParser.ADMIN);
                                    this.state = 550;
                                    this.match(SqlBaseParser.OPTION);
                                    this.state = 551;
                                    this.match(SqlBaseParser.FOR);
                                }
                                break;
                        }
                        this.state = 554;
                        this.roles();
                        this.state = 555;
                        this.match(SqlBaseParser.FROM);
                        this.state = 556;
                        this.principal();
                        this.state = 561;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        while (_la === SqlBaseParser.T__3) {
                            {
                                {
                                    this.state = 557;
                                    this.match(SqlBaseParser.T__3);
                                    this.state = 558;
                                    this.principal();
                                }
                            }
                            this.state = 563;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                        }
                        this.state = 567;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.GRANTED) {
                            {
                                this.state = 564;
                                this.match(SqlBaseParser.GRANTED);
                                this.state = 565;
                                this.match(SqlBaseParser.BY);
                                this.state = 566;
                                this.grantor();
                            }
                        }
                    }
                    break;
                case 32:
                    _localctx = new SetRoleContext(_localctx);
                    this.enterOuterAlt(_localctx, 32);
                    {
                        this.state = 569;
                        this.match(SqlBaseParser.SET);
                        this.state = 570;
                        this.match(SqlBaseParser.ROLE);
                        this.state = 574;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 56, this._ctx)) {
                            case 1:
                                {
                                    this.state = 571;
                                    this.match(SqlBaseParser.ALL);
                                }
                                break;
                            case 2:
                                {
                                    this.state = 572;
                                    this.match(SqlBaseParser.NONE);
                                }
                                break;
                            case 3:
                                {
                                    this.state = 573;
                                    _localctx._role = this.identifier();
                                }
                                break;
                        }
                    }
                    break;
                case 33:
                    _localctx = new GrantContext(_localctx);
                    this.enterOuterAlt(_localctx, 33);
                    {
                        this.state = 576;
                        this.match(SqlBaseParser.GRANT);
                        this.state = 587;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 58, this._ctx)) {
                            case 1:
                                {
                                    this.state = 577;
                                    this.privilege();
                                    this.state = 582;
                                    this._errHandler.sync(this);
                                    _la = this._input.LA(1);
                                    while (_la === SqlBaseParser.T__3) {
                                        {
                                            {
                                                this.state = 578;
                                                this.match(SqlBaseParser.T__3);
                                                this.state = 579;
                                                this.privilege();
                                            }
                                        }
                                        this.state = 584;
                                        this._errHandler.sync(this);
                                        _la = this._input.LA(1);
                                    }
                                }
                                break;
                            case 2:
                                {
                                    this.state = 585;
                                    this.match(SqlBaseParser.ALL);
                                    this.state = 586;
                                    this.match(SqlBaseParser.PRIVILEGES);
                                }
                                break;
                        }
                        this.state = 589;
                        this.match(SqlBaseParser.ON);
                        this.state = 591;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.TABLE) {
                            {
                                this.state = 590;
                                this.match(SqlBaseParser.TABLE);
                            }
                        }
                        this.state = 593;
                        this.qualifiedName();
                        this.state = 594;
                        this.match(SqlBaseParser.TO);
                        this.state = 595;
                        _localctx._grantee = this.principal();
                        this.state = 599;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.WITH) {
                            {
                                this.state = 596;
                                this.match(SqlBaseParser.WITH);
                                this.state = 597;
                                this.match(SqlBaseParser.GRANT);
                                this.state = 598;
                                this.match(SqlBaseParser.OPTION);
                            }
                        }
                    }
                    break;
                case 34:
                    _localctx = new RevokeContext(_localctx);
                    this.enterOuterAlt(_localctx, 34);
                    {
                        this.state = 601;
                        this.match(SqlBaseParser.REVOKE);
                        this.state = 605;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 61, this._ctx)) {
                            case 1:
                                {
                                    this.state = 602;
                                    this.match(SqlBaseParser.GRANT);
                                    this.state = 603;
                                    this.match(SqlBaseParser.OPTION);
                                    this.state = 604;
                                    this.match(SqlBaseParser.FOR);
                                }
                                break;
                        }
                        this.state = 617;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 63, this._ctx)) {
                            case 1:
                                {
                                    this.state = 607;
                                    this.privilege();
                                    this.state = 612;
                                    this._errHandler.sync(this);
                                    _la = this._input.LA(1);
                                    while (_la === SqlBaseParser.T__3) {
                                        {
                                            {
                                                this.state = 608;
                                                this.match(SqlBaseParser.T__3);
                                                this.state = 609;
                                                this.privilege();
                                            }
                                        }
                                        this.state = 614;
                                        this._errHandler.sync(this);
                                        _la = this._input.LA(1);
                                    }
                                }
                                break;
                            case 2:
                                {
                                    this.state = 615;
                                    this.match(SqlBaseParser.ALL);
                                    this.state = 616;
                                    this.match(SqlBaseParser.PRIVILEGES);
                                }
                                break;
                        }
                        this.state = 619;
                        this.match(SqlBaseParser.ON);
                        this.state = 621;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.TABLE) {
                            {
                                this.state = 620;
                                this.match(SqlBaseParser.TABLE);
                            }
                        }
                        this.state = 623;
                        this.qualifiedName();
                        this.state = 624;
                        this.match(SqlBaseParser.FROM);
                        this.state = 625;
                        _localctx._grantee = this.principal();
                    }
                    break;
                case 35:
                    _localctx = new ShowGrantsContext(_localctx);
                    this.enterOuterAlt(_localctx, 35);
                    {
                        this.state = 627;
                        this.match(SqlBaseParser.SHOW);
                        this.state = 628;
                        this.match(SqlBaseParser.GRANTS);
                        this.state = 634;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.ON) {
                            {
                                this.state = 629;
                                this.match(SqlBaseParser.ON);
                                this.state = 631;
                                this._errHandler.sync(this);
                                _la = this._input.LA(1);
                                if (_la === SqlBaseParser.TABLE) {
                                    {
                                        this.state = 630;
                                        this.match(SqlBaseParser.TABLE);
                                    }
                                }
                                this.state = 633;
                                this.qualifiedName();
                            }
                        }
                    }
                    break;
                case 36:
                    _localctx = new ExplainContext(_localctx);
                    this.enterOuterAlt(_localctx, 36);
                    {
                        this.state = 636;
                        this.match(SqlBaseParser.EXPLAIN);
                        this.state = 638;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 67, this._ctx)) {
                            case 1:
                                {
                                    this.state = 637;
                                    this.match(SqlBaseParser.ANALYZE);
                                }
                                break;
                        }
                        this.state = 641;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.VERBOSE) {
                            {
                                this.state = 640;
                                this.match(SqlBaseParser.VERBOSE);
                            }
                        }
                        this.state = 654;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 70, this._ctx)) {
                            case 1:
                                {
                                    this.state = 643;
                                    this.match(SqlBaseParser.T__1);
                                    this.state = 644;
                                    this.explainOption();
                                    this.state = 649;
                                    this._errHandler.sync(this);
                                    _la = this._input.LA(1);
                                    while (_la === SqlBaseParser.T__3) {
                                        {
                                            {
                                                this.state = 645;
                                                this.match(SqlBaseParser.T__3);
                                                this.state = 646;
                                                this.explainOption();
                                            }
                                        }
                                        this.state = 651;
                                        this._errHandler.sync(this);
                                        _la = this._input.LA(1);
                                    }
                                    this.state = 652;
                                    this.match(SqlBaseParser.T__2);
                                }
                                break;
                        }
                        this.state = 656;
                        this.statement();
                    }
                    break;
                case 37:
                    _localctx = new ShowCreateTableContext(_localctx);
                    this.enterOuterAlt(_localctx, 37);
                    {
                        this.state = 657;
                        this.match(SqlBaseParser.SHOW);
                        this.state = 658;
                        this.match(SqlBaseParser.CREATE);
                        this.state = 659;
                        this.match(SqlBaseParser.TABLE);
                        this.state = 660;
                        this.qualifiedName();
                    }
                    break;
                case 38:
                    _localctx = new ShowCreateViewContext(_localctx);
                    this.enterOuterAlt(_localctx, 38);
                    {
                        this.state = 661;
                        this.match(SqlBaseParser.SHOW);
                        this.state = 662;
                        this.match(SqlBaseParser.CREATE);
                        this.state = 663;
                        this.match(SqlBaseParser.VIEW);
                        this.state = 664;
                        this.qualifiedName();
                    }
                    break;
                case 39:
                    _localctx = new ShowCreateMaterializedViewContext(_localctx);
                    this.enterOuterAlt(_localctx, 39);
                    {
                        this.state = 665;
                        this.match(SqlBaseParser.SHOW);
                        this.state = 666;
                        this.match(SqlBaseParser.CREATE);
                        this.state = 667;
                        this.match(SqlBaseParser.MATERIALIZED);
                        this.state = 668;
                        this.match(SqlBaseParser.VIEW);
                        this.state = 669;
                        this.qualifiedName();
                    }
                    break;
                case 40:
                    _localctx = new ShowCreateFunctionContext(_localctx);
                    this.enterOuterAlt(_localctx, 40);
                    {
                        this.state = 670;
                        this.match(SqlBaseParser.SHOW);
                        this.state = 671;
                        this.match(SqlBaseParser.CREATE);
                        this.state = 672;
                        this.match(SqlBaseParser.FUNCTION);
                        this.state = 673;
                        this.qualifiedName();
                        this.state = 675;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.T__1) {
                            {
                                this.state = 674;
                                this.types();
                            }
                        }
                    }
                    break;
                case 41:
                    _localctx = new ShowTablesContext(_localctx);
                    this.enterOuterAlt(_localctx, 41);
                    {
                        this.state = 677;
                        this.match(SqlBaseParser.SHOW);
                        this.state = 678;
                        this.match(SqlBaseParser.TABLES);
                        this.state = 681;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.FROM || _la === SqlBaseParser.IN) {
                            {
                                this.state = 679;
                                _la = this._input.LA(1);
                                if (!(_la === SqlBaseParser.FROM || _la === SqlBaseParser.IN)) {
                                    this._errHandler.recoverInline(this);
                                }
                                else {
                                    if (this._input.LA(1) === Token_1.Token.EOF) {
                                        this.matchedEOF = true;
                                    }
                                    this._errHandler.reportMatch(this);
                                    this.consume();
                                }
                                this.state = 680;
                                this.qualifiedName();
                            }
                        }
                        this.state = 689;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.LIKE) {
                            {
                                this.state = 683;
                                this.match(SqlBaseParser.LIKE);
                                this.state = 684;
                                _localctx._pattern = this.string();
                                this.state = 687;
                                this._errHandler.sync(this);
                                _la = this._input.LA(1);
                                if (_la === SqlBaseParser.ESCAPE) {
                                    {
                                        this.state = 685;
                                        this.match(SqlBaseParser.ESCAPE);
                                        this.state = 686;
                                        _localctx._escape = this.string();
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 42:
                    _localctx = new ShowSchemasContext(_localctx);
                    this.enterOuterAlt(_localctx, 42);
                    {
                        this.state = 691;
                        this.match(SqlBaseParser.SHOW);
                        this.state = 692;
                        this.match(SqlBaseParser.SCHEMAS);
                        this.state = 695;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.FROM || _la === SqlBaseParser.IN) {
                            {
                                this.state = 693;
                                _la = this._input.LA(1);
                                if (!(_la === SqlBaseParser.FROM || _la === SqlBaseParser.IN)) {
                                    this._errHandler.recoverInline(this);
                                }
                                else {
                                    if (this._input.LA(1) === Token_1.Token.EOF) {
                                        this.matchedEOF = true;
                                    }
                                    this._errHandler.reportMatch(this);
                                    this.consume();
                                }
                                this.state = 694;
                                this.identifier();
                            }
                        }
                        this.state = 703;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.LIKE) {
                            {
                                this.state = 697;
                                this.match(SqlBaseParser.LIKE);
                                this.state = 698;
                                _localctx._pattern = this.string();
                                this.state = 701;
                                this._errHandler.sync(this);
                                _la = this._input.LA(1);
                                if (_la === SqlBaseParser.ESCAPE) {
                                    {
                                        this.state = 699;
                                        this.match(SqlBaseParser.ESCAPE);
                                        this.state = 700;
                                        _localctx._escape = this.string();
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 43:
                    _localctx = new ShowCatalogsContext(_localctx);
                    this.enterOuterAlt(_localctx, 43);
                    {
                        this.state = 705;
                        this.match(SqlBaseParser.SHOW);
                        this.state = 706;
                        this.match(SqlBaseParser.CATALOGS);
                        this.state = 709;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.LIKE) {
                            {
                                this.state = 707;
                                this.match(SqlBaseParser.LIKE);
                                this.state = 708;
                                _localctx._pattern = this.string();
                            }
                        }
                    }
                    break;
                case 44:
                    _localctx = new ShowColumnsContext(_localctx);
                    this.enterOuterAlt(_localctx, 44);
                    {
                        this.state = 711;
                        this.match(SqlBaseParser.SHOW);
                        this.state = 712;
                        this.match(SqlBaseParser.COLUMNS);
                        this.state = 713;
                        _la = this._input.LA(1);
                        if (!(_la === SqlBaseParser.FROM || _la === SqlBaseParser.IN)) {
                            this._errHandler.recoverInline(this);
                        }
                        else {
                            if (this._input.LA(1) === Token_1.Token.EOF) {
                                this.matchedEOF = true;
                            }
                            this._errHandler.reportMatch(this);
                            this.consume();
                        }
                        this.state = 714;
                        this.qualifiedName();
                    }
                    break;
                case 45:
                    _localctx = new ShowStatsContext(_localctx);
                    this.enterOuterAlt(_localctx, 45);
                    {
                        this.state = 715;
                        this.match(SqlBaseParser.SHOW);
                        this.state = 716;
                        this.match(SqlBaseParser.STATS);
                        this.state = 717;
                        this.match(SqlBaseParser.FOR);
                        this.state = 718;
                        this.qualifiedName();
                    }
                    break;
                case 46:
                    _localctx = new ShowStatsForQueryContext(_localctx);
                    this.enterOuterAlt(_localctx, 46);
                    {
                        this.state = 719;
                        this.match(SqlBaseParser.SHOW);
                        this.state = 720;
                        this.match(SqlBaseParser.STATS);
                        this.state = 721;
                        this.match(SqlBaseParser.FOR);
                        this.state = 722;
                        this.match(SqlBaseParser.T__1);
                        this.state = 723;
                        this.querySpecification();
                        this.state = 724;
                        this.match(SqlBaseParser.T__2);
                    }
                    break;
                case 47:
                    _localctx = new ShowRolesContext(_localctx);
                    this.enterOuterAlt(_localctx, 47);
                    {
                        this.state = 726;
                        this.match(SqlBaseParser.SHOW);
                        this.state = 728;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.CURRENT) {
                            {
                                this.state = 727;
                                this.match(SqlBaseParser.CURRENT);
                            }
                        }
                        this.state = 730;
                        this.match(SqlBaseParser.ROLES);
                        this.state = 733;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.FROM || _la === SqlBaseParser.IN) {
                            {
                                this.state = 731;
                                _la = this._input.LA(1);
                                if (!(_la === SqlBaseParser.FROM || _la === SqlBaseParser.IN)) {
                                    this._errHandler.recoverInline(this);
                                }
                                else {
                                    if (this._input.LA(1) === Token_1.Token.EOF) {
                                        this.matchedEOF = true;
                                    }
                                    this._errHandler.reportMatch(this);
                                    this.consume();
                                }
                                this.state = 732;
                                this.identifier();
                            }
                        }
                    }
                    break;
                case 48:
                    _localctx = new ShowRoleGrantsContext(_localctx);
                    this.enterOuterAlt(_localctx, 48);
                    {
                        this.state = 735;
                        this.match(SqlBaseParser.SHOW);
                        this.state = 736;
                        this.match(SqlBaseParser.ROLE);
                        this.state = 737;
                        this.match(SqlBaseParser.GRANTS);
                        this.state = 740;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.FROM || _la === SqlBaseParser.IN) {
                            {
                                this.state = 738;
                                _la = this._input.LA(1);
                                if (!(_la === SqlBaseParser.FROM || _la === SqlBaseParser.IN)) {
                                    this._errHandler.recoverInline(this);
                                }
                                else {
                                    if (this._input.LA(1) === Token_1.Token.EOF) {
                                        this.matchedEOF = true;
                                    }
                                    this._errHandler.reportMatch(this);
                                    this.consume();
                                }
                                this.state = 739;
                                this.identifier();
                            }
                        }
                    }
                    break;
                case 49:
                    _localctx = new ShowColumnsContext(_localctx);
                    this.enterOuterAlt(_localctx, 49);
                    {
                        this.state = 742;
                        this.match(SqlBaseParser.DESCRIBE);
                        this.state = 743;
                        this.qualifiedName();
                    }
                    break;
                case 50:
                    _localctx = new ShowColumnsContext(_localctx);
                    this.enterOuterAlt(_localctx, 50);
                    {
                        this.state = 744;
                        this.match(SqlBaseParser.DESC);
                        this.state = 745;
                        this.qualifiedName();
                    }
                    break;
                case 51:
                    _localctx = new ShowFunctionsContext(_localctx);
                    this.enterOuterAlt(_localctx, 51);
                    {
                        this.state = 746;
                        this.match(SqlBaseParser.SHOW);
                        this.state = 747;
                        this.match(SqlBaseParser.FUNCTIONS);
                        this.state = 754;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.LIKE) {
                            {
                                this.state = 748;
                                this.match(SqlBaseParser.LIKE);
                                this.state = 749;
                                _localctx._pattern = this.string();
                                this.state = 752;
                                this._errHandler.sync(this);
                                _la = this._input.LA(1);
                                if (_la === SqlBaseParser.ESCAPE) {
                                    {
                                        this.state = 750;
                                        this.match(SqlBaseParser.ESCAPE);
                                        this.state = 751;
                                        _localctx._escape = this.string();
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 52:
                    _localctx = new ShowSessionContext(_localctx);
                    this.enterOuterAlt(_localctx, 52);
                    {
                        this.state = 756;
                        this.match(SqlBaseParser.SHOW);
                        this.state = 757;
                        this.match(SqlBaseParser.SESSION);
                    }
                    break;
                case 53:
                    _localctx = new SetSessionContext(_localctx);
                    this.enterOuterAlt(_localctx, 53);
                    {
                        this.state = 758;
                        this.match(SqlBaseParser.SET);
                        this.state = 759;
                        this.match(SqlBaseParser.SESSION);
                        this.state = 760;
                        this.qualifiedName();
                        this.state = 761;
                        this.match(SqlBaseParser.EQ);
                        this.state = 762;
                        this.expression();
                    }
                    break;
                case 54:
                    _localctx = new ResetSessionContext(_localctx);
                    this.enterOuterAlt(_localctx, 54);
                    {
                        this.state = 764;
                        this.match(SqlBaseParser.RESET);
                        this.state = 765;
                        this.match(SqlBaseParser.SESSION);
                        this.state = 766;
                        this.qualifiedName();
                    }
                    break;
                case 55:
                    _localctx = new StartTransactionContext(_localctx);
                    this.enterOuterAlt(_localctx, 55);
                    {
                        this.state = 767;
                        this.match(SqlBaseParser.START);
                        this.state = 768;
                        this.match(SqlBaseParser.TRANSACTION);
                        this.state = 777;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.ISOLATION || _la === SqlBaseParser.READ) {
                            {
                                this.state = 769;
                                this.transactionMode();
                                this.state = 774;
                                this._errHandler.sync(this);
                                _la = this._input.LA(1);
                                while (_la === SqlBaseParser.T__3) {
                                    {
                                        {
                                            this.state = 770;
                                            this.match(SqlBaseParser.T__3);
                                            this.state = 771;
                                            this.transactionMode();
                                        }
                                    }
                                    this.state = 776;
                                    this._errHandler.sync(this);
                                    _la = this._input.LA(1);
                                }
                            }
                        }
                    }
                    break;
                case 56:
                    _localctx = new CommitContext(_localctx);
                    this.enterOuterAlt(_localctx, 56);
                    {
                        this.state = 779;
                        this.match(SqlBaseParser.COMMIT);
                        this.state = 781;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.WORK) {
                            {
                                this.state = 780;
                                this.match(SqlBaseParser.WORK);
                            }
                        }
                    }
                    break;
                case 57:
                    _localctx = new RollbackContext(_localctx);
                    this.enterOuterAlt(_localctx, 57);
                    {
                        this.state = 783;
                        this.match(SqlBaseParser.ROLLBACK);
                        this.state = 785;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.WORK) {
                            {
                                this.state = 784;
                                this.match(SqlBaseParser.WORK);
                            }
                        }
                    }
                    break;
                case 58:
                    _localctx = new PrepareContext(_localctx);
                    this.enterOuterAlt(_localctx, 58);
                    {
                        this.state = 787;
                        this.match(SqlBaseParser.PREPARE);
                        this.state = 788;
                        this.identifier();
                        this.state = 789;
                        this.match(SqlBaseParser.FROM);
                        this.state = 790;
                        this.statement();
                    }
                    break;
                case 59:
                    _localctx = new DeallocateContext(_localctx);
                    this.enterOuterAlt(_localctx, 59);
                    {
                        this.state = 792;
                        this.match(SqlBaseParser.DEALLOCATE);
                        this.state = 793;
                        this.match(SqlBaseParser.PREPARE);
                        this.state = 794;
                        this.identifier();
                    }
                    break;
                case 60:
                    _localctx = new ExecuteContext(_localctx);
                    this.enterOuterAlt(_localctx, 60);
                    {
                        this.state = 795;
                        this.match(SqlBaseParser.EXECUTE);
                        this.state = 796;
                        this.identifier();
                        this.state = 806;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.USING) {
                            {
                                this.state = 797;
                                this.match(SqlBaseParser.USING);
                                this.state = 798;
                                this.expression();
                                this.state = 803;
                                this._errHandler.sync(this);
                                _la = this._input.LA(1);
                                while (_la === SqlBaseParser.T__3) {
                                    {
                                        {
                                            this.state = 799;
                                            this.match(SqlBaseParser.T__3);
                                            this.state = 800;
                                            this.expression();
                                        }
                                    }
                                    this.state = 805;
                                    this._errHandler.sync(this);
                                    _la = this._input.LA(1);
                                }
                            }
                        }
                    }
                    break;
                case 61:
                    _localctx = new DescribeInputContext(_localctx);
                    this.enterOuterAlt(_localctx, 61);
                    {
                        this.state = 808;
                        this.match(SqlBaseParser.DESCRIBE);
                        this.state = 809;
                        this.match(SqlBaseParser.INPUT);
                        this.state = 810;
                        this.identifier();
                    }
                    break;
                case 62:
                    _localctx = new DescribeOutputContext(_localctx);
                    this.enterOuterAlt(_localctx, 62);
                    {
                        this.state = 811;
                        this.match(SqlBaseParser.DESCRIBE);
                        this.state = 812;
                        this.match(SqlBaseParser.OUTPUT);
                        this.state = 813;
                        this.identifier();
                    }
                    break;
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    query() {
        let _localctx = new QueryContext(this._ctx, this.state);
        this.enterRule(_localctx, 8, SqlBaseParser.RULE_query);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 817;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la === SqlBaseParser.WITH) {
                    {
                        this.state = 816;
                        this.queryWith();
                    }
                }
                this.state = 819;
                this.queryNoWith();
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    queryWith() {
        let _localctx = new QueryWithContext(this._ctx, this.state);
        this.enterRule(_localctx, 10, SqlBaseParser.RULE_queryWith);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 821;
                this.match(SqlBaseParser.WITH);
                this.state = 823;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la === SqlBaseParser.RECURSIVE) {
                    {
                        this.state = 822;
                        this.match(SqlBaseParser.RECURSIVE);
                    }
                }
                this.state = 825;
                this.namedQuery();
                this.state = 830;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                while (_la === SqlBaseParser.T__3) {
                    {
                        {
                            this.state = 826;
                            this.match(SqlBaseParser.T__3);
                            this.state = 827;
                            this.namedQuery();
                        }
                    }
                    this.state = 832;
                    this._errHandler.sync(this);
                    _la = this._input.LA(1);
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    tableElement() {
        let _localctx = new TableElementContext(this._ctx, this.state);
        this.enterRule(_localctx, 12, SqlBaseParser.RULE_tableElement);
        try {
            this.state = 835;
            this._errHandler.sync(this);
            switch (this._input.LA(1)) {
                case SqlBaseParser.ADD:
                case SqlBaseParser.ADMIN:
                case SqlBaseParser.ALL:
                case SqlBaseParser.ANALYZE:
                case SqlBaseParser.ANY:
                case SqlBaseParser.ARRAY:
                case SqlBaseParser.ASC:
                case SqlBaseParser.AT:
                case SqlBaseParser.BERNOULLI:
                case SqlBaseParser.CALL:
                case SqlBaseParser.CALLED:
                case SqlBaseParser.CASCADE:
                case SqlBaseParser.CATALOGS:
                case SqlBaseParser.COLUMN:
                case SqlBaseParser.COLUMNS:
                case SqlBaseParser.COMMENT:
                case SqlBaseParser.COMMIT:
                case SqlBaseParser.COMMITTED:
                case SqlBaseParser.CURRENT:
                case SqlBaseParser.CURRENT_ROLE:
                case SqlBaseParser.DATA:
                case SqlBaseParser.DATE:
                case SqlBaseParser.DAY:
                case SqlBaseParser.DEFINER:
                case SqlBaseParser.DESC:
                case SqlBaseParser.DETERMINISTIC:
                case SqlBaseParser.DISTRIBUTED:
                case SqlBaseParser.EXCLUDING:
                case SqlBaseParser.EXPLAIN:
                case SqlBaseParser.EXTERNAL:
                case SqlBaseParser.FILTER:
                case SqlBaseParser.FIRST:
                case SqlBaseParser.FOLLOWING:
                case SqlBaseParser.FORMAT:
                case SqlBaseParser.FUNCTION:
                case SqlBaseParser.FUNCTIONS:
                case SqlBaseParser.GRANT:
                case SqlBaseParser.GRANTED:
                case SqlBaseParser.GRANTS:
                case SqlBaseParser.GRAPHVIZ:
                case SqlBaseParser.HOUR:
                case SqlBaseParser.IF:
                case SqlBaseParser.IGNORE:
                case SqlBaseParser.INCLUDING:
                case SqlBaseParser.INPUT:
                case SqlBaseParser.INTERVAL:
                case SqlBaseParser.INVOKER:
                case SqlBaseParser.IO:
                case SqlBaseParser.ISOLATION:
                case SqlBaseParser.JSON:
                case SqlBaseParser.LANGUAGE:
                case SqlBaseParser.LAST:
                case SqlBaseParser.LATERAL:
                case SqlBaseParser.LEVEL:
                case SqlBaseParser.LIMIT:
                case SqlBaseParser.LOGICAL:
                case SqlBaseParser.MAP:
                case SqlBaseParser.MATERIALIZED:
                case SqlBaseParser.MINUTE:
                case SqlBaseParser.MONTH:
                case SqlBaseParser.NAME:
                case SqlBaseParser.NFC:
                case SqlBaseParser.NFD:
                case SqlBaseParser.NFKC:
                case SqlBaseParser.NFKD:
                case SqlBaseParser.NO:
                case SqlBaseParser.NONE:
                case SqlBaseParser.NULLIF:
                case SqlBaseParser.NULLS:
                case SqlBaseParser.OFFSET:
                case SqlBaseParser.ONLY:
                case SqlBaseParser.OPTION:
                case SqlBaseParser.ORDINALITY:
                case SqlBaseParser.OUTPUT:
                case SqlBaseParser.OVER:
                case SqlBaseParser.PARTITION:
                case SqlBaseParser.PARTITIONS:
                case SqlBaseParser.POSITION:
                case SqlBaseParser.PRECEDING:
                case SqlBaseParser.PRIVILEGES:
                case SqlBaseParser.PROPERTIES:
                case SqlBaseParser.RANGE:
                case SqlBaseParser.READ:
                case SqlBaseParser.REFRESH:
                case SqlBaseParser.RENAME:
                case SqlBaseParser.REPEATABLE:
                case SqlBaseParser.REPLACE:
                case SqlBaseParser.RESET:
                case SqlBaseParser.RESPECT:
                case SqlBaseParser.RESTRICT:
                case SqlBaseParser.RETURN:
                case SqlBaseParser.RETURNS:
                case SqlBaseParser.REVOKE:
                case SqlBaseParser.ROLE:
                case SqlBaseParser.ROLES:
                case SqlBaseParser.ROLLBACK:
                case SqlBaseParser.ROW:
                case SqlBaseParser.ROWS:
                case SqlBaseParser.SCHEMA:
                case SqlBaseParser.SCHEMAS:
                case SqlBaseParser.SECOND:
                case SqlBaseParser.SECURITY:
                case SqlBaseParser.SERIALIZABLE:
                case SqlBaseParser.SESSION:
                case SqlBaseParser.SET:
                case SqlBaseParser.SETS:
                case SqlBaseParser.SHOW:
                case SqlBaseParser.SOME:
                case SqlBaseParser.SQL:
                case SqlBaseParser.START:
                case SqlBaseParser.STATS:
                case SqlBaseParser.SUBSTRING:
                case SqlBaseParser.SYSTEM:
                case SqlBaseParser.TABLES:
                case SqlBaseParser.TABLESAMPLE:
                case SqlBaseParser.TEMPORARY:
                case SqlBaseParser.TEXT:
                case SqlBaseParser.TIME:
                case SqlBaseParser.TIMESTAMP:
                case SqlBaseParser.TO:
                case SqlBaseParser.TRANSACTION:
                case SqlBaseParser.TRY_CAST:
                case SqlBaseParser.TYPE:
                case SqlBaseParser.UNBOUNDED:
                case SqlBaseParser.UNCOMMITTED:
                case SqlBaseParser.USE:
                case SqlBaseParser.USER:
                case SqlBaseParser.VALIDATE:
                case SqlBaseParser.VERBOSE:
                case SqlBaseParser.VIEW:
                case SqlBaseParser.WORK:
                case SqlBaseParser.WRITE:
                case SqlBaseParser.YEAR:
                case SqlBaseParser.ZONE:
                case SqlBaseParser.IDENTIFIER:
                case SqlBaseParser.DIGIT_IDENTIFIER:
                case SqlBaseParser.QUOTED_IDENTIFIER:
                case SqlBaseParser.BACKQUOTED_IDENTIFIER:
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 833;
                        this.columnDefinition();
                    }
                    break;
                case SqlBaseParser.LIKE:
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 834;
                        this.likeClause();
                    }
                    break;
                default:
                    throw new NoViableAltException_1.NoViableAltException(this);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    columnDefinition() {
        let _localctx = new ColumnDefinitionContext(this._ctx, this.state);
        this.enterRule(_localctx, 14, SqlBaseParser.RULE_columnDefinition);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 837;
                this.identifier();
                this.state = 838;
                this.type(0);
                this.state = 841;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la === SqlBaseParser.NOT) {
                    {
                        this.state = 839;
                        this.match(SqlBaseParser.NOT);
                        this.state = 840;
                        this.match(SqlBaseParser.NULL);
                    }
                }
                this.state = 845;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la === SqlBaseParser.COMMENT) {
                    {
                        this.state = 843;
                        this.match(SqlBaseParser.COMMENT);
                        this.state = 844;
                        this.string();
                    }
                }
                this.state = 849;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la === SqlBaseParser.WITH) {
                    {
                        this.state = 847;
                        this.match(SqlBaseParser.WITH);
                        this.state = 848;
                        this.properties();
                    }
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    likeClause() {
        let _localctx = new LikeClauseContext(this._ctx, this.state);
        this.enterRule(_localctx, 16, SqlBaseParser.RULE_likeClause);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 851;
                this.match(SqlBaseParser.LIKE);
                this.state = 852;
                this.qualifiedName();
                this.state = 855;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la === SqlBaseParser.EXCLUDING || _la === SqlBaseParser.INCLUDING) {
                    {
                        this.state = 853;
                        _localctx._optionType = this._input.LT(1);
                        _la = this._input.LA(1);
                        if (!(_la === SqlBaseParser.EXCLUDING || _la === SqlBaseParser.INCLUDING)) {
                            _localctx._optionType = this._errHandler.recoverInline(this);
                        }
                        else {
                            if (this._input.LA(1) === Token_1.Token.EOF) {
                                this.matchedEOF = true;
                            }
                            this._errHandler.reportMatch(this);
                            this.consume();
                        }
                        this.state = 854;
                        this.match(SqlBaseParser.PROPERTIES);
                    }
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    properties() {
        let _localctx = new PropertiesContext(this._ctx, this.state);
        this.enterRule(_localctx, 18, SqlBaseParser.RULE_properties);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 857;
                this.match(SqlBaseParser.T__1);
                this.state = 858;
                this.property();
                this.state = 863;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                while (_la === SqlBaseParser.T__3) {
                    {
                        {
                            this.state = 859;
                            this.match(SqlBaseParser.T__3);
                            this.state = 860;
                            this.property();
                        }
                    }
                    this.state = 865;
                    this._errHandler.sync(this);
                    _la = this._input.LA(1);
                }
                this.state = 866;
                this.match(SqlBaseParser.T__2);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    property() {
        let _localctx = new PropertyContext(this._ctx, this.state);
        this.enterRule(_localctx, 20, SqlBaseParser.RULE_property);
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 868;
                this.identifier();
                this.state = 869;
                this.match(SqlBaseParser.EQ);
                this.state = 870;
                this.expression();
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    sqlParameterDeclaration() {
        let _localctx = new SqlParameterDeclarationContext(this._ctx, this.state);
        this.enterRule(_localctx, 22, SqlBaseParser.RULE_sqlParameterDeclaration);
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 872;
                this.identifier();
                this.state = 873;
                this.type(0);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    routineCharacteristics() {
        let _localctx = new RoutineCharacteristicsContext(this._ctx, this.state);
        this.enterRule(_localctx, 24, SqlBaseParser.RULE_routineCharacteristics);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 878;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                while (_la === SqlBaseParser.CALLED || _la === SqlBaseParser.DETERMINISTIC || _la === SqlBaseParser.LANGUAGE || _la === SqlBaseParser.NOT || _la === SqlBaseParser.RETURNS) {
                    {
                        {
                            this.state = 875;
                            this.routineCharacteristic();
                        }
                    }
                    this.state = 880;
                    this._errHandler.sync(this);
                    _la = this._input.LA(1);
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    routineCharacteristic() {
        let _localctx = new RoutineCharacteristicContext(this._ctx, this.state);
        this.enterRule(_localctx, 26, SqlBaseParser.RULE_routineCharacteristic);
        try {
            this.state = 885;
            this._errHandler.sync(this);
            switch (this._input.LA(1)) {
                case SqlBaseParser.LANGUAGE:
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 881;
                        this.match(SqlBaseParser.LANGUAGE);
                        this.state = 882;
                        this.language();
                    }
                    break;
                case SqlBaseParser.DETERMINISTIC:
                case SqlBaseParser.NOT:
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 883;
                        this.determinism();
                    }
                    break;
                case SqlBaseParser.CALLED:
                case SqlBaseParser.RETURNS:
                    this.enterOuterAlt(_localctx, 3);
                    {
                        this.state = 884;
                        this.nullCallClause();
                    }
                    break;
                default:
                    throw new NoViableAltException_1.NoViableAltException(this);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    alterRoutineCharacteristics() {
        let _localctx = new AlterRoutineCharacteristicsContext(this._ctx, this.state);
        this.enterRule(_localctx, 28, SqlBaseParser.RULE_alterRoutineCharacteristics);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 890;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                while (_la === SqlBaseParser.CALLED || _la === SqlBaseParser.RETURNS) {
                    {
                        {
                            this.state = 887;
                            this.alterRoutineCharacteristic();
                        }
                    }
                    this.state = 892;
                    this._errHandler.sync(this);
                    _la = this._input.LA(1);
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    alterRoutineCharacteristic() {
        let _localctx = new AlterRoutineCharacteristicContext(this._ctx, this.state);
        this.enterRule(_localctx, 30, SqlBaseParser.RULE_alterRoutineCharacteristic);
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 893;
                this.nullCallClause();
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    routineBody() {
        let _localctx = new RoutineBodyContext(this._ctx, this.state);
        this.enterRule(_localctx, 32, SqlBaseParser.RULE_routineBody);
        try {
            this.state = 897;
            this._errHandler.sync(this);
            switch (this._input.LA(1)) {
                case SqlBaseParser.RETURN:
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 895;
                        this.returnStatement();
                    }
                    break;
                case SqlBaseParser.EXTERNAL:
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 896;
                        this.externalBodyReference();
                    }
                    break;
                default:
                    throw new NoViableAltException_1.NoViableAltException(this);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    returnStatement() {
        let _localctx = new ReturnStatementContext(this._ctx, this.state);
        this.enterRule(_localctx, 34, SqlBaseParser.RULE_returnStatement);
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 899;
                this.match(SqlBaseParser.RETURN);
                this.state = 900;
                this.expression();
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    externalBodyReference() {
        let _localctx = new ExternalBodyReferenceContext(this._ctx, this.state);
        this.enterRule(_localctx, 36, SqlBaseParser.RULE_externalBodyReference);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 902;
                this.match(SqlBaseParser.EXTERNAL);
                this.state = 905;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la === SqlBaseParser.NAME) {
                    {
                        this.state = 903;
                        this.match(SqlBaseParser.NAME);
                        this.state = 904;
                        this.externalRoutineName();
                    }
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    language() {
        let _localctx = new LanguageContext(this._ctx, this.state);
        this.enterRule(_localctx, 38, SqlBaseParser.RULE_language);
        try {
            this.state = 909;
            this._errHandler.sync(this);
            switch (this.interpreter.adaptivePredict(this._input, 105, this._ctx)) {
                case 1:
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 907;
                        this.match(SqlBaseParser.SQL);
                    }
                    break;
                case 2:
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 908;
                        this.identifier();
                    }
                    break;
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    determinism() {
        let _localctx = new DeterminismContext(this._ctx, this.state);
        this.enterRule(_localctx, 40, SqlBaseParser.RULE_determinism);
        try {
            this.state = 914;
            this._errHandler.sync(this);
            switch (this._input.LA(1)) {
                case SqlBaseParser.DETERMINISTIC:
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 911;
                        this.match(SqlBaseParser.DETERMINISTIC);
                    }
                    break;
                case SqlBaseParser.NOT:
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 912;
                        this.match(SqlBaseParser.NOT);
                        this.state = 913;
                        this.match(SqlBaseParser.DETERMINISTIC);
                    }
                    break;
                default:
                    throw new NoViableAltException_1.NoViableAltException(this);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    nullCallClause() {
        let _localctx = new NullCallClauseContext(this._ctx, this.state);
        this.enterRule(_localctx, 42, SqlBaseParser.RULE_nullCallClause);
        try {
            this.state = 925;
            this._errHandler.sync(this);
            switch (this._input.LA(1)) {
                case SqlBaseParser.RETURNS:
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 916;
                        this.match(SqlBaseParser.RETURNS);
                        this.state = 917;
                        this.match(SqlBaseParser.NULL);
                        this.state = 918;
                        this.match(SqlBaseParser.ON);
                        this.state = 919;
                        this.match(SqlBaseParser.NULL);
                        this.state = 920;
                        this.match(SqlBaseParser.INPUT);
                    }
                    break;
                case SqlBaseParser.CALLED:
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 921;
                        this.match(SqlBaseParser.CALLED);
                        this.state = 922;
                        this.match(SqlBaseParser.ON);
                        this.state = 923;
                        this.match(SqlBaseParser.NULL);
                        this.state = 924;
                        this.match(SqlBaseParser.INPUT);
                    }
                    break;
                default:
                    throw new NoViableAltException_1.NoViableAltException(this);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    externalRoutineName() {
        let _localctx = new ExternalRoutineNameContext(this._ctx, this.state);
        this.enterRule(_localctx, 44, SqlBaseParser.RULE_externalRoutineName);
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 927;
                this.identifier();
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    queryNoWith() {
        let _localctx = new QueryNoWithContext(this._ctx, this.state);
        this.enterRule(_localctx, 46, SqlBaseParser.RULE_queryNoWith);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 929;
                this.queryTerm(0);
                this.state = 940;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la === SqlBaseParser.ORDER) {
                    {
                        this.state = 930;
                        this.match(SqlBaseParser.ORDER);
                        this.state = 931;
                        this.match(SqlBaseParser.BY);
                        this.state = 932;
                        this.sortItem();
                        this.state = 937;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        while (_la === SqlBaseParser.T__3) {
                            {
                                {
                                    this.state = 933;
                                    this.match(SqlBaseParser.T__3);
                                    this.state = 934;
                                    this.sortItem();
                                }
                            }
                            this.state = 939;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                        }
                    }
                }
                this.state = 947;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la === SqlBaseParser.OFFSET) {
                    {
                        this.state = 942;
                        this.match(SqlBaseParser.OFFSET);
                        this.state = 943;
                        _localctx._offset = this.match(SqlBaseParser.INTEGER_VALUE);
                        this.state = 945;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.ROW || _la === SqlBaseParser.ROWS) {
                            {
                                this.state = 944;
                                _la = this._input.LA(1);
                                if (!(_la === SqlBaseParser.ROW || _la === SqlBaseParser.ROWS)) {
                                    this._errHandler.recoverInline(this);
                                }
                                else {
                                    if (this._input.LA(1) === Token_1.Token.EOF) {
                                        this.matchedEOF = true;
                                    }
                                    this._errHandler.reportMatch(this);
                                    this.consume();
                                }
                            }
                        }
                    }
                }
                this.state = 951;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la === SqlBaseParser.LIMIT) {
                    {
                        this.state = 949;
                        this.match(SqlBaseParser.LIMIT);
                        this.state = 950;
                        _localctx._limit = this._input.LT(1);
                        _la = this._input.LA(1);
                        if (!(_la === SqlBaseParser.ALL || _la === SqlBaseParser.INTEGER_VALUE)) {
                            _localctx._limit = this._errHandler.recoverInline(this);
                        }
                        else {
                            if (this._input.LA(1) === Token_1.Token.EOF) {
                                this.matchedEOF = true;
                            }
                            this._errHandler.reportMatch(this);
                            this.consume();
                        }
                    }
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    queryTerm(_p) {
        if (_p === undefined) {
            _p = 0;
        }
        let _parentctx = this._ctx;
        let _parentState = this.state;
        let _localctx = new QueryTermContext(this._ctx, _parentState);
        let _prevctx = _localctx;
        let _startState = 48;
        this.enterRecursionRule(_localctx, 48, SqlBaseParser.RULE_queryTerm, _p);
        let _la;
        try {
            let _alt;
            this.enterOuterAlt(_localctx, 1);
            {
                {
                    _localctx = new QueryTermDefaultContext(_localctx);
                    this._ctx = _localctx;
                    _prevctx = _localctx;
                    this.state = 954;
                    this.queryPrimary();
                }
                this._ctx._stop = this._input.tryLT(-1);
                this.state = 970;
                this._errHandler.sync(this);
                _alt = this.interpreter.adaptivePredict(this._input, 116, this._ctx);
                while (_alt !== 2 && _alt !== ATN_1.ATN.INVALID_ALT_NUMBER) {
                    if (_alt === 1) {
                        if (this._parseListeners != null) {
                            this.triggerExitRuleEvent();
                        }
                        _prevctx = _localctx;
                        {
                            this.state = 968;
                            this._errHandler.sync(this);
                            switch (this.interpreter.adaptivePredict(this._input, 115, this._ctx)) {
                                case 1:
                                    {
                                        _localctx = new SetOperationContext(new QueryTermContext(_parentctx, _parentState));
                                        _localctx._left = _prevctx;
                                        this.pushNewRecursionContext(_localctx, _startState, SqlBaseParser.RULE_queryTerm);
                                        this.state = 956;
                                        if (!(this.precpred(this._ctx, 2))) {
                                            throw this.createFailedPredicateException("this.precpred(this._ctx, 2)");
                                        }
                                        this.state = 957;
                                        _localctx._operator = this.match(SqlBaseParser.INTERSECT);
                                        this.state = 959;
                                        this._errHandler.sync(this);
                                        _la = this._input.LA(1);
                                        if (_la === SqlBaseParser.ALL || _la === SqlBaseParser.DISTINCT) {
                                            {
                                                this.state = 958;
                                                this.setQuantifier();
                                            }
                                        }
                                        this.state = 961;
                                        _localctx._right = this.queryTerm(3);
                                    }
                                    break;
                                case 2:
                                    {
                                        _localctx = new SetOperationContext(new QueryTermContext(_parentctx, _parentState));
                                        _localctx._left = _prevctx;
                                        this.pushNewRecursionContext(_localctx, _startState, SqlBaseParser.RULE_queryTerm);
                                        this.state = 962;
                                        if (!(this.precpred(this._ctx, 1))) {
                                            throw this.createFailedPredicateException("this.precpred(this._ctx, 1)");
                                        }
                                        this.state = 963;
                                        _localctx._operator = this._input.LT(1);
                                        _la = this._input.LA(1);
                                        if (!(_la === SqlBaseParser.EXCEPT || _la === SqlBaseParser.UNION)) {
                                            _localctx._operator = this._errHandler.recoverInline(this);
                                        }
                                        else {
                                            if (this._input.LA(1) === Token_1.Token.EOF) {
                                                this.matchedEOF = true;
                                            }
                                            this._errHandler.reportMatch(this);
                                            this.consume();
                                        }
                                        this.state = 965;
                                        this._errHandler.sync(this);
                                        _la = this._input.LA(1);
                                        if (_la === SqlBaseParser.ALL || _la === SqlBaseParser.DISTINCT) {
                                            {
                                                this.state = 964;
                                                this.setQuantifier();
                                            }
                                        }
                                        this.state = 967;
                                        _localctx._right = this.queryTerm(2);
                                    }
                                    break;
                            }
                        }
                    }
                    this.state = 972;
                    this._errHandler.sync(this);
                    _alt = this.interpreter.adaptivePredict(this._input, 116, this._ctx);
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }
    // @RuleVersion(0)
    queryPrimary() {
        let _localctx = new QueryPrimaryContext(this._ctx, this.state);
        this.enterRule(_localctx, 50, SqlBaseParser.RULE_queryPrimary);
        try {
            let _alt;
            this.state = 989;
            this._errHandler.sync(this);
            switch (this._input.LA(1)) {
                case SqlBaseParser.SELECT:
                    _localctx = new QueryPrimaryDefaultContext(_localctx);
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 973;
                        this.querySpecification();
                    }
                    break;
                case SqlBaseParser.TABLE:
                    _localctx = new TableContext(_localctx);
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 974;
                        this.match(SqlBaseParser.TABLE);
                        this.state = 975;
                        this.qualifiedName();
                    }
                    break;
                case SqlBaseParser.VALUES:
                    _localctx = new InlineTableContext(_localctx);
                    this.enterOuterAlt(_localctx, 3);
                    {
                        this.state = 976;
                        this.match(SqlBaseParser.VALUES);
                        this.state = 977;
                        this.expression();
                        this.state = 982;
                        this._errHandler.sync(this);
                        _alt = this.interpreter.adaptivePredict(this._input, 117, this._ctx);
                        while (_alt !== 2 && _alt !== ATN_1.ATN.INVALID_ALT_NUMBER) {
                            if (_alt === 1) {
                                {
                                    {
                                        this.state = 978;
                                        this.match(SqlBaseParser.T__3);
                                        this.state = 979;
                                        this.expression();
                                    }
                                }
                            }
                            this.state = 984;
                            this._errHandler.sync(this);
                            _alt = this.interpreter.adaptivePredict(this._input, 117, this._ctx);
                        }
                    }
                    break;
                case SqlBaseParser.T__1:
                    _localctx = new SubqueryContext(_localctx);
                    this.enterOuterAlt(_localctx, 4);
                    {
                        this.state = 985;
                        this.match(SqlBaseParser.T__1);
                        this.state = 986;
                        this.queryNoWith();
                        this.state = 987;
                        this.match(SqlBaseParser.T__2);
                    }
                    break;
                default:
                    throw new NoViableAltException_1.NoViableAltException(this);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    sortItem() {
        let _localctx = new SortItemContext(this._ctx, this.state);
        this.enterRule(_localctx, 52, SqlBaseParser.RULE_sortItem);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 991;
                this.expression();
                this.state = 993;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la === SqlBaseParser.ASC || _la === SqlBaseParser.DESC) {
                    {
                        this.state = 992;
                        _localctx._ordering = this._input.LT(1);
                        _la = this._input.LA(1);
                        if (!(_la === SqlBaseParser.ASC || _la === SqlBaseParser.DESC)) {
                            _localctx._ordering = this._errHandler.recoverInline(this);
                        }
                        else {
                            if (this._input.LA(1) === Token_1.Token.EOF) {
                                this.matchedEOF = true;
                            }
                            this._errHandler.reportMatch(this);
                            this.consume();
                        }
                    }
                }
                this.state = 997;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la === SqlBaseParser.NULLS) {
                    {
                        this.state = 995;
                        this.match(SqlBaseParser.NULLS);
                        this.state = 996;
                        _localctx._nullOrdering = this._input.LT(1);
                        _la = this._input.LA(1);
                        if (!(_la === SqlBaseParser.FIRST || _la === SqlBaseParser.LAST)) {
                            _localctx._nullOrdering = this._errHandler.recoverInline(this);
                        }
                        else {
                            if (this._input.LA(1) === Token_1.Token.EOF) {
                                this.matchedEOF = true;
                            }
                            this._errHandler.reportMatch(this);
                            this.consume();
                        }
                    }
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    querySpecification() {
        let _localctx = new QuerySpecificationContext(this._ctx, this.state);
        this.enterRule(_localctx, 54, SqlBaseParser.RULE_querySpecification);
        try {
            let _alt;
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 999;
                this.match(SqlBaseParser.SELECT);
                this.state = 1001;
                this._errHandler.sync(this);
                switch (this.interpreter.adaptivePredict(this._input, 121, this._ctx)) {
                    case 1:
                        {
                            this.state = 1000;
                            this.setQuantifier();
                        }
                        break;
                }
                this.state = 1003;
                this.selectItem();
                this.state = 1008;
                this._errHandler.sync(this);
                _alt = this.interpreter.adaptivePredict(this._input, 122, this._ctx);
                while (_alt !== 2 && _alt !== ATN_1.ATN.INVALID_ALT_NUMBER) {
                    if (_alt === 1) {
                        {
                            {
                                this.state = 1004;
                                this.match(SqlBaseParser.T__3);
                                this.state = 1005;
                                this.selectItem();
                            }
                        }
                    }
                    this.state = 1010;
                    this._errHandler.sync(this);
                    _alt = this.interpreter.adaptivePredict(this._input, 122, this._ctx);
                }
                this.state = 1020;
                this._errHandler.sync(this);
                switch (this.interpreter.adaptivePredict(this._input, 124, this._ctx)) {
                    case 1:
                        {
                            this.state = 1011;
                            this.match(SqlBaseParser.FROM);
                            this.state = 1012;
                            this.relation(0);
                            this.state = 1017;
                            this._errHandler.sync(this);
                            _alt = this.interpreter.adaptivePredict(this._input, 123, this._ctx);
                            while (_alt !== 2 && _alt !== ATN_1.ATN.INVALID_ALT_NUMBER) {
                                if (_alt === 1) {
                                    {
                                        {
                                            this.state = 1013;
                                            this.match(SqlBaseParser.T__3);
                                            this.state = 1014;
                                            this.relation(0);
                                        }
                                    }
                                }
                                this.state = 1019;
                                this._errHandler.sync(this);
                                _alt = this.interpreter.adaptivePredict(this._input, 123, this._ctx);
                            }
                        }
                        break;
                }
                this.state = 1024;
                this._errHandler.sync(this);
                switch (this.interpreter.adaptivePredict(this._input, 125, this._ctx)) {
                    case 1:
                        {
                            this.state = 1022;
                            this.match(SqlBaseParser.WHERE);
                            this.state = 1023;
                            _localctx._where = this.whereExpression();
                        }
                        break;
                }
                this.state = 1029;
                this._errHandler.sync(this);
                switch (this.interpreter.adaptivePredict(this._input, 126, this._ctx)) {
                    case 1:
                        {
                            this.state = 1026;
                            this.match(SqlBaseParser.GROUP);
                            this.state = 1027;
                            this.match(SqlBaseParser.BY);
                            this.state = 1028;
                            this.groupBy();
                        }
                        break;
                }
                this.state = 1033;
                this._errHandler.sync(this);
                switch (this.interpreter.adaptivePredict(this._input, 127, this._ctx)) {
                    case 1:
                        {
                            this.state = 1031;
                            this.match(SqlBaseParser.HAVING);
                            this.state = 1032;
                            _localctx._having = this.havingExpression();
                        }
                        break;
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    groupBy() {
        let _localctx = new GroupByContext(this._ctx, this.state);
        this.enterRule(_localctx, 56, SqlBaseParser.RULE_groupBy);
        try {
            let _alt;
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1036;
                this._errHandler.sync(this);
                switch (this.interpreter.adaptivePredict(this._input, 128, this._ctx)) {
                    case 1:
                        {
                            this.state = 1035;
                            this.setQuantifier();
                        }
                        break;
                }
                this.state = 1038;
                this.groupingElement();
                this.state = 1043;
                this._errHandler.sync(this);
                _alt = this.interpreter.adaptivePredict(this._input, 129, this._ctx);
                while (_alt !== 2 && _alt !== ATN_1.ATN.INVALID_ALT_NUMBER) {
                    if (_alt === 1) {
                        {
                            {
                                this.state = 1039;
                                this.match(SqlBaseParser.T__3);
                                this.state = 1040;
                                this.groupingElement();
                            }
                        }
                    }
                    this.state = 1045;
                    this._errHandler.sync(this);
                    _alt = this.interpreter.adaptivePredict(this._input, 129, this._ctx);
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    groupingElement() {
        let _localctx = new GroupingElementContext(this._ctx, this.state);
        this.enterRule(_localctx, 58, SqlBaseParser.RULE_groupingElement);
        let _la;
        try {
            this.state = 1086;
            this._errHandler.sync(this);
            switch (this.interpreter.adaptivePredict(this._input, 135, this._ctx)) {
                case 1:
                    _localctx = new SingleGroupingSetContext(_localctx);
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1046;
                        this.groupingSet();
                    }
                    break;
                case 2:
                    _localctx = new RollupContext(_localctx);
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1047;
                        this.match(SqlBaseParser.ROLLUP);
                        this.state = 1048;
                        this.match(SqlBaseParser.T__1);
                        this.state = 1057;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if ((((_la) & ~0x1F) === 0 && ((1 << _la) & ((1 << SqlBaseParser.T__1) | (1 << SqlBaseParser.T__4) | (1 << SqlBaseParser.ADD) | (1 << SqlBaseParser.ADMIN) | (1 << SqlBaseParser.ALL) | (1 << SqlBaseParser.ANALYZE) | (1 << SqlBaseParser.ANY) | (1 << SqlBaseParser.ARRAY) | (1 << SqlBaseParser.ASC) | (1 << SqlBaseParser.AT) | (1 << SqlBaseParser.BERNOULLI) | (1 << SqlBaseParser.CALL) | (1 << SqlBaseParser.CALLED) | (1 << SqlBaseParser.CASCADE) | (1 << SqlBaseParser.CASE) | (1 << SqlBaseParser.CAST) | (1 << SqlBaseParser.CATALOGS) | (1 << SqlBaseParser.COLUMN) | (1 << SqlBaseParser.COLUMNS))) !== 0) || ((((_la - 32)) & ~0x1F) === 0 && ((1 << (_la - 32)) & ((1 << (SqlBaseParser.COMMENT - 32)) | (1 << (SqlBaseParser.COMMIT - 32)) | (1 << (SqlBaseParser.COMMITTED - 32)) | (1 << (SqlBaseParser.CURRENT - 32)) | (1 << (SqlBaseParser.CURRENT_DATE - 32)) | (1 << (SqlBaseParser.CURRENT_ROLE - 32)) | (1 << (SqlBaseParser.CURRENT_TIME - 32)) | (1 << (SqlBaseParser.CURRENT_TIMESTAMP - 32)) | (1 << (SqlBaseParser.CURRENT_USER - 32)) | (1 << (SqlBaseParser.DATA - 32)) | (1 << (SqlBaseParser.DATE - 32)) | (1 << (SqlBaseParser.DAY - 32)) | (1 << (SqlBaseParser.DEFINER - 32)) | (1 << (SqlBaseParser.DESC - 32)) | (1 << (SqlBaseParser.DETERMINISTIC - 32)) | (1 << (SqlBaseParser.DISTRIBUTED - 32)) | (1 << (SqlBaseParser.EXCLUDING - 32)) | (1 << (SqlBaseParser.EXISTS - 32)))) !== 0) || ((((_la - 64)) & ~0x1F) === 0 && ((1 << (_la - 64)) & ((1 << (SqlBaseParser.EXPLAIN - 64)) | (1 << (SqlBaseParser.EXTRACT - 64)) | (1 << (SqlBaseParser.EXTERNAL - 64)) | (1 << (SqlBaseParser.FALSE - 64)) | (1 << (SqlBaseParser.FILTER - 64)) | (1 << (SqlBaseParser.FIRST - 64)) | (1 << (SqlBaseParser.FOLLOWING - 64)) | (1 << (SqlBaseParser.FORMAT - 64)) | (1 << (SqlBaseParser.FUNCTION - 64)) | (1 << (SqlBaseParser.FUNCTIONS - 64)) | (1 << (SqlBaseParser.GRANT - 64)) | (1 << (SqlBaseParser.GRANTED - 64)) | (1 << (SqlBaseParser.GRANTS - 64)) | (1 << (SqlBaseParser.GRAPHVIZ - 64)) | (1 << (SqlBaseParser.GROUPING - 64)) | (1 << (SqlBaseParser.HOUR - 64)) | (1 << (SqlBaseParser.IF - 64)) | (1 << (SqlBaseParser.IGNORE - 64)) | (1 << (SqlBaseParser.INCLUDING - 64)) | (1 << (SqlBaseParser.INPUT - 64)) | (1 << (SqlBaseParser.INTERVAL - 64)) | (1 << (SqlBaseParser.INVOKER - 64)))) !== 0) || ((((_la - 96)) & ~0x1F) === 0 && ((1 << (_la - 96)) & ((1 << (SqlBaseParser.IO - 96)) | (1 << (SqlBaseParser.ISOLATION - 96)) | (1 << (SqlBaseParser.JSON - 96)) | (1 << (SqlBaseParser.LANGUAGE - 96)) | (1 << (SqlBaseParser.LAST - 96)) | (1 << (SqlBaseParser.LATERAL - 96)) | (1 << (SqlBaseParser.LEVEL - 96)) | (1 << (SqlBaseParser.LIMIT - 96)) | (1 << (SqlBaseParser.LOCALTIME - 96)) | (1 << (SqlBaseParser.LOCALTIMESTAMP - 96)) | (1 << (SqlBaseParser.LOGICAL - 96)) | (1 << (SqlBaseParser.MAP - 96)) | (1 << (SqlBaseParser.MATERIALIZED - 96)) | (1 << (SqlBaseParser.MINUTE - 96)) | (1 << (SqlBaseParser.MONTH - 96)) | (1 << (SqlBaseParser.NAME - 96)) | (1 << (SqlBaseParser.NFC - 96)) | (1 << (SqlBaseParser.NFD - 96)) | (1 << (SqlBaseParser.NFKC - 96)) | (1 << (SqlBaseParser.NFKD - 96)) | (1 << (SqlBaseParser.NO - 96)) | (1 << (SqlBaseParser.NONE - 96)) | (1 << (SqlBaseParser.NORMALIZE - 96)) | (1 << (SqlBaseParser.NOT - 96)) | (1 << (SqlBaseParser.NULL - 96)) | (1 << (SqlBaseParser.NULLIF - 96)) | (1 << (SqlBaseParser.NULLS - 96)))) !== 0) || ((((_la - 128)) & ~0x1F) === 0 && ((1 << (_la - 128)) & ((1 << (SqlBaseParser.OFFSET - 128)) | (1 << (SqlBaseParser.ONLY - 128)) | (1 << (SqlBaseParser.OPTION - 128)) | (1 << (SqlBaseParser.ORDINALITY - 128)) | (1 << (SqlBaseParser.OUTPUT - 128)) | (1 << (SqlBaseParser.OVER - 128)) | (1 << (SqlBaseParser.PARTITION - 128)) | (1 << (SqlBaseParser.PARTITIONS - 128)) | (1 << (SqlBaseParser.POSITION - 128)) | (1 << (SqlBaseParser.PRECEDING - 128)) | (1 << (SqlBaseParser.PRIVILEGES - 128)) | (1 << (SqlBaseParser.PROPERTIES - 128)) | (1 << (SqlBaseParser.RANGE - 128)) | (1 << (SqlBaseParser.READ - 128)) | (1 << (SqlBaseParser.REFRESH - 128)) | (1 << (SqlBaseParser.RENAME - 128)) | (1 << (SqlBaseParser.REPEATABLE - 128)) | (1 << (SqlBaseParser.REPLACE - 128)) | (1 << (SqlBaseParser.RESET - 128)) | (1 << (SqlBaseParser.RESPECT - 128)) | (1 << (SqlBaseParser.RESTRICT - 128)) | (1 << (SqlBaseParser.RETURN - 128)) | (1 << (SqlBaseParser.RETURNS - 128)) | (1 << (SqlBaseParser.REVOKE - 128)) | (1 << (SqlBaseParser.ROLE - 128)))) !== 0) || ((((_la - 160)) & ~0x1F) === 0 && ((1 << (_la - 160)) & ((1 << (SqlBaseParser.ROLES - 160)) | (1 << (SqlBaseParser.ROLLBACK - 160)) | (1 << (SqlBaseParser.ROW - 160)) | (1 << (SqlBaseParser.ROWS - 160)) | (1 << (SqlBaseParser.SCHEMA - 160)) | (1 << (SqlBaseParser.SCHEMAS - 160)) | (1 << (SqlBaseParser.SECOND - 160)) | (1 << (SqlBaseParser.SECURITY - 160)) | (1 << (SqlBaseParser.SERIALIZABLE - 160)) | (1 << (SqlBaseParser.SESSION - 160)) | (1 << (SqlBaseParser.SET - 160)) | (1 << (SqlBaseParser.SETS - 160)) | (1 << (SqlBaseParser.SHOW - 160)) | (1 << (SqlBaseParser.SOME - 160)) | (1 << (SqlBaseParser.SQL - 160)) | (1 << (SqlBaseParser.START - 160)) | (1 << (SqlBaseParser.STATS - 160)) | (1 << (SqlBaseParser.SUBSTRING - 160)) | (1 << (SqlBaseParser.SYSTEM - 160)) | (1 << (SqlBaseParser.TABLES - 160)) | (1 << (SqlBaseParser.TABLESAMPLE - 160)) | (1 << (SqlBaseParser.TEMPORARY - 160)) | (1 << (SqlBaseParser.TEXT - 160)) | (1 << (SqlBaseParser.TIME - 160)) | (1 << (SqlBaseParser.TIMESTAMP - 160)) | (1 << (SqlBaseParser.TO - 160)) | (1 << (SqlBaseParser.TRANSACTION - 160)) | (1 << (SqlBaseParser.TRUE - 160)))) !== 0) || ((((_la - 192)) & ~0x1F) === 0 && ((1 << (_la - 192)) & ((1 << (SqlBaseParser.TRY_CAST - 192)) | (1 << (SqlBaseParser.TYPE - 192)) | (1 << (SqlBaseParser.UNBOUNDED - 192)) | (1 << (SqlBaseParser.UNCOMMITTED - 192)) | (1 << (SqlBaseParser.USE - 192)) | (1 << (SqlBaseParser.USER - 192)) | (1 << (SqlBaseParser.VALIDATE - 192)) | (1 << (SqlBaseParser.VERBOSE - 192)) | (1 << (SqlBaseParser.VIEW - 192)) | (1 << (SqlBaseParser.WORK - 192)) | (1 << (SqlBaseParser.WRITE - 192)) | (1 << (SqlBaseParser.YEAR - 192)) | (1 << (SqlBaseParser.ZONE - 192)) | (1 << (SqlBaseParser.PLUS - 192)) | (1 << (SqlBaseParser.MINUS - 192)))) !== 0) || ((((_la - 226)) & ~0x1F) === 0 && ((1 << (_la - 226)) & ((1 << (SqlBaseParser.STRING - 226)) | (1 << (SqlBaseParser.UNICODE_STRING - 226)) | (1 << (SqlBaseParser.BINARY_LITERAL - 226)) | (1 << (SqlBaseParser.INTEGER_VALUE - 226)) | (1 << (SqlBaseParser.DECIMAL_VALUE - 226)) | (1 << (SqlBaseParser.DOUBLE_VALUE - 226)) | (1 << (SqlBaseParser.IDENTIFIER - 226)) | (1 << (SqlBaseParser.DIGIT_IDENTIFIER - 226)) | (1 << (SqlBaseParser.QUOTED_IDENTIFIER - 226)) | (1 << (SqlBaseParser.BACKQUOTED_IDENTIFIER - 226)) | (1 << (SqlBaseParser.DOUBLE_PRECISION - 226)))) !== 0)) {
                            {
                                this.state = 1049;
                                this.expression();
                                this.state = 1054;
                                this._errHandler.sync(this);
                                _la = this._input.LA(1);
                                while (_la === SqlBaseParser.T__3) {
                                    {
                                        {
                                            this.state = 1050;
                                            this.match(SqlBaseParser.T__3);
                                            this.state = 1051;
                                            this.expression();
                                        }
                                    }
                                    this.state = 1056;
                                    this._errHandler.sync(this);
                                    _la = this._input.LA(1);
                                }
                            }
                        }
                        this.state = 1059;
                        this.match(SqlBaseParser.T__2);
                    }
                    break;
                case 3:
                    _localctx = new CubeContext(_localctx);
                    this.enterOuterAlt(_localctx, 3);
                    {
                        this.state = 1060;
                        this.match(SqlBaseParser.CUBE);
                        this.state = 1061;
                        this.match(SqlBaseParser.T__1);
                        this.state = 1070;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if ((((_la) & ~0x1F) === 0 && ((1 << _la) & ((1 << SqlBaseParser.T__1) | (1 << SqlBaseParser.T__4) | (1 << SqlBaseParser.ADD) | (1 << SqlBaseParser.ADMIN) | (1 << SqlBaseParser.ALL) | (1 << SqlBaseParser.ANALYZE) | (1 << SqlBaseParser.ANY) | (1 << SqlBaseParser.ARRAY) | (1 << SqlBaseParser.ASC) | (1 << SqlBaseParser.AT) | (1 << SqlBaseParser.BERNOULLI) | (1 << SqlBaseParser.CALL) | (1 << SqlBaseParser.CALLED) | (1 << SqlBaseParser.CASCADE) | (1 << SqlBaseParser.CASE) | (1 << SqlBaseParser.CAST) | (1 << SqlBaseParser.CATALOGS) | (1 << SqlBaseParser.COLUMN) | (1 << SqlBaseParser.COLUMNS))) !== 0) || ((((_la - 32)) & ~0x1F) === 0 && ((1 << (_la - 32)) & ((1 << (SqlBaseParser.COMMENT - 32)) | (1 << (SqlBaseParser.COMMIT - 32)) | (1 << (SqlBaseParser.COMMITTED - 32)) | (1 << (SqlBaseParser.CURRENT - 32)) | (1 << (SqlBaseParser.CURRENT_DATE - 32)) | (1 << (SqlBaseParser.CURRENT_ROLE - 32)) | (1 << (SqlBaseParser.CURRENT_TIME - 32)) | (1 << (SqlBaseParser.CURRENT_TIMESTAMP - 32)) | (1 << (SqlBaseParser.CURRENT_USER - 32)) | (1 << (SqlBaseParser.DATA - 32)) | (1 << (SqlBaseParser.DATE - 32)) | (1 << (SqlBaseParser.DAY - 32)) | (1 << (SqlBaseParser.DEFINER - 32)) | (1 << (SqlBaseParser.DESC - 32)) | (1 << (SqlBaseParser.DETERMINISTIC - 32)) | (1 << (SqlBaseParser.DISTRIBUTED - 32)) | (1 << (SqlBaseParser.EXCLUDING - 32)) | (1 << (SqlBaseParser.EXISTS - 32)))) !== 0) || ((((_la - 64)) & ~0x1F) === 0 && ((1 << (_la - 64)) & ((1 << (SqlBaseParser.EXPLAIN - 64)) | (1 << (SqlBaseParser.EXTRACT - 64)) | (1 << (SqlBaseParser.EXTERNAL - 64)) | (1 << (SqlBaseParser.FALSE - 64)) | (1 << (SqlBaseParser.FILTER - 64)) | (1 << (SqlBaseParser.FIRST - 64)) | (1 << (SqlBaseParser.FOLLOWING - 64)) | (1 << (SqlBaseParser.FORMAT - 64)) | (1 << (SqlBaseParser.FUNCTION - 64)) | (1 << (SqlBaseParser.FUNCTIONS - 64)) | (1 << (SqlBaseParser.GRANT - 64)) | (1 << (SqlBaseParser.GRANTED - 64)) | (1 << (SqlBaseParser.GRANTS - 64)) | (1 << (SqlBaseParser.GRAPHVIZ - 64)) | (1 << (SqlBaseParser.GROUPING - 64)) | (1 << (SqlBaseParser.HOUR - 64)) | (1 << (SqlBaseParser.IF - 64)) | (1 << (SqlBaseParser.IGNORE - 64)) | (1 << (SqlBaseParser.INCLUDING - 64)) | (1 << (SqlBaseParser.INPUT - 64)) | (1 << (SqlBaseParser.INTERVAL - 64)) | (1 << (SqlBaseParser.INVOKER - 64)))) !== 0) || ((((_la - 96)) & ~0x1F) === 0 && ((1 << (_la - 96)) & ((1 << (SqlBaseParser.IO - 96)) | (1 << (SqlBaseParser.ISOLATION - 96)) | (1 << (SqlBaseParser.JSON - 96)) | (1 << (SqlBaseParser.LANGUAGE - 96)) | (1 << (SqlBaseParser.LAST - 96)) | (1 << (SqlBaseParser.LATERAL - 96)) | (1 << (SqlBaseParser.LEVEL - 96)) | (1 << (SqlBaseParser.LIMIT - 96)) | (1 << (SqlBaseParser.LOCALTIME - 96)) | (1 << (SqlBaseParser.LOCALTIMESTAMP - 96)) | (1 << (SqlBaseParser.LOGICAL - 96)) | (1 << (SqlBaseParser.MAP - 96)) | (1 << (SqlBaseParser.MATERIALIZED - 96)) | (1 << (SqlBaseParser.MINUTE - 96)) | (1 << (SqlBaseParser.MONTH - 96)) | (1 << (SqlBaseParser.NAME - 96)) | (1 << (SqlBaseParser.NFC - 96)) | (1 << (SqlBaseParser.NFD - 96)) | (1 << (SqlBaseParser.NFKC - 96)) | (1 << (SqlBaseParser.NFKD - 96)) | (1 << (SqlBaseParser.NO - 96)) | (1 << (SqlBaseParser.NONE - 96)) | (1 << (SqlBaseParser.NORMALIZE - 96)) | (1 << (SqlBaseParser.NOT - 96)) | (1 << (SqlBaseParser.NULL - 96)) | (1 << (SqlBaseParser.NULLIF - 96)) | (1 << (SqlBaseParser.NULLS - 96)))) !== 0) || ((((_la - 128)) & ~0x1F) === 0 && ((1 << (_la - 128)) & ((1 << (SqlBaseParser.OFFSET - 128)) | (1 << (SqlBaseParser.ONLY - 128)) | (1 << (SqlBaseParser.OPTION - 128)) | (1 << (SqlBaseParser.ORDINALITY - 128)) | (1 << (SqlBaseParser.OUTPUT - 128)) | (1 << (SqlBaseParser.OVER - 128)) | (1 << (SqlBaseParser.PARTITION - 128)) | (1 << (SqlBaseParser.PARTITIONS - 128)) | (1 << (SqlBaseParser.POSITION - 128)) | (1 << (SqlBaseParser.PRECEDING - 128)) | (1 << (SqlBaseParser.PRIVILEGES - 128)) | (1 << (SqlBaseParser.PROPERTIES - 128)) | (1 << (SqlBaseParser.RANGE - 128)) | (1 << (SqlBaseParser.READ - 128)) | (1 << (SqlBaseParser.REFRESH - 128)) | (1 << (SqlBaseParser.RENAME - 128)) | (1 << (SqlBaseParser.REPEATABLE - 128)) | (1 << (SqlBaseParser.REPLACE - 128)) | (1 << (SqlBaseParser.RESET - 128)) | (1 << (SqlBaseParser.RESPECT - 128)) | (1 << (SqlBaseParser.RESTRICT - 128)) | (1 << (SqlBaseParser.RETURN - 128)) | (1 << (SqlBaseParser.RETURNS - 128)) | (1 << (SqlBaseParser.REVOKE - 128)) | (1 << (SqlBaseParser.ROLE - 128)))) !== 0) || ((((_la - 160)) & ~0x1F) === 0 && ((1 << (_la - 160)) & ((1 << (SqlBaseParser.ROLES - 160)) | (1 << (SqlBaseParser.ROLLBACK - 160)) | (1 << (SqlBaseParser.ROW - 160)) | (1 << (SqlBaseParser.ROWS - 160)) | (1 << (SqlBaseParser.SCHEMA - 160)) | (1 << (SqlBaseParser.SCHEMAS - 160)) | (1 << (SqlBaseParser.SECOND - 160)) | (1 << (SqlBaseParser.SECURITY - 160)) | (1 << (SqlBaseParser.SERIALIZABLE - 160)) | (1 << (SqlBaseParser.SESSION - 160)) | (1 << (SqlBaseParser.SET - 160)) | (1 << (SqlBaseParser.SETS - 160)) | (1 << (SqlBaseParser.SHOW - 160)) | (1 << (SqlBaseParser.SOME - 160)) | (1 << (SqlBaseParser.SQL - 160)) | (1 << (SqlBaseParser.START - 160)) | (1 << (SqlBaseParser.STATS - 160)) | (1 << (SqlBaseParser.SUBSTRING - 160)) | (1 << (SqlBaseParser.SYSTEM - 160)) | (1 << (SqlBaseParser.TABLES - 160)) | (1 << (SqlBaseParser.TABLESAMPLE - 160)) | (1 << (SqlBaseParser.TEMPORARY - 160)) | (1 << (SqlBaseParser.TEXT - 160)) | (1 << (SqlBaseParser.TIME - 160)) | (1 << (SqlBaseParser.TIMESTAMP - 160)) | (1 << (SqlBaseParser.TO - 160)) | (1 << (SqlBaseParser.TRANSACTION - 160)) | (1 << (SqlBaseParser.TRUE - 160)))) !== 0) || ((((_la - 192)) & ~0x1F) === 0 && ((1 << (_la - 192)) & ((1 << (SqlBaseParser.TRY_CAST - 192)) | (1 << (SqlBaseParser.TYPE - 192)) | (1 << (SqlBaseParser.UNBOUNDED - 192)) | (1 << (SqlBaseParser.UNCOMMITTED - 192)) | (1 << (SqlBaseParser.USE - 192)) | (1 << (SqlBaseParser.USER - 192)) | (1 << (SqlBaseParser.VALIDATE - 192)) | (1 << (SqlBaseParser.VERBOSE - 192)) | (1 << (SqlBaseParser.VIEW - 192)) | (1 << (SqlBaseParser.WORK - 192)) | (1 << (SqlBaseParser.WRITE - 192)) | (1 << (SqlBaseParser.YEAR - 192)) | (1 << (SqlBaseParser.ZONE - 192)) | (1 << (SqlBaseParser.PLUS - 192)) | (1 << (SqlBaseParser.MINUS - 192)))) !== 0) || ((((_la - 226)) & ~0x1F) === 0 && ((1 << (_la - 226)) & ((1 << (SqlBaseParser.STRING - 226)) | (1 << (SqlBaseParser.UNICODE_STRING - 226)) | (1 << (SqlBaseParser.BINARY_LITERAL - 226)) | (1 << (SqlBaseParser.INTEGER_VALUE - 226)) | (1 << (SqlBaseParser.DECIMAL_VALUE - 226)) | (1 << (SqlBaseParser.DOUBLE_VALUE - 226)) | (1 << (SqlBaseParser.IDENTIFIER - 226)) | (1 << (SqlBaseParser.DIGIT_IDENTIFIER - 226)) | (1 << (SqlBaseParser.QUOTED_IDENTIFIER - 226)) | (1 << (SqlBaseParser.BACKQUOTED_IDENTIFIER - 226)) | (1 << (SqlBaseParser.DOUBLE_PRECISION - 226)))) !== 0)) {
                            {
                                this.state = 1062;
                                this.expression();
                                this.state = 1067;
                                this._errHandler.sync(this);
                                _la = this._input.LA(1);
                                while (_la === SqlBaseParser.T__3) {
                                    {
                                        {
                                            this.state = 1063;
                                            this.match(SqlBaseParser.T__3);
                                            this.state = 1064;
                                            this.expression();
                                        }
                                    }
                                    this.state = 1069;
                                    this._errHandler.sync(this);
                                    _la = this._input.LA(1);
                                }
                            }
                        }
                        this.state = 1072;
                        this.match(SqlBaseParser.T__2);
                    }
                    break;
                case 4:
                    _localctx = new MultipleGroupingSetsContext(_localctx);
                    this.enterOuterAlt(_localctx, 4);
                    {
                        this.state = 1073;
                        this.match(SqlBaseParser.GROUPING);
                        this.state = 1074;
                        this.match(SqlBaseParser.SETS);
                        this.state = 1075;
                        this.match(SqlBaseParser.T__1);
                        this.state = 1076;
                        this.groupingSet();
                        this.state = 1081;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        while (_la === SqlBaseParser.T__3) {
                            {
                                {
                                    this.state = 1077;
                                    this.match(SqlBaseParser.T__3);
                                    this.state = 1078;
                                    this.groupingSet();
                                }
                            }
                            this.state = 1083;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                        }
                        this.state = 1084;
                        this.match(SqlBaseParser.T__2);
                    }
                    break;
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    groupingSet() {
        let _localctx = new GroupingSetContext(this._ctx, this.state);
        this.enterRule(_localctx, 60, SqlBaseParser.RULE_groupingSet);
        let _la;
        try {
            this.state = 1101;
            this._errHandler.sync(this);
            switch (this.interpreter.adaptivePredict(this._input, 138, this._ctx)) {
                case 1:
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1088;
                        this.match(SqlBaseParser.T__1);
                        this.state = 1097;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if ((((_la) & ~0x1F) === 0 && ((1 << _la) & ((1 << SqlBaseParser.T__1) | (1 << SqlBaseParser.T__4) | (1 << SqlBaseParser.ADD) | (1 << SqlBaseParser.ADMIN) | (1 << SqlBaseParser.ALL) | (1 << SqlBaseParser.ANALYZE) | (1 << SqlBaseParser.ANY) | (1 << SqlBaseParser.ARRAY) | (1 << SqlBaseParser.ASC) | (1 << SqlBaseParser.AT) | (1 << SqlBaseParser.BERNOULLI) | (1 << SqlBaseParser.CALL) | (1 << SqlBaseParser.CALLED) | (1 << SqlBaseParser.CASCADE) | (1 << SqlBaseParser.CASE) | (1 << SqlBaseParser.CAST) | (1 << SqlBaseParser.CATALOGS) | (1 << SqlBaseParser.COLUMN) | (1 << SqlBaseParser.COLUMNS))) !== 0) || ((((_la - 32)) & ~0x1F) === 0 && ((1 << (_la - 32)) & ((1 << (SqlBaseParser.COMMENT - 32)) | (1 << (SqlBaseParser.COMMIT - 32)) | (1 << (SqlBaseParser.COMMITTED - 32)) | (1 << (SqlBaseParser.CURRENT - 32)) | (1 << (SqlBaseParser.CURRENT_DATE - 32)) | (1 << (SqlBaseParser.CURRENT_ROLE - 32)) | (1 << (SqlBaseParser.CURRENT_TIME - 32)) | (1 << (SqlBaseParser.CURRENT_TIMESTAMP - 32)) | (1 << (SqlBaseParser.CURRENT_USER - 32)) | (1 << (SqlBaseParser.DATA - 32)) | (1 << (SqlBaseParser.DATE - 32)) | (1 << (SqlBaseParser.DAY - 32)) | (1 << (SqlBaseParser.DEFINER - 32)) | (1 << (SqlBaseParser.DESC - 32)) | (1 << (SqlBaseParser.DETERMINISTIC - 32)) | (1 << (SqlBaseParser.DISTRIBUTED - 32)) | (1 << (SqlBaseParser.EXCLUDING - 32)) | (1 << (SqlBaseParser.EXISTS - 32)))) !== 0) || ((((_la - 64)) & ~0x1F) === 0 && ((1 << (_la - 64)) & ((1 << (SqlBaseParser.EXPLAIN - 64)) | (1 << (SqlBaseParser.EXTRACT - 64)) | (1 << (SqlBaseParser.EXTERNAL - 64)) | (1 << (SqlBaseParser.FALSE - 64)) | (1 << (SqlBaseParser.FILTER - 64)) | (1 << (SqlBaseParser.FIRST - 64)) | (1 << (SqlBaseParser.FOLLOWING - 64)) | (1 << (SqlBaseParser.FORMAT - 64)) | (1 << (SqlBaseParser.FUNCTION - 64)) | (1 << (SqlBaseParser.FUNCTIONS - 64)) | (1 << (SqlBaseParser.GRANT - 64)) | (1 << (SqlBaseParser.GRANTED - 64)) | (1 << (SqlBaseParser.GRANTS - 64)) | (1 << (SqlBaseParser.GRAPHVIZ - 64)) | (1 << (SqlBaseParser.GROUPING - 64)) | (1 << (SqlBaseParser.HOUR - 64)) | (1 << (SqlBaseParser.IF - 64)) | (1 << (SqlBaseParser.IGNORE - 64)) | (1 << (SqlBaseParser.INCLUDING - 64)) | (1 << (SqlBaseParser.INPUT - 64)) | (1 << (SqlBaseParser.INTERVAL - 64)) | (1 << (SqlBaseParser.INVOKER - 64)))) !== 0) || ((((_la - 96)) & ~0x1F) === 0 && ((1 << (_la - 96)) & ((1 << (SqlBaseParser.IO - 96)) | (1 << (SqlBaseParser.ISOLATION - 96)) | (1 << (SqlBaseParser.JSON - 96)) | (1 << (SqlBaseParser.LANGUAGE - 96)) | (1 << (SqlBaseParser.LAST - 96)) | (1 << (SqlBaseParser.LATERAL - 96)) | (1 << (SqlBaseParser.LEVEL - 96)) | (1 << (SqlBaseParser.LIMIT - 96)) | (1 << (SqlBaseParser.LOCALTIME - 96)) | (1 << (SqlBaseParser.LOCALTIMESTAMP - 96)) | (1 << (SqlBaseParser.LOGICAL - 96)) | (1 << (SqlBaseParser.MAP - 96)) | (1 << (SqlBaseParser.MATERIALIZED - 96)) | (1 << (SqlBaseParser.MINUTE - 96)) | (1 << (SqlBaseParser.MONTH - 96)) | (1 << (SqlBaseParser.NAME - 96)) | (1 << (SqlBaseParser.NFC - 96)) | (1 << (SqlBaseParser.NFD - 96)) | (1 << (SqlBaseParser.NFKC - 96)) | (1 << (SqlBaseParser.NFKD - 96)) | (1 << (SqlBaseParser.NO - 96)) | (1 << (SqlBaseParser.NONE - 96)) | (1 << (SqlBaseParser.NORMALIZE - 96)) | (1 << (SqlBaseParser.NOT - 96)) | (1 << (SqlBaseParser.NULL - 96)) | (1 << (SqlBaseParser.NULLIF - 96)) | (1 << (SqlBaseParser.NULLS - 96)))) !== 0) || ((((_la - 128)) & ~0x1F) === 0 && ((1 << (_la - 128)) & ((1 << (SqlBaseParser.OFFSET - 128)) | (1 << (SqlBaseParser.ONLY - 128)) | (1 << (SqlBaseParser.OPTION - 128)) | (1 << (SqlBaseParser.ORDINALITY - 128)) | (1 << (SqlBaseParser.OUTPUT - 128)) | (1 << (SqlBaseParser.OVER - 128)) | (1 << (SqlBaseParser.PARTITION - 128)) | (1 << (SqlBaseParser.PARTITIONS - 128)) | (1 << (SqlBaseParser.POSITION - 128)) | (1 << (SqlBaseParser.PRECEDING - 128)) | (1 << (SqlBaseParser.PRIVILEGES - 128)) | (1 << (SqlBaseParser.PROPERTIES - 128)) | (1 << (SqlBaseParser.RANGE - 128)) | (1 << (SqlBaseParser.READ - 128)) | (1 << (SqlBaseParser.REFRESH - 128)) | (1 << (SqlBaseParser.RENAME - 128)) | (1 << (SqlBaseParser.REPEATABLE - 128)) | (1 << (SqlBaseParser.REPLACE - 128)) | (1 << (SqlBaseParser.RESET - 128)) | (1 << (SqlBaseParser.RESPECT - 128)) | (1 << (SqlBaseParser.RESTRICT - 128)) | (1 << (SqlBaseParser.RETURN - 128)) | (1 << (SqlBaseParser.RETURNS - 128)) | (1 << (SqlBaseParser.REVOKE - 128)) | (1 << (SqlBaseParser.ROLE - 128)))) !== 0) || ((((_la - 160)) & ~0x1F) === 0 && ((1 << (_la - 160)) & ((1 << (SqlBaseParser.ROLES - 160)) | (1 << (SqlBaseParser.ROLLBACK - 160)) | (1 << (SqlBaseParser.ROW - 160)) | (1 << (SqlBaseParser.ROWS - 160)) | (1 << (SqlBaseParser.SCHEMA - 160)) | (1 << (SqlBaseParser.SCHEMAS - 160)) | (1 << (SqlBaseParser.SECOND - 160)) | (1 << (SqlBaseParser.SECURITY - 160)) | (1 << (SqlBaseParser.SERIALIZABLE - 160)) | (1 << (SqlBaseParser.SESSION - 160)) | (1 << (SqlBaseParser.SET - 160)) | (1 << (SqlBaseParser.SETS - 160)) | (1 << (SqlBaseParser.SHOW - 160)) | (1 << (SqlBaseParser.SOME - 160)) | (1 << (SqlBaseParser.SQL - 160)) | (1 << (SqlBaseParser.START - 160)) | (1 << (SqlBaseParser.STATS - 160)) | (1 << (SqlBaseParser.SUBSTRING - 160)) | (1 << (SqlBaseParser.SYSTEM - 160)) | (1 << (SqlBaseParser.TABLES - 160)) | (1 << (SqlBaseParser.TABLESAMPLE - 160)) | (1 << (SqlBaseParser.TEMPORARY - 160)) | (1 << (SqlBaseParser.TEXT - 160)) | (1 << (SqlBaseParser.TIME - 160)) | (1 << (SqlBaseParser.TIMESTAMP - 160)) | (1 << (SqlBaseParser.TO - 160)) | (1 << (SqlBaseParser.TRANSACTION - 160)) | (1 << (SqlBaseParser.TRUE - 160)))) !== 0) || ((((_la - 192)) & ~0x1F) === 0 && ((1 << (_la - 192)) & ((1 << (SqlBaseParser.TRY_CAST - 192)) | (1 << (SqlBaseParser.TYPE - 192)) | (1 << (SqlBaseParser.UNBOUNDED - 192)) | (1 << (SqlBaseParser.UNCOMMITTED - 192)) | (1 << (SqlBaseParser.USE - 192)) | (1 << (SqlBaseParser.USER - 192)) | (1 << (SqlBaseParser.VALIDATE - 192)) | (1 << (SqlBaseParser.VERBOSE - 192)) | (1 << (SqlBaseParser.VIEW - 192)) | (1 << (SqlBaseParser.WORK - 192)) | (1 << (SqlBaseParser.WRITE - 192)) | (1 << (SqlBaseParser.YEAR - 192)) | (1 << (SqlBaseParser.ZONE - 192)) | (1 << (SqlBaseParser.PLUS - 192)) | (1 << (SqlBaseParser.MINUS - 192)))) !== 0) || ((((_la - 226)) & ~0x1F) === 0 && ((1 << (_la - 226)) & ((1 << (SqlBaseParser.STRING - 226)) | (1 << (SqlBaseParser.UNICODE_STRING - 226)) | (1 << (SqlBaseParser.BINARY_LITERAL - 226)) | (1 << (SqlBaseParser.INTEGER_VALUE - 226)) | (1 << (SqlBaseParser.DECIMAL_VALUE - 226)) | (1 << (SqlBaseParser.DOUBLE_VALUE - 226)) | (1 << (SqlBaseParser.IDENTIFIER - 226)) | (1 << (SqlBaseParser.DIGIT_IDENTIFIER - 226)) | (1 << (SqlBaseParser.QUOTED_IDENTIFIER - 226)) | (1 << (SqlBaseParser.BACKQUOTED_IDENTIFIER - 226)) | (1 << (SqlBaseParser.DOUBLE_PRECISION - 226)))) !== 0)) {
                            {
                                this.state = 1089;
                                this.expression();
                                this.state = 1094;
                                this._errHandler.sync(this);
                                _la = this._input.LA(1);
                                while (_la === SqlBaseParser.T__3) {
                                    {
                                        {
                                            this.state = 1090;
                                            this.match(SqlBaseParser.T__3);
                                            this.state = 1091;
                                            this.expression();
                                        }
                                    }
                                    this.state = 1096;
                                    this._errHandler.sync(this);
                                    _la = this._input.LA(1);
                                }
                            }
                        }
                        this.state = 1099;
                        this.match(SqlBaseParser.T__2);
                    }
                    break;
                case 2:
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1100;
                        this.expression();
                    }
                    break;
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    namedQuery() {
        let _localctx = new NamedQueryContext(this._ctx, this.state);
        this.enterRule(_localctx, 62, SqlBaseParser.RULE_namedQuery);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1103;
                _localctx._name = this.identifier();
                this.state = 1105;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la === SqlBaseParser.T__1) {
                    {
                        this.state = 1104;
                        this.columnAliases();
                    }
                }
                this.state = 1107;
                this.match(SqlBaseParser.AS);
                this.state = 1108;
                this.match(SqlBaseParser.T__1);
                this.state = 1109;
                this.query();
                this.state = 1110;
                this.match(SqlBaseParser.T__2);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    setQuantifier() {
        let _localctx = new SetQuantifierContext(this._ctx, this.state);
        this.enterRule(_localctx, 64, SqlBaseParser.RULE_setQuantifier);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1112;
                _la = this._input.LA(1);
                if (!(_la === SqlBaseParser.ALL || _la === SqlBaseParser.DISTINCT)) {
                    this._errHandler.recoverInline(this);
                }
                else {
                    if (this._input.LA(1) === Token_1.Token.EOF) {
                        this.matchedEOF = true;
                    }
                    this._errHandler.reportMatch(this);
                    this.consume();
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    selectItem() {
        let _localctx = new SelectItemContext(this._ctx, this.state);
        this.enterRule(_localctx, 66, SqlBaseParser.RULE_selectItem);
        let _la;
        try {
            this.state = 1126;
            this._errHandler.sync(this);
            switch (this.interpreter.adaptivePredict(this._input, 142, this._ctx)) {
                case 1:
                    _localctx = new SelectContext(_localctx);
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1114;
                        this.expression();
                        this.state = 1119;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 141, this._ctx)) {
                            case 1:
                                {
                                    this.state = 1116;
                                    this._errHandler.sync(this);
                                    _la = this._input.LA(1);
                                    if (_la === SqlBaseParser.AS) {
                                        {
                                            this.state = 1115;
                                            this.match(SqlBaseParser.AS);
                                        }
                                    }
                                    this.state = 1118;
                                    this.identifier();
                                }
                                break;
                        }
                    }
                    break;
                case 2:
                    _localctx = new SelectAllContext(_localctx);
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1121;
                        this.qualifiedName();
                        this.state = 1122;
                        this.match(SqlBaseParser.T__0);
                        this.state = 1123;
                        this.match(SqlBaseParser.ASTERISK);
                    }
                    break;
                case 3:
                    _localctx = new SelectAllContext(_localctx);
                    this.enterOuterAlt(_localctx, 3);
                    {
                        this.state = 1125;
                        this.match(SqlBaseParser.ASTERISK);
                    }
                    break;
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    relation(_p) {
        if (_p === undefined) {
            _p = 0;
        }
        let _parentctx = this._ctx;
        let _parentState = this.state;
        let _localctx = new RelationContext(this._ctx, _parentState);
        let _prevctx = _localctx;
        let _startState = 68;
        this.enterRecursionRule(_localctx, 68, SqlBaseParser.RULE_relation, _p);
        try {
            let _alt;
            this.enterOuterAlt(_localctx, 1);
            {
                {
                    _localctx = new RelationDefaultContext(_localctx);
                    this._ctx = _localctx;
                    _prevctx = _localctx;
                    this.state = 1129;
                    this.sampledRelation();
                }
                this._ctx._stop = this._input.tryLT(-1);
                this.state = 1149;
                this._errHandler.sync(this);
                _alt = this.interpreter.adaptivePredict(this._input, 144, this._ctx);
                while (_alt !== 2 && _alt !== ATN_1.ATN.INVALID_ALT_NUMBER) {
                    if (_alt === 1) {
                        if (this._parseListeners != null) {
                            this.triggerExitRuleEvent();
                        }
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new JoinRelationContext(new RelationContext(_parentctx, _parentState));
                                _localctx._left = _prevctx;
                                this.pushNewRecursionContext(_localctx, _startState, SqlBaseParser.RULE_relation);
                                this.state = 1131;
                                if (!(this.precpred(this._ctx, 2))) {
                                    throw this.createFailedPredicateException("this.precpred(this._ctx, 2)");
                                }
                                this.state = 1145;
                                this._errHandler.sync(this);
                                switch (this._input.LA(1)) {
                                    case SqlBaseParser.CROSS:
                                        {
                                            this.state = 1132;
                                            this.match(SqlBaseParser.CROSS);
                                            this.state = 1133;
                                            this.match(SqlBaseParser.JOIN);
                                            this.state = 1134;
                                            _localctx._right = this.sampledRelation();
                                        }
                                        break;
                                    case SqlBaseParser.FULL:
                                    case SqlBaseParser.INNER:
                                    case SqlBaseParser.JOIN:
                                    case SqlBaseParser.LEFT:
                                    case SqlBaseParser.RIGHT:
                                        {
                                            this.state = 1135;
                                            this.joinType();
                                            this.state = 1136;
                                            this.match(SqlBaseParser.JOIN);
                                            this.state = 1137;
                                            _localctx._rightRelation = this.relation(0);
                                            this.state = 1138;
                                            this.joinCriteria();
                                        }
                                        break;
                                    case SqlBaseParser.NATURAL:
                                        {
                                            this.state = 1140;
                                            this.match(SqlBaseParser.NATURAL);
                                            this.state = 1141;
                                            this.joinType();
                                            this.state = 1142;
                                            this.match(SqlBaseParser.JOIN);
                                            this.state = 1143;
                                            _localctx._right = this.sampledRelation();
                                        }
                                        break;
                                    default:
                                        throw new NoViableAltException_1.NoViableAltException(this);
                                }
                            }
                        }
                    }
                    this.state = 1151;
                    this._errHandler.sync(this);
                    _alt = this.interpreter.adaptivePredict(this._input, 144, this._ctx);
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }
    // @RuleVersion(0)
    joinType() {
        let _localctx = new JoinTypeContext(this._ctx, this.state);
        this.enterRule(_localctx, 70, SqlBaseParser.RULE_joinType);
        let _la;
        try {
            this.state = 1167;
            this._errHandler.sync(this);
            switch (this._input.LA(1)) {
                case SqlBaseParser.INNER:
                case SqlBaseParser.JOIN:
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1153;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.INNER) {
                            {
                                this.state = 1152;
                                this.match(SqlBaseParser.INNER);
                            }
                        }
                    }
                    break;
                case SqlBaseParser.LEFT:
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1155;
                        this.match(SqlBaseParser.LEFT);
                        this.state = 1157;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.OUTER) {
                            {
                                this.state = 1156;
                                this.match(SqlBaseParser.OUTER);
                            }
                        }
                    }
                    break;
                case SqlBaseParser.RIGHT:
                    this.enterOuterAlt(_localctx, 3);
                    {
                        this.state = 1159;
                        this.match(SqlBaseParser.RIGHT);
                        this.state = 1161;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.OUTER) {
                            {
                                this.state = 1160;
                                this.match(SqlBaseParser.OUTER);
                            }
                        }
                    }
                    break;
                case SqlBaseParser.FULL:
                    this.enterOuterAlt(_localctx, 4);
                    {
                        this.state = 1163;
                        this.match(SqlBaseParser.FULL);
                        this.state = 1165;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.OUTER) {
                            {
                                this.state = 1164;
                                this.match(SqlBaseParser.OUTER);
                            }
                        }
                    }
                    break;
                default:
                    throw new NoViableAltException_1.NoViableAltException(this);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    joinCriteria() {
        let _localctx = new JoinCriteriaContext(this._ctx, this.state);
        this.enterRule(_localctx, 72, SqlBaseParser.RULE_joinCriteria);
        let _la;
        try {
            this.state = 1183;
            this._errHandler.sync(this);
            switch (this._input.LA(1)) {
                case SqlBaseParser.ON:
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1169;
                        this.match(SqlBaseParser.ON);
                        this.state = 1170;
                        this.booleanExpression(0);
                    }
                    break;
                case SqlBaseParser.USING:
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1171;
                        this.match(SqlBaseParser.USING);
                        this.state = 1172;
                        this.match(SqlBaseParser.T__1);
                        this.state = 1173;
                        this.identifier();
                        this.state = 1178;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        while (_la === SqlBaseParser.T__3) {
                            {
                                {
                                    this.state = 1174;
                                    this.match(SqlBaseParser.T__3);
                                    this.state = 1175;
                                    this.identifier();
                                }
                            }
                            this.state = 1180;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                        }
                        this.state = 1181;
                        this.match(SqlBaseParser.T__2);
                    }
                    break;
                default:
                    throw new NoViableAltException_1.NoViableAltException(this);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    sampledRelation() {
        let _localctx = new SampledRelationContext(this._ctx, this.state);
        this.enterRule(_localctx, 74, SqlBaseParser.RULE_sampledRelation);
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1185;
                this.aliasedRelation();
                this.state = 1192;
                this._errHandler.sync(this);
                switch (this.interpreter.adaptivePredict(this._input, 152, this._ctx)) {
                    case 1:
                        {
                            this.state = 1186;
                            this.match(SqlBaseParser.TABLESAMPLE);
                            this.state = 1187;
                            this.sampleType();
                            this.state = 1188;
                            this.match(SqlBaseParser.T__1);
                            this.state = 1189;
                            _localctx._percentage = this.expression();
                            this.state = 1190;
                            this.match(SqlBaseParser.T__2);
                        }
                        break;
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    sampleType() {
        let _localctx = new SampleTypeContext(this._ctx, this.state);
        this.enterRule(_localctx, 76, SqlBaseParser.RULE_sampleType);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1194;
                _la = this._input.LA(1);
                if (!(_la === SqlBaseParser.BERNOULLI || _la === SqlBaseParser.SYSTEM)) {
                    this._errHandler.recoverInline(this);
                }
                else {
                    if (this._input.LA(1) === Token_1.Token.EOF) {
                        this.matchedEOF = true;
                    }
                    this._errHandler.reportMatch(this);
                    this.consume();
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    aliasedRelation() {
        let _localctx = new AliasedRelationContext(this._ctx, this.state);
        this.enterRule(_localctx, 78, SqlBaseParser.RULE_aliasedRelation);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1196;
                this.relationPrimary();
                this.state = 1204;
                this._errHandler.sync(this);
                switch (this.interpreter.adaptivePredict(this._input, 155, this._ctx)) {
                    case 1:
                        {
                            this.state = 1198;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                            if (_la === SqlBaseParser.AS) {
                                {
                                    this.state = 1197;
                                    this.match(SqlBaseParser.AS);
                                }
                            }
                            this.state = 1200;
                            this.identifier();
                            this.state = 1202;
                            this._errHandler.sync(this);
                            switch (this.interpreter.adaptivePredict(this._input, 154, this._ctx)) {
                                case 1:
                                    {
                                        this.state = 1201;
                                        this.columnAliases();
                                    }
                                    break;
                            }
                        }
                        break;
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    columnAliases() {
        let _localctx = new ColumnAliasesContext(this._ctx, this.state);
        this.enterRule(_localctx, 80, SqlBaseParser.RULE_columnAliases);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1206;
                this.match(SqlBaseParser.T__1);
                this.state = 1207;
                this.identifier();
                this.state = 1212;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                while (_la === SqlBaseParser.T__3) {
                    {
                        {
                            this.state = 1208;
                            this.match(SqlBaseParser.T__3);
                            this.state = 1209;
                            this.identifier();
                        }
                    }
                    this.state = 1214;
                    this._errHandler.sync(this);
                    _la = this._input.LA(1);
                }
                this.state = 1215;
                this.match(SqlBaseParser.T__2);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    relationPrimary() {
        let _localctx = new RelationPrimaryContext(this._ctx, this.state);
        this.enterRule(_localctx, 82, SqlBaseParser.RULE_relationPrimary);
        let _la;
        try {
            this.state = 1246;
            this._errHandler.sync(this);
            switch (this.interpreter.adaptivePredict(this._input, 159, this._ctx)) {
                case 1:
                    _localctx = new TableNameContext(_localctx);
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1217;
                        this.tableNameWithAliases();
                    }
                    break;
                case 2:
                    _localctx = new SubqueryRelationContext(_localctx);
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1218;
                        this.match(SqlBaseParser.T__1);
                        this.state = 1219;
                        this.query();
                        this.state = 1220;
                        this.match(SqlBaseParser.T__2);
                    }
                    break;
                case 3:
                    _localctx = new UnnestContext(_localctx);
                    this.enterOuterAlt(_localctx, 3);
                    {
                        this.state = 1222;
                        this.match(SqlBaseParser.UNNEST);
                        this.state = 1223;
                        this.match(SqlBaseParser.T__1);
                        this.state = 1224;
                        this.expression();
                        this.state = 1229;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        while (_la === SqlBaseParser.T__3) {
                            {
                                {
                                    this.state = 1225;
                                    this.match(SqlBaseParser.T__3);
                                    this.state = 1226;
                                    this.expression();
                                }
                            }
                            this.state = 1231;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                        }
                        this.state = 1232;
                        this.match(SqlBaseParser.T__2);
                        this.state = 1235;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 158, this._ctx)) {
                            case 1:
                                {
                                    this.state = 1233;
                                    this.match(SqlBaseParser.WITH);
                                    this.state = 1234;
                                    this.match(SqlBaseParser.ORDINALITY);
                                }
                                break;
                        }
                    }
                    break;
                case 4:
                    _localctx = new LateralContext(_localctx);
                    this.enterOuterAlt(_localctx, 4);
                    {
                        this.state = 1237;
                        this.match(SqlBaseParser.LATERAL);
                        this.state = 1238;
                        this.match(SqlBaseParser.T__1);
                        this.state = 1239;
                        this.query();
                        this.state = 1240;
                        this.match(SqlBaseParser.T__2);
                    }
                    break;
                case 5:
                    _localctx = new ParenthesizedRelationContext(_localctx);
                    this.enterOuterAlt(_localctx, 5);
                    {
                        this.state = 1242;
                        this.match(SqlBaseParser.T__1);
                        this.state = 1243;
                        this.relation(0);
                        this.state = 1244;
                        this.match(SqlBaseParser.T__2);
                    }
                    break;
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    expression() {
        let _localctx = new ExpressionContext(this._ctx, this.state);
        this.enterRule(_localctx, 84, SqlBaseParser.RULE_expression);
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1248;
                this.booleanExpression(0);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    whereExpression() {
        let _localctx = new WhereExpressionContext(this._ctx, this.state);
        this.enterRule(_localctx, 86, SqlBaseParser.RULE_whereExpression);
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1250;
                this.booleanExpression(0);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    updateExpression() {
        let _localctx = new UpdateExpressionContext(this._ctx, this.state);
        this.enterRule(_localctx, 88, SqlBaseParser.RULE_updateExpression);
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1252;
                this.booleanExpression(0);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    havingExpression() {
        let _localctx = new HavingExpressionContext(this._ctx, this.state);
        this.enterRule(_localctx, 90, SqlBaseParser.RULE_havingExpression);
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1254;
                this.booleanExpression(0);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    booleanExpression(_p) {
        if (_p === undefined) {
            _p = 0;
        }
        let _parentctx = this._ctx;
        let _parentState = this.state;
        let _localctx = new BooleanExpressionContext(this._ctx, _parentState);
        let _prevctx = _localctx;
        let _startState = 92;
        this.enterRecursionRule(_localctx, 92, SqlBaseParser.RULE_booleanExpression, _p);
        try {
            let _alt;
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1263;
                this._errHandler.sync(this);
                switch (this._input.LA(1)) {
                    case SqlBaseParser.T__1:
                    case SqlBaseParser.T__4:
                    case SqlBaseParser.ADD:
                    case SqlBaseParser.ADMIN:
                    case SqlBaseParser.ALL:
                    case SqlBaseParser.ANALYZE:
                    case SqlBaseParser.ANY:
                    case SqlBaseParser.ARRAY:
                    case SqlBaseParser.ASC:
                    case SqlBaseParser.AT:
                    case SqlBaseParser.BERNOULLI:
                    case SqlBaseParser.CALL:
                    case SqlBaseParser.CALLED:
                    case SqlBaseParser.CASCADE:
                    case SqlBaseParser.CASE:
                    case SqlBaseParser.CAST:
                    case SqlBaseParser.CATALOGS:
                    case SqlBaseParser.COLUMN:
                    case SqlBaseParser.COLUMNS:
                    case SqlBaseParser.COMMENT:
                    case SqlBaseParser.COMMIT:
                    case SqlBaseParser.COMMITTED:
                    case SqlBaseParser.CURRENT:
                    case SqlBaseParser.CURRENT_DATE:
                    case SqlBaseParser.CURRENT_ROLE:
                    case SqlBaseParser.CURRENT_TIME:
                    case SqlBaseParser.CURRENT_TIMESTAMP:
                    case SqlBaseParser.CURRENT_USER:
                    case SqlBaseParser.DATA:
                    case SqlBaseParser.DATE:
                    case SqlBaseParser.DAY:
                    case SqlBaseParser.DEFINER:
                    case SqlBaseParser.DESC:
                    case SqlBaseParser.DETERMINISTIC:
                    case SqlBaseParser.DISTRIBUTED:
                    case SqlBaseParser.EXCLUDING:
                    case SqlBaseParser.EXISTS:
                    case SqlBaseParser.EXPLAIN:
                    case SqlBaseParser.EXTRACT:
                    case SqlBaseParser.EXTERNAL:
                    case SqlBaseParser.FALSE:
                    case SqlBaseParser.FILTER:
                    case SqlBaseParser.FIRST:
                    case SqlBaseParser.FOLLOWING:
                    case SqlBaseParser.FORMAT:
                    case SqlBaseParser.FUNCTION:
                    case SqlBaseParser.FUNCTIONS:
                    case SqlBaseParser.GRANT:
                    case SqlBaseParser.GRANTED:
                    case SqlBaseParser.GRANTS:
                    case SqlBaseParser.GRAPHVIZ:
                    case SqlBaseParser.GROUPING:
                    case SqlBaseParser.HOUR:
                    case SqlBaseParser.IF:
                    case SqlBaseParser.IGNORE:
                    case SqlBaseParser.INCLUDING:
                    case SqlBaseParser.INPUT:
                    case SqlBaseParser.INTERVAL:
                    case SqlBaseParser.INVOKER:
                    case SqlBaseParser.IO:
                    case SqlBaseParser.ISOLATION:
                    case SqlBaseParser.JSON:
                    case SqlBaseParser.LANGUAGE:
                    case SqlBaseParser.LAST:
                    case SqlBaseParser.LATERAL:
                    case SqlBaseParser.LEVEL:
                    case SqlBaseParser.LIMIT:
                    case SqlBaseParser.LOCALTIME:
                    case SqlBaseParser.LOCALTIMESTAMP:
                    case SqlBaseParser.LOGICAL:
                    case SqlBaseParser.MAP:
                    case SqlBaseParser.MATERIALIZED:
                    case SqlBaseParser.MINUTE:
                    case SqlBaseParser.MONTH:
                    case SqlBaseParser.NAME:
                    case SqlBaseParser.NFC:
                    case SqlBaseParser.NFD:
                    case SqlBaseParser.NFKC:
                    case SqlBaseParser.NFKD:
                    case SqlBaseParser.NO:
                    case SqlBaseParser.NONE:
                    case SqlBaseParser.NORMALIZE:
                    case SqlBaseParser.NULL:
                    case SqlBaseParser.NULLIF:
                    case SqlBaseParser.NULLS:
                    case SqlBaseParser.OFFSET:
                    case SqlBaseParser.ONLY:
                    case SqlBaseParser.OPTION:
                    case SqlBaseParser.ORDINALITY:
                    case SqlBaseParser.OUTPUT:
                    case SqlBaseParser.OVER:
                    case SqlBaseParser.PARTITION:
                    case SqlBaseParser.PARTITIONS:
                    case SqlBaseParser.POSITION:
                    case SqlBaseParser.PRECEDING:
                    case SqlBaseParser.PRIVILEGES:
                    case SqlBaseParser.PROPERTIES:
                    case SqlBaseParser.RANGE:
                    case SqlBaseParser.READ:
                    case SqlBaseParser.REFRESH:
                    case SqlBaseParser.RENAME:
                    case SqlBaseParser.REPEATABLE:
                    case SqlBaseParser.REPLACE:
                    case SqlBaseParser.RESET:
                    case SqlBaseParser.RESPECT:
                    case SqlBaseParser.RESTRICT:
                    case SqlBaseParser.RETURN:
                    case SqlBaseParser.RETURNS:
                    case SqlBaseParser.REVOKE:
                    case SqlBaseParser.ROLE:
                    case SqlBaseParser.ROLES:
                    case SqlBaseParser.ROLLBACK:
                    case SqlBaseParser.ROW:
                    case SqlBaseParser.ROWS:
                    case SqlBaseParser.SCHEMA:
                    case SqlBaseParser.SCHEMAS:
                    case SqlBaseParser.SECOND:
                    case SqlBaseParser.SECURITY:
                    case SqlBaseParser.SERIALIZABLE:
                    case SqlBaseParser.SESSION:
                    case SqlBaseParser.SET:
                    case SqlBaseParser.SETS:
                    case SqlBaseParser.SHOW:
                    case SqlBaseParser.SOME:
                    case SqlBaseParser.SQL:
                    case SqlBaseParser.START:
                    case SqlBaseParser.STATS:
                    case SqlBaseParser.SUBSTRING:
                    case SqlBaseParser.SYSTEM:
                    case SqlBaseParser.TABLES:
                    case SqlBaseParser.TABLESAMPLE:
                    case SqlBaseParser.TEMPORARY:
                    case SqlBaseParser.TEXT:
                    case SqlBaseParser.TIME:
                    case SqlBaseParser.TIMESTAMP:
                    case SqlBaseParser.TO:
                    case SqlBaseParser.TRANSACTION:
                    case SqlBaseParser.TRUE:
                    case SqlBaseParser.TRY_CAST:
                    case SqlBaseParser.TYPE:
                    case SqlBaseParser.UNBOUNDED:
                    case SqlBaseParser.UNCOMMITTED:
                    case SqlBaseParser.USE:
                    case SqlBaseParser.USER:
                    case SqlBaseParser.VALIDATE:
                    case SqlBaseParser.VERBOSE:
                    case SqlBaseParser.VIEW:
                    case SqlBaseParser.WORK:
                    case SqlBaseParser.WRITE:
                    case SqlBaseParser.YEAR:
                    case SqlBaseParser.ZONE:
                    case SqlBaseParser.PLUS:
                    case SqlBaseParser.MINUS:
                    case SqlBaseParser.STRING:
                    case SqlBaseParser.UNICODE_STRING:
                    case SqlBaseParser.BINARY_LITERAL:
                    case SqlBaseParser.INTEGER_VALUE:
                    case SqlBaseParser.DECIMAL_VALUE:
                    case SqlBaseParser.DOUBLE_VALUE:
                    case SqlBaseParser.IDENTIFIER:
                    case SqlBaseParser.DIGIT_IDENTIFIER:
                    case SqlBaseParser.QUOTED_IDENTIFIER:
                    case SqlBaseParser.BACKQUOTED_IDENTIFIER:
                    case SqlBaseParser.DOUBLE_PRECISION:
                        {
                            _localctx = new PredicatedContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1257;
                            _localctx._valueExpression = this.valueExpression(0);
                            this.state = 1259;
                            this._errHandler.sync(this);
                            switch (this.interpreter.adaptivePredict(this._input, 160, this._ctx)) {
                                case 1:
                                    {
                                        this.state = 1258;
                                        this.predicate(_localctx._valueExpression);
                                    }
                                    break;
                            }
                        }
                        break;
                    case SqlBaseParser.NOT:
                        {
                            _localctx = new LogicalNotContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1261;
                            this.match(SqlBaseParser.NOT);
                            this.state = 1262;
                            this.booleanExpression(3);
                        }
                        break;
                    default:
                        throw new NoViableAltException_1.NoViableAltException(this);
                }
                this._ctx._stop = this._input.tryLT(-1);
                this.state = 1273;
                this._errHandler.sync(this);
                _alt = this.interpreter.adaptivePredict(this._input, 163, this._ctx);
                while (_alt !== 2 && _alt !== ATN_1.ATN.INVALID_ALT_NUMBER) {
                    if (_alt === 1) {
                        if (this._parseListeners != null) {
                            this.triggerExitRuleEvent();
                        }
                        _prevctx = _localctx;
                        {
                            this.state = 1271;
                            this._errHandler.sync(this);
                            switch (this.interpreter.adaptivePredict(this._input, 162, this._ctx)) {
                                case 1:
                                    {
                                        _localctx = new LogicalBinaryContext(new BooleanExpressionContext(_parentctx, _parentState));
                                        _localctx._left = _prevctx;
                                        this.pushNewRecursionContext(_localctx, _startState, SqlBaseParser.RULE_booleanExpression);
                                        this.state = 1265;
                                        if (!(this.precpred(this._ctx, 2))) {
                                            throw this.createFailedPredicateException("this.precpred(this._ctx, 2)");
                                        }
                                        this.state = 1266;
                                        _localctx._operator = this.match(SqlBaseParser.AND);
                                        this.state = 1267;
                                        _localctx._right = this.booleanExpression(3);
                                    }
                                    break;
                                case 2:
                                    {
                                        _localctx = new LogicalBinaryContext(new BooleanExpressionContext(_parentctx, _parentState));
                                        _localctx._left = _prevctx;
                                        this.pushNewRecursionContext(_localctx, _startState, SqlBaseParser.RULE_booleanExpression);
                                        this.state = 1268;
                                        if (!(this.precpred(this._ctx, 1))) {
                                            throw this.createFailedPredicateException("this.precpred(this._ctx, 1)");
                                        }
                                        this.state = 1269;
                                        _localctx._operator = this.match(SqlBaseParser.OR);
                                        this.state = 1270;
                                        _localctx._right = this.booleanExpression(2);
                                    }
                                    break;
                            }
                        }
                    }
                    this.state = 1275;
                    this._errHandler.sync(this);
                    _alt = this.interpreter.adaptivePredict(this._input, 163, this._ctx);
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }
    // @RuleVersion(0)
    predicate(value) {
        let _localctx = new PredicateContext(this._ctx, this.state, value);
        this.enterRule(_localctx, 94, SqlBaseParser.RULE_predicate);
        let _la;
        try {
            this.state = 1337;
            this._errHandler.sync(this);
            switch (this.interpreter.adaptivePredict(this._input, 172, this._ctx)) {
                case 1:
                    _localctx = new ComparisonContext(_localctx);
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1276;
                        this.comparisonOperator();
                        this.state = 1277;
                        _localctx._right = this.valueExpression(0);
                    }
                    break;
                case 2:
                    _localctx = new QuantifiedComparisonContext(_localctx);
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1279;
                        this.comparisonOperator();
                        this.state = 1280;
                        this.comparisonQuantifier();
                        this.state = 1281;
                        this.match(SqlBaseParser.T__1);
                        this.state = 1282;
                        this.query();
                        this.state = 1283;
                        this.match(SqlBaseParser.T__2);
                    }
                    break;
                case 3:
                    _localctx = new BetweenContext(_localctx);
                    this.enterOuterAlt(_localctx, 3);
                    {
                        this.state = 1286;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.NOT) {
                            {
                                this.state = 1285;
                                this.match(SqlBaseParser.NOT);
                            }
                        }
                        this.state = 1288;
                        this.match(SqlBaseParser.BETWEEN);
                        this.state = 1289;
                        _localctx._lower = this.valueExpression(0);
                        this.state = 1290;
                        this.match(SqlBaseParser.AND);
                        this.state = 1291;
                        _localctx._upper = this.valueExpression(0);
                    }
                    break;
                case 4:
                    _localctx = new InListContext(_localctx);
                    this.enterOuterAlt(_localctx, 4);
                    {
                        this.state = 1294;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.NOT) {
                            {
                                this.state = 1293;
                                this.match(SqlBaseParser.NOT);
                            }
                        }
                        this.state = 1296;
                        this.match(SqlBaseParser.IN);
                        this.state = 1297;
                        this.match(SqlBaseParser.T__1);
                        this.state = 1298;
                        this.expression();
                        this.state = 1303;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        while (_la === SqlBaseParser.T__3) {
                            {
                                {
                                    this.state = 1299;
                                    this.match(SqlBaseParser.T__3);
                                    this.state = 1300;
                                    this.expression();
                                }
                            }
                            this.state = 1305;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                        }
                        this.state = 1306;
                        this.match(SqlBaseParser.T__2);
                    }
                    break;
                case 5:
                    _localctx = new InSubqueryContext(_localctx);
                    this.enterOuterAlt(_localctx, 5);
                    {
                        this.state = 1309;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.NOT) {
                            {
                                this.state = 1308;
                                this.match(SqlBaseParser.NOT);
                            }
                        }
                        this.state = 1311;
                        this.match(SqlBaseParser.IN);
                        this.state = 1312;
                        this.match(SqlBaseParser.T__1);
                        this.state = 1313;
                        this.query();
                        this.state = 1314;
                        this.match(SqlBaseParser.T__2);
                    }
                    break;
                case 6:
                    _localctx = new LikeContext(_localctx);
                    this.enterOuterAlt(_localctx, 6);
                    {
                        this.state = 1317;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.NOT) {
                            {
                                this.state = 1316;
                                this.match(SqlBaseParser.NOT);
                            }
                        }
                        this.state = 1319;
                        this.match(SqlBaseParser.LIKE);
                        this.state = 1320;
                        _localctx._pattern = this.valueExpression(0);
                        this.state = 1323;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 169, this._ctx)) {
                            case 1:
                                {
                                    this.state = 1321;
                                    this.match(SqlBaseParser.ESCAPE);
                                    this.state = 1322;
                                    _localctx._escape = this.valueExpression(0);
                                }
                                break;
                        }
                    }
                    break;
                case 7:
                    _localctx = new NullPredicateContext(_localctx);
                    this.enterOuterAlt(_localctx, 7);
                    {
                        this.state = 1325;
                        this.match(SqlBaseParser.IS);
                        this.state = 1327;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.NOT) {
                            {
                                this.state = 1326;
                                this.match(SqlBaseParser.NOT);
                            }
                        }
                        this.state = 1329;
                        this.match(SqlBaseParser.NULL);
                    }
                    break;
                case 8:
                    _localctx = new DistinctFromContext(_localctx);
                    this.enterOuterAlt(_localctx, 8);
                    {
                        this.state = 1330;
                        this.match(SqlBaseParser.IS);
                        this.state = 1332;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        if (_la === SqlBaseParser.NOT) {
                            {
                                this.state = 1331;
                                this.match(SqlBaseParser.NOT);
                            }
                        }
                        this.state = 1334;
                        this.match(SqlBaseParser.DISTINCT);
                        this.state = 1335;
                        this.match(SqlBaseParser.FROM);
                        this.state = 1336;
                        _localctx._right = this.valueExpression(0);
                    }
                    break;
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    valueExpression(_p) {
        if (_p === undefined) {
            _p = 0;
        }
        let _parentctx = this._ctx;
        let _parentState = this.state;
        let _localctx = new ValueExpressionContext(this._ctx, _parentState);
        let _prevctx = _localctx;
        let _startState = 96;
        this.enterRecursionRule(_localctx, 96, SqlBaseParser.RULE_valueExpression, _p);
        let _la;
        try {
            let _alt;
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1343;
                this._errHandler.sync(this);
                switch (this._input.LA(1)) {
                    case SqlBaseParser.T__1:
                    case SqlBaseParser.T__4:
                    case SqlBaseParser.ADD:
                    case SqlBaseParser.ADMIN:
                    case SqlBaseParser.ALL:
                    case SqlBaseParser.ANALYZE:
                    case SqlBaseParser.ANY:
                    case SqlBaseParser.ARRAY:
                    case SqlBaseParser.ASC:
                    case SqlBaseParser.AT:
                    case SqlBaseParser.BERNOULLI:
                    case SqlBaseParser.CALL:
                    case SqlBaseParser.CALLED:
                    case SqlBaseParser.CASCADE:
                    case SqlBaseParser.CASE:
                    case SqlBaseParser.CAST:
                    case SqlBaseParser.CATALOGS:
                    case SqlBaseParser.COLUMN:
                    case SqlBaseParser.COLUMNS:
                    case SqlBaseParser.COMMENT:
                    case SqlBaseParser.COMMIT:
                    case SqlBaseParser.COMMITTED:
                    case SqlBaseParser.CURRENT:
                    case SqlBaseParser.CURRENT_DATE:
                    case SqlBaseParser.CURRENT_ROLE:
                    case SqlBaseParser.CURRENT_TIME:
                    case SqlBaseParser.CURRENT_TIMESTAMP:
                    case SqlBaseParser.CURRENT_USER:
                    case SqlBaseParser.DATA:
                    case SqlBaseParser.DATE:
                    case SqlBaseParser.DAY:
                    case SqlBaseParser.DEFINER:
                    case SqlBaseParser.DESC:
                    case SqlBaseParser.DETERMINISTIC:
                    case SqlBaseParser.DISTRIBUTED:
                    case SqlBaseParser.EXCLUDING:
                    case SqlBaseParser.EXISTS:
                    case SqlBaseParser.EXPLAIN:
                    case SqlBaseParser.EXTRACT:
                    case SqlBaseParser.EXTERNAL:
                    case SqlBaseParser.FALSE:
                    case SqlBaseParser.FILTER:
                    case SqlBaseParser.FIRST:
                    case SqlBaseParser.FOLLOWING:
                    case SqlBaseParser.FORMAT:
                    case SqlBaseParser.FUNCTION:
                    case SqlBaseParser.FUNCTIONS:
                    case SqlBaseParser.GRANT:
                    case SqlBaseParser.GRANTED:
                    case SqlBaseParser.GRANTS:
                    case SqlBaseParser.GRAPHVIZ:
                    case SqlBaseParser.GROUPING:
                    case SqlBaseParser.HOUR:
                    case SqlBaseParser.IF:
                    case SqlBaseParser.IGNORE:
                    case SqlBaseParser.INCLUDING:
                    case SqlBaseParser.INPUT:
                    case SqlBaseParser.INTERVAL:
                    case SqlBaseParser.INVOKER:
                    case SqlBaseParser.IO:
                    case SqlBaseParser.ISOLATION:
                    case SqlBaseParser.JSON:
                    case SqlBaseParser.LANGUAGE:
                    case SqlBaseParser.LAST:
                    case SqlBaseParser.LATERAL:
                    case SqlBaseParser.LEVEL:
                    case SqlBaseParser.LIMIT:
                    case SqlBaseParser.LOCALTIME:
                    case SqlBaseParser.LOCALTIMESTAMP:
                    case SqlBaseParser.LOGICAL:
                    case SqlBaseParser.MAP:
                    case SqlBaseParser.MATERIALIZED:
                    case SqlBaseParser.MINUTE:
                    case SqlBaseParser.MONTH:
                    case SqlBaseParser.NAME:
                    case SqlBaseParser.NFC:
                    case SqlBaseParser.NFD:
                    case SqlBaseParser.NFKC:
                    case SqlBaseParser.NFKD:
                    case SqlBaseParser.NO:
                    case SqlBaseParser.NONE:
                    case SqlBaseParser.NORMALIZE:
                    case SqlBaseParser.NULL:
                    case SqlBaseParser.NULLIF:
                    case SqlBaseParser.NULLS:
                    case SqlBaseParser.OFFSET:
                    case SqlBaseParser.ONLY:
                    case SqlBaseParser.OPTION:
                    case SqlBaseParser.ORDINALITY:
                    case SqlBaseParser.OUTPUT:
                    case SqlBaseParser.OVER:
                    case SqlBaseParser.PARTITION:
                    case SqlBaseParser.PARTITIONS:
                    case SqlBaseParser.POSITION:
                    case SqlBaseParser.PRECEDING:
                    case SqlBaseParser.PRIVILEGES:
                    case SqlBaseParser.PROPERTIES:
                    case SqlBaseParser.RANGE:
                    case SqlBaseParser.READ:
                    case SqlBaseParser.REFRESH:
                    case SqlBaseParser.RENAME:
                    case SqlBaseParser.REPEATABLE:
                    case SqlBaseParser.REPLACE:
                    case SqlBaseParser.RESET:
                    case SqlBaseParser.RESPECT:
                    case SqlBaseParser.RESTRICT:
                    case SqlBaseParser.RETURN:
                    case SqlBaseParser.RETURNS:
                    case SqlBaseParser.REVOKE:
                    case SqlBaseParser.ROLE:
                    case SqlBaseParser.ROLES:
                    case SqlBaseParser.ROLLBACK:
                    case SqlBaseParser.ROW:
                    case SqlBaseParser.ROWS:
                    case SqlBaseParser.SCHEMA:
                    case SqlBaseParser.SCHEMAS:
                    case SqlBaseParser.SECOND:
                    case SqlBaseParser.SECURITY:
                    case SqlBaseParser.SERIALIZABLE:
                    case SqlBaseParser.SESSION:
                    case SqlBaseParser.SET:
                    case SqlBaseParser.SETS:
                    case SqlBaseParser.SHOW:
                    case SqlBaseParser.SOME:
                    case SqlBaseParser.SQL:
                    case SqlBaseParser.START:
                    case SqlBaseParser.STATS:
                    case SqlBaseParser.SUBSTRING:
                    case SqlBaseParser.SYSTEM:
                    case SqlBaseParser.TABLES:
                    case SqlBaseParser.TABLESAMPLE:
                    case SqlBaseParser.TEMPORARY:
                    case SqlBaseParser.TEXT:
                    case SqlBaseParser.TIME:
                    case SqlBaseParser.TIMESTAMP:
                    case SqlBaseParser.TO:
                    case SqlBaseParser.TRANSACTION:
                    case SqlBaseParser.TRUE:
                    case SqlBaseParser.TRY_CAST:
                    case SqlBaseParser.TYPE:
                    case SqlBaseParser.UNBOUNDED:
                    case SqlBaseParser.UNCOMMITTED:
                    case SqlBaseParser.USE:
                    case SqlBaseParser.USER:
                    case SqlBaseParser.VALIDATE:
                    case SqlBaseParser.VERBOSE:
                    case SqlBaseParser.VIEW:
                    case SqlBaseParser.WORK:
                    case SqlBaseParser.WRITE:
                    case SqlBaseParser.YEAR:
                    case SqlBaseParser.ZONE:
                    case SqlBaseParser.STRING:
                    case SqlBaseParser.UNICODE_STRING:
                    case SqlBaseParser.BINARY_LITERAL:
                    case SqlBaseParser.INTEGER_VALUE:
                    case SqlBaseParser.DECIMAL_VALUE:
                    case SqlBaseParser.DOUBLE_VALUE:
                    case SqlBaseParser.IDENTIFIER:
                    case SqlBaseParser.DIGIT_IDENTIFIER:
                    case SqlBaseParser.QUOTED_IDENTIFIER:
                    case SqlBaseParser.BACKQUOTED_IDENTIFIER:
                    case SqlBaseParser.DOUBLE_PRECISION:
                        {
                            _localctx = new ValueExpressionDefaultContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1340;
                            this.primaryExpression(0);
                        }
                        break;
                    case SqlBaseParser.PLUS:
                    case SqlBaseParser.MINUS:
                        {
                            _localctx = new ArithmeticUnaryContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1341;
                            _localctx._operator = this._input.LT(1);
                            _la = this._input.LA(1);
                            if (!(_la === SqlBaseParser.PLUS || _la === SqlBaseParser.MINUS)) {
                                _localctx._operator = this._errHandler.recoverInline(this);
                            }
                            else {
                                if (this._input.LA(1) === Token_1.Token.EOF) {
                                    this.matchedEOF = true;
                                }
                                this._errHandler.reportMatch(this);
                                this.consume();
                            }
                            this.state = 1342;
                            this.valueExpression(4);
                        }
                        break;
                    default:
                        throw new NoViableAltException_1.NoViableAltException(this);
                }
                this._ctx._stop = this._input.tryLT(-1);
                this.state = 1359;
                this._errHandler.sync(this);
                _alt = this.interpreter.adaptivePredict(this._input, 175, this._ctx);
                while (_alt !== 2 && _alt !== ATN_1.ATN.INVALID_ALT_NUMBER) {
                    if (_alt === 1) {
                        if (this._parseListeners != null) {
                            this.triggerExitRuleEvent();
                        }
                        _prevctx = _localctx;
                        {
                            this.state = 1357;
                            this._errHandler.sync(this);
                            switch (this.interpreter.adaptivePredict(this._input, 174, this._ctx)) {
                                case 1:
                                    {
                                        _localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
                                        _localctx._left = _prevctx;
                                        this.pushNewRecursionContext(_localctx, _startState, SqlBaseParser.RULE_valueExpression);
                                        this.state = 1345;
                                        if (!(this.precpred(this._ctx, 3))) {
                                            throw this.createFailedPredicateException("this.precpred(this._ctx, 3)");
                                        }
                                        this.state = 1346;
                                        _localctx._operator = this._input.LT(1);
                                        _la = this._input.LA(1);
                                        if (!(((((_la - 222)) & ~0x1F) === 0 && ((1 << (_la - 222)) & ((1 << (SqlBaseParser.ASTERISK - 222)) | (1 << (SqlBaseParser.SLASH - 222)) | (1 << (SqlBaseParser.PERCENT - 222)))) !== 0))) {
                                            _localctx._operator = this._errHandler.recoverInline(this);
                                        }
                                        else {
                                            if (this._input.LA(1) === Token_1.Token.EOF) {
                                                this.matchedEOF = true;
                                            }
                                            this._errHandler.reportMatch(this);
                                            this.consume();
                                        }
                                        this.state = 1347;
                                        _localctx._right = this.valueExpression(4);
                                    }
                                    break;
                                case 2:
                                    {
                                        _localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
                                        _localctx._left = _prevctx;
                                        this.pushNewRecursionContext(_localctx, _startState, SqlBaseParser.RULE_valueExpression);
                                        this.state = 1348;
                                        if (!(this.precpred(this._ctx, 2))) {
                                            throw this.createFailedPredicateException("this.precpred(this._ctx, 2)");
                                        }
                                        this.state = 1349;
                                        _localctx._operator = this._input.LT(1);
                                        _la = this._input.LA(1);
                                        if (!(_la === SqlBaseParser.PLUS || _la === SqlBaseParser.MINUS)) {
                                            _localctx._operator = this._errHandler.recoverInline(this);
                                        }
                                        else {
                                            if (this._input.LA(1) === Token_1.Token.EOF) {
                                                this.matchedEOF = true;
                                            }
                                            this._errHandler.reportMatch(this);
                                            this.consume();
                                        }
                                        this.state = 1350;
                                        _localctx._right = this.valueExpression(3);
                                    }
                                    break;
                                case 3:
                                    {
                                        _localctx = new ConcatenationContext(new ValueExpressionContext(_parentctx, _parentState));
                                        _localctx._left = _prevctx;
                                        this.pushNewRecursionContext(_localctx, _startState, SqlBaseParser.RULE_valueExpression);
                                        this.state = 1351;
                                        if (!(this.precpred(this._ctx, 1))) {
                                            throw this.createFailedPredicateException("this.precpred(this._ctx, 1)");
                                        }
                                        this.state = 1352;
                                        this.match(SqlBaseParser.CONCAT);
                                        this.state = 1353;
                                        _localctx._right = this.valueExpression(2);
                                    }
                                    break;
                                case 4:
                                    {
                                        _localctx = new AtTimeZoneContext(new ValueExpressionContext(_parentctx, _parentState));
                                        this.pushNewRecursionContext(_localctx, _startState, SqlBaseParser.RULE_valueExpression);
                                        this.state = 1354;
                                        if (!(this.precpred(this._ctx, 5))) {
                                            throw this.createFailedPredicateException("this.precpred(this._ctx, 5)");
                                        }
                                        this.state = 1355;
                                        this.match(SqlBaseParser.AT);
                                        this.state = 1356;
                                        this.timeZoneSpecifier();
                                    }
                                    break;
                            }
                        }
                    }
                    this.state = 1361;
                    this._errHandler.sync(this);
                    _alt = this.interpreter.adaptivePredict(this._input, 175, this._ctx);
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }
    // @RuleVersion(0)
    primaryExpression(_p) {
        if (_p === undefined) {
            _p = 0;
        }
        let _parentctx = this._ctx;
        let _parentState = this.state;
        let _localctx = new PrimaryExpressionContext(this._ctx, _parentState);
        let _prevctx = _localctx;
        let _startState = 98;
        this.enterRecursionRule(_localctx, 98, SqlBaseParser.RULE_primaryExpression, _p);
        let _la;
        try {
            let _alt;
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1601;
                this._errHandler.sync(this);
                switch (this.interpreter.adaptivePredict(this._input, 204, this._ctx)) {
                    case 1:
                        {
                            _localctx = new NullLiteralContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1363;
                            this.match(SqlBaseParser.NULL);
                        }
                        break;
                    case 2:
                        {
                            _localctx = new IntervalLiteralContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1364;
                            this.interval();
                        }
                        break;
                    case 3:
                        {
                            _localctx = new TypeConstructorContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1365;
                            this.identifier();
                            this.state = 1366;
                            this.string();
                        }
                        break;
                    case 4:
                        {
                            _localctx = new TypeConstructorContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1368;
                            this.match(SqlBaseParser.DOUBLE_PRECISION);
                            this.state = 1369;
                            this.string();
                        }
                        break;
                    case 5:
                        {
                            _localctx = new NumericLiteralContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1370;
                            this.number();
                        }
                        break;
                    case 6:
                        {
                            _localctx = new BooleanLiteralContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1371;
                            this.booleanValue();
                        }
                        break;
                    case 7:
                        {
                            _localctx = new StringLiteralContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1372;
                            this.string();
                        }
                        break;
                    case 8:
                        {
                            _localctx = new BinaryLiteralContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1373;
                            this.match(SqlBaseParser.BINARY_LITERAL);
                        }
                        break;
                    case 9:
                        {
                            _localctx = new ParameterContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1374;
                            this.match(SqlBaseParser.T__4);
                        }
                        break;
                    case 10:
                        {
                            _localctx = new PositionContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1375;
                            this.match(SqlBaseParser.POSITION);
                            this.state = 1376;
                            this.match(SqlBaseParser.T__1);
                            this.state = 1377;
                            this.valueExpression(0);
                            this.state = 1378;
                            this.match(SqlBaseParser.IN);
                            this.state = 1379;
                            this.valueExpression(0);
                            this.state = 1380;
                            this.match(SqlBaseParser.T__2);
                        }
                        break;
                    case 11:
                        {
                            _localctx = new RowConstructorContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1382;
                            this.match(SqlBaseParser.T__1);
                            this.state = 1383;
                            this.expression();
                            this.state = 1386;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                            do {
                                {
                                    {
                                        this.state = 1384;
                                        this.match(SqlBaseParser.T__3);
                                        this.state = 1385;
                                        this.expression();
                                    }
                                }
                                this.state = 1388;
                                this._errHandler.sync(this);
                                _la = this._input.LA(1);
                            } while (_la === SqlBaseParser.T__3);
                            this.state = 1390;
                            this.match(SqlBaseParser.T__2);
                        }
                        break;
                    case 12:
                        {
                            _localctx = new RowConstructorContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1392;
                            this.match(SqlBaseParser.ROW);
                            this.state = 1393;
                            this.match(SqlBaseParser.T__1);
                            this.state = 1394;
                            this.expression();
                            this.state = 1399;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                            while (_la === SqlBaseParser.T__3) {
                                {
                                    {
                                        this.state = 1395;
                                        this.match(SqlBaseParser.T__3);
                                        this.state = 1396;
                                        this.expression();
                                    }
                                }
                                this.state = 1401;
                                this._errHandler.sync(this);
                                _la = this._input.LA(1);
                            }
                            this.state = 1402;
                            this.match(SqlBaseParser.T__2);
                        }
                        break;
                    case 13:
                        {
                            _localctx = new FunctionCallContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1404;
                            this.qualifiedName();
                            this.state = 1405;
                            this.match(SqlBaseParser.T__1);
                            this.state = 1406;
                            this.match(SqlBaseParser.ASTERISK);
                            this.state = 1407;
                            this.match(SqlBaseParser.T__2);
                            this.state = 1409;
                            this._errHandler.sync(this);
                            switch (this.interpreter.adaptivePredict(this._input, 178, this._ctx)) {
                                case 1:
                                    {
                                        this.state = 1408;
                                        this.filter();
                                    }
                                    break;
                            }
                            this.state = 1412;
                            this._errHandler.sync(this);
                            switch (this.interpreter.adaptivePredict(this._input, 179, this._ctx)) {
                                case 1:
                                    {
                                        this.state = 1411;
                                        this.over();
                                    }
                                    break;
                            }
                        }
                        break;
                    case 14:
                        {
                            _localctx = new FunctionCallContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1414;
                            this.qualifiedName();
                            this.state = 1415;
                            this.match(SqlBaseParser.T__1);
                            this.state = 1427;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                            if ((((_la) & ~0x1F) === 0 && ((1 << _la) & ((1 << SqlBaseParser.T__1) | (1 << SqlBaseParser.T__4) | (1 << SqlBaseParser.ADD) | (1 << SqlBaseParser.ADMIN) | (1 << SqlBaseParser.ALL) | (1 << SqlBaseParser.ANALYZE) | (1 << SqlBaseParser.ANY) | (1 << SqlBaseParser.ARRAY) | (1 << SqlBaseParser.ASC) | (1 << SqlBaseParser.AT) | (1 << SqlBaseParser.BERNOULLI) | (1 << SqlBaseParser.CALL) | (1 << SqlBaseParser.CALLED) | (1 << SqlBaseParser.CASCADE) | (1 << SqlBaseParser.CASE) | (1 << SqlBaseParser.CAST) | (1 << SqlBaseParser.CATALOGS) | (1 << SqlBaseParser.COLUMN) | (1 << SqlBaseParser.COLUMNS))) !== 0) || ((((_la - 32)) & ~0x1F) === 0 && ((1 << (_la - 32)) & ((1 << (SqlBaseParser.COMMENT - 32)) | (1 << (SqlBaseParser.COMMIT - 32)) | (1 << (SqlBaseParser.COMMITTED - 32)) | (1 << (SqlBaseParser.CURRENT - 32)) | (1 << (SqlBaseParser.CURRENT_DATE - 32)) | (1 << (SqlBaseParser.CURRENT_ROLE - 32)) | (1 << (SqlBaseParser.CURRENT_TIME - 32)) | (1 << (SqlBaseParser.CURRENT_TIMESTAMP - 32)) | (1 << (SqlBaseParser.CURRENT_USER - 32)) | (1 << (SqlBaseParser.DATA - 32)) | (1 << (SqlBaseParser.DATE - 32)) | (1 << (SqlBaseParser.DAY - 32)) | (1 << (SqlBaseParser.DEFINER - 32)) | (1 << (SqlBaseParser.DESC - 32)) | (1 << (SqlBaseParser.DETERMINISTIC - 32)) | (1 << (SqlBaseParser.DISTINCT - 32)) | (1 << (SqlBaseParser.DISTRIBUTED - 32)) | (1 << (SqlBaseParser.EXCLUDING - 32)) | (1 << (SqlBaseParser.EXISTS - 32)))) !== 0) || ((((_la - 64)) & ~0x1F) === 0 && ((1 << (_la - 64)) & ((1 << (SqlBaseParser.EXPLAIN - 64)) | (1 << (SqlBaseParser.EXTRACT - 64)) | (1 << (SqlBaseParser.EXTERNAL - 64)) | (1 << (SqlBaseParser.FALSE - 64)) | (1 << (SqlBaseParser.FILTER - 64)) | (1 << (SqlBaseParser.FIRST - 64)) | (1 << (SqlBaseParser.FOLLOWING - 64)) | (1 << (SqlBaseParser.FORMAT - 64)) | (1 << (SqlBaseParser.FUNCTION - 64)) | (1 << (SqlBaseParser.FUNCTIONS - 64)) | (1 << (SqlBaseParser.GRANT - 64)) | (1 << (SqlBaseParser.GRANTED - 64)) | (1 << (SqlBaseParser.GRANTS - 64)) | (1 << (SqlBaseParser.GRAPHVIZ - 64)) | (1 << (SqlBaseParser.GROUPING - 64)) | (1 << (SqlBaseParser.HOUR - 64)) | (1 << (SqlBaseParser.IF - 64)) | (1 << (SqlBaseParser.IGNORE - 64)) | (1 << (SqlBaseParser.INCLUDING - 64)) | (1 << (SqlBaseParser.INPUT - 64)) | (1 << (SqlBaseParser.INTERVAL - 64)) | (1 << (SqlBaseParser.INVOKER - 64)))) !== 0) || ((((_la - 96)) & ~0x1F) === 0 && ((1 << (_la - 96)) & ((1 << (SqlBaseParser.IO - 96)) | (1 << (SqlBaseParser.ISOLATION - 96)) | (1 << (SqlBaseParser.JSON - 96)) | (1 << (SqlBaseParser.LANGUAGE - 96)) | (1 << (SqlBaseParser.LAST - 96)) | (1 << (SqlBaseParser.LATERAL - 96)) | (1 << (SqlBaseParser.LEVEL - 96)) | (1 << (SqlBaseParser.LIMIT - 96)) | (1 << (SqlBaseParser.LOCALTIME - 96)) | (1 << (SqlBaseParser.LOCALTIMESTAMP - 96)) | (1 << (SqlBaseParser.LOGICAL - 96)) | (1 << (SqlBaseParser.MAP - 96)) | (1 << (SqlBaseParser.MATERIALIZED - 96)) | (1 << (SqlBaseParser.MINUTE - 96)) | (1 << (SqlBaseParser.MONTH - 96)) | (1 << (SqlBaseParser.NAME - 96)) | (1 << (SqlBaseParser.NFC - 96)) | (1 << (SqlBaseParser.NFD - 96)) | (1 << (SqlBaseParser.NFKC - 96)) | (1 << (SqlBaseParser.NFKD - 96)) | (1 << (SqlBaseParser.NO - 96)) | (1 << (SqlBaseParser.NONE - 96)) | (1 << (SqlBaseParser.NORMALIZE - 96)) | (1 << (SqlBaseParser.NOT - 96)) | (1 << (SqlBaseParser.NULL - 96)) | (1 << (SqlBaseParser.NULLIF - 96)) | (1 << (SqlBaseParser.NULLS - 96)))) !== 0) || ((((_la - 128)) & ~0x1F) === 0 && ((1 << (_la - 128)) & ((1 << (SqlBaseParser.OFFSET - 128)) | (1 << (SqlBaseParser.ONLY - 128)) | (1 << (SqlBaseParser.OPTION - 128)) | (1 << (SqlBaseParser.ORDINALITY - 128)) | (1 << (SqlBaseParser.OUTPUT - 128)) | (1 << (SqlBaseParser.OVER - 128)) | (1 << (SqlBaseParser.PARTITION - 128)) | (1 << (SqlBaseParser.PARTITIONS - 128)) | (1 << (SqlBaseParser.POSITION - 128)) | (1 << (SqlBaseParser.PRECEDING - 128)) | (1 << (SqlBaseParser.PRIVILEGES - 128)) | (1 << (SqlBaseParser.PROPERTIES - 128)) | (1 << (SqlBaseParser.RANGE - 128)) | (1 << (SqlBaseParser.READ - 128)) | (1 << (SqlBaseParser.REFRESH - 128)) | (1 << (SqlBaseParser.RENAME - 128)) | (1 << (SqlBaseParser.REPEATABLE - 128)) | (1 << (SqlBaseParser.REPLACE - 128)) | (1 << (SqlBaseParser.RESET - 128)) | (1 << (SqlBaseParser.RESPECT - 128)) | (1 << (SqlBaseParser.RESTRICT - 128)) | (1 << (SqlBaseParser.RETURN - 128)) | (1 << (SqlBaseParser.RETURNS - 128)) | (1 << (SqlBaseParser.REVOKE - 128)) | (1 << (SqlBaseParser.ROLE - 128)))) !== 0) || ((((_la - 160)) & ~0x1F) === 0 && ((1 << (_la - 160)) & ((1 << (SqlBaseParser.ROLES - 160)) | (1 << (SqlBaseParser.ROLLBACK - 160)) | (1 << (SqlBaseParser.ROW - 160)) | (1 << (SqlBaseParser.ROWS - 160)) | (1 << (SqlBaseParser.SCHEMA - 160)) | (1 << (SqlBaseParser.SCHEMAS - 160)) | (1 << (SqlBaseParser.SECOND - 160)) | (1 << (SqlBaseParser.SECURITY - 160)) | (1 << (SqlBaseParser.SERIALIZABLE - 160)) | (1 << (SqlBaseParser.SESSION - 160)) | (1 << (SqlBaseParser.SET - 160)) | (1 << (SqlBaseParser.SETS - 160)) | (1 << (SqlBaseParser.SHOW - 160)) | (1 << (SqlBaseParser.SOME - 160)) | (1 << (SqlBaseParser.SQL - 160)) | (1 << (SqlBaseParser.START - 160)) | (1 << (SqlBaseParser.STATS - 160)) | (1 << (SqlBaseParser.SUBSTRING - 160)) | (1 << (SqlBaseParser.SYSTEM - 160)) | (1 << (SqlBaseParser.TABLES - 160)) | (1 << (SqlBaseParser.TABLESAMPLE - 160)) | (1 << (SqlBaseParser.TEMPORARY - 160)) | (1 << (SqlBaseParser.TEXT - 160)) | (1 << (SqlBaseParser.TIME - 160)) | (1 << (SqlBaseParser.TIMESTAMP - 160)) | (1 << (SqlBaseParser.TO - 160)) | (1 << (SqlBaseParser.TRANSACTION - 160)) | (1 << (SqlBaseParser.TRUE - 160)))) !== 0) || ((((_la - 192)) & ~0x1F) === 0 && ((1 << (_la - 192)) & ((1 << (SqlBaseParser.TRY_CAST - 192)) | (1 << (SqlBaseParser.TYPE - 192)) | (1 << (SqlBaseParser.UNBOUNDED - 192)) | (1 << (SqlBaseParser.UNCOMMITTED - 192)) | (1 << (SqlBaseParser.USE - 192)) | (1 << (SqlBaseParser.USER - 192)) | (1 << (SqlBaseParser.VALIDATE - 192)) | (1 << (SqlBaseParser.VERBOSE - 192)) | (1 << (SqlBaseParser.VIEW - 192)) | (1 << (SqlBaseParser.WORK - 192)) | (1 << (SqlBaseParser.WRITE - 192)) | (1 << (SqlBaseParser.YEAR - 192)) | (1 << (SqlBaseParser.ZONE - 192)) | (1 << (SqlBaseParser.PLUS - 192)) | (1 << (SqlBaseParser.MINUS - 192)))) !== 0) || ((((_la - 226)) & ~0x1F) === 0 && ((1 << (_la - 226)) & ((1 << (SqlBaseParser.STRING - 226)) | (1 << (SqlBaseParser.UNICODE_STRING - 226)) | (1 << (SqlBaseParser.BINARY_LITERAL - 226)) | (1 << (SqlBaseParser.INTEGER_VALUE - 226)) | (1 << (SqlBaseParser.DECIMAL_VALUE - 226)) | (1 << (SqlBaseParser.DOUBLE_VALUE - 226)) | (1 << (SqlBaseParser.IDENTIFIER - 226)) | (1 << (SqlBaseParser.DIGIT_IDENTIFIER - 226)) | (1 << (SqlBaseParser.QUOTED_IDENTIFIER - 226)) | (1 << (SqlBaseParser.BACKQUOTED_IDENTIFIER - 226)) | (1 << (SqlBaseParser.DOUBLE_PRECISION - 226)))) !== 0)) {
                                {
                                    this.state = 1417;
                                    this._errHandler.sync(this);
                                    switch (this.interpreter.adaptivePredict(this._input, 180, this._ctx)) {
                                        case 1:
                                            {
                                                this.state = 1416;
                                                this.setQuantifier();
                                            }
                                            break;
                                    }
                                    this.state = 1419;
                                    this.expression();
                                    this.state = 1424;
                                    this._errHandler.sync(this);
                                    _la = this._input.LA(1);
                                    while (_la === SqlBaseParser.T__3) {
                                        {
                                            {
                                                this.state = 1420;
                                                this.match(SqlBaseParser.T__3);
                                                this.state = 1421;
                                                this.expression();
                                            }
                                        }
                                        this.state = 1426;
                                        this._errHandler.sync(this);
                                        _la = this._input.LA(1);
                                    }
                                }
                            }
                            this.state = 1439;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                            if (_la === SqlBaseParser.ORDER) {
                                {
                                    this.state = 1429;
                                    this.match(SqlBaseParser.ORDER);
                                    this.state = 1430;
                                    this.match(SqlBaseParser.BY);
                                    this.state = 1431;
                                    this.sortItem();
                                    this.state = 1436;
                                    this._errHandler.sync(this);
                                    _la = this._input.LA(1);
                                    while (_la === SqlBaseParser.T__3) {
                                        {
                                            {
                                                this.state = 1432;
                                                this.match(SqlBaseParser.T__3);
                                                this.state = 1433;
                                                this.sortItem();
                                            }
                                        }
                                        this.state = 1438;
                                        this._errHandler.sync(this);
                                        _la = this._input.LA(1);
                                    }
                                }
                            }
                            this.state = 1441;
                            this.match(SqlBaseParser.T__2);
                            this.state = 1443;
                            this._errHandler.sync(this);
                            switch (this.interpreter.adaptivePredict(this._input, 185, this._ctx)) {
                                case 1:
                                    {
                                        this.state = 1442;
                                        this.filter();
                                    }
                                    break;
                            }
                            this.state = 1449;
                            this._errHandler.sync(this);
                            switch (this.interpreter.adaptivePredict(this._input, 187, this._ctx)) {
                                case 1:
                                    {
                                        this.state = 1446;
                                        this._errHandler.sync(this);
                                        _la = this._input.LA(1);
                                        if (_la === SqlBaseParser.IGNORE || _la === SqlBaseParser.RESPECT) {
                                            {
                                                this.state = 1445;
                                                this.nullTreatment();
                                            }
                                        }
                                        this.state = 1448;
                                        this.over();
                                    }
                                    break;
                            }
                        }
                        break;
                    case 15:
                        {
                            _localctx = new LambdaContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1451;
                            this.identifier();
                            this.state = 1452;
                            this.match(SqlBaseParser.T__5);
                            this.state = 1453;
                            this.expression();
                        }
                        break;
                    case 16:
                        {
                            _localctx = new LambdaContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1455;
                            this.match(SqlBaseParser.T__1);
                            this.state = 1464;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                            if (((((_la - 10)) & ~0x1F) === 0 && ((1 << (_la - 10)) & ((1 << (SqlBaseParser.ADD - 10)) | (1 << (SqlBaseParser.ADMIN - 10)) | (1 << (SqlBaseParser.ALL - 10)) | (1 << (SqlBaseParser.ANALYZE - 10)) | (1 << (SqlBaseParser.ANY - 10)) | (1 << (SqlBaseParser.ARRAY - 10)) | (1 << (SqlBaseParser.ASC - 10)) | (1 << (SqlBaseParser.AT - 10)) | (1 << (SqlBaseParser.BERNOULLI - 10)) | (1 << (SqlBaseParser.CALL - 10)) | (1 << (SqlBaseParser.CALLED - 10)) | (1 << (SqlBaseParser.CASCADE - 10)) | (1 << (SqlBaseParser.CATALOGS - 10)) | (1 << (SqlBaseParser.COLUMN - 10)) | (1 << (SqlBaseParser.COLUMNS - 10)) | (1 << (SqlBaseParser.COMMENT - 10)) | (1 << (SqlBaseParser.COMMIT - 10)) | (1 << (SqlBaseParser.COMMITTED - 10)) | (1 << (SqlBaseParser.CURRENT - 10)) | (1 << (SqlBaseParser.CURRENT_ROLE - 10)))) !== 0) || ((((_la - 45)) & ~0x1F) === 0 && ((1 << (_la - 45)) & ((1 << (SqlBaseParser.DATA - 45)) | (1 << (SqlBaseParser.DATE - 45)) | (1 << (SqlBaseParser.DAY - 45)) | (1 << (SqlBaseParser.DEFINER - 45)) | (1 << (SqlBaseParser.DESC - 45)) | (1 << (SqlBaseParser.DETERMINISTIC - 45)) | (1 << (SqlBaseParser.DISTRIBUTED - 45)) | (1 << (SqlBaseParser.EXCLUDING - 45)) | (1 << (SqlBaseParser.EXPLAIN - 45)) | (1 << (SqlBaseParser.EXTERNAL - 45)) | (1 << (SqlBaseParser.FILTER - 45)) | (1 << (SqlBaseParser.FIRST - 45)) | (1 << (SqlBaseParser.FOLLOWING - 45)) | (1 << (SqlBaseParser.FORMAT - 45)) | (1 << (SqlBaseParser.FUNCTION - 45)) | (1 << (SqlBaseParser.FUNCTIONS - 45)))) !== 0) || ((((_la - 77)) & ~0x1F) === 0 && ((1 << (_la - 77)) & ((1 << (SqlBaseParser.GRANT - 77)) | (1 << (SqlBaseParser.GRANTED - 77)) | (1 << (SqlBaseParser.GRANTS - 77)) | (1 << (SqlBaseParser.GRAPHVIZ - 77)) | (1 << (SqlBaseParser.HOUR - 77)) | (1 << (SqlBaseParser.IF - 77)) | (1 << (SqlBaseParser.IGNORE - 77)) | (1 << (SqlBaseParser.INCLUDING - 77)) | (1 << (SqlBaseParser.INPUT - 77)) | (1 << (SqlBaseParser.INTERVAL - 77)) | (1 << (SqlBaseParser.INVOKER - 77)) | (1 << (SqlBaseParser.IO - 77)) | (1 << (SqlBaseParser.ISOLATION - 77)) | (1 << (SqlBaseParser.JSON - 77)) | (1 << (SqlBaseParser.LANGUAGE - 77)) | (1 << (SqlBaseParser.LAST - 77)) | (1 << (SqlBaseParser.LATERAL - 77)) | (1 << (SqlBaseParser.LEVEL - 77)) | (1 << (SqlBaseParser.LIMIT - 77)))) !== 0) || ((((_la - 110)) & ~0x1F) === 0 && ((1 << (_la - 110)) & ((1 << (SqlBaseParser.LOGICAL - 110)) | (1 << (SqlBaseParser.MAP - 110)) | (1 << (SqlBaseParser.MATERIALIZED - 110)) | (1 << (SqlBaseParser.MINUTE - 110)) | (1 << (SqlBaseParser.MONTH - 110)) | (1 << (SqlBaseParser.NAME - 110)) | (1 << (SqlBaseParser.NFC - 110)) | (1 << (SqlBaseParser.NFD - 110)) | (1 << (SqlBaseParser.NFKC - 110)) | (1 << (SqlBaseParser.NFKD - 110)) | (1 << (SqlBaseParser.NO - 110)) | (1 << (SqlBaseParser.NONE - 110)) | (1 << (SqlBaseParser.NULLIF - 110)) | (1 << (SqlBaseParser.NULLS - 110)) | (1 << (SqlBaseParser.OFFSET - 110)) | (1 << (SqlBaseParser.ONLY - 110)) | (1 << (SqlBaseParser.OPTION - 110)) | (1 << (SqlBaseParser.ORDINALITY - 110)) | (1 << (SqlBaseParser.OUTPUT - 110)) | (1 << (SqlBaseParser.OVER - 110)) | (1 << (SqlBaseParser.PARTITION - 110)) | (1 << (SqlBaseParser.PARTITIONS - 110)) | (1 << (SqlBaseParser.POSITION - 110)) | (1 << (SqlBaseParser.PRECEDING - 110)))) !== 0) || ((((_la - 143)) & ~0x1F) === 0 && ((1 << (_la - 143)) & ((1 << (SqlBaseParser.PRIVILEGES - 143)) | (1 << (SqlBaseParser.PROPERTIES - 143)) | (1 << (SqlBaseParser.RANGE - 143)) | (1 << (SqlBaseParser.READ - 143)) | (1 << (SqlBaseParser.REFRESH - 143)) | (1 << (SqlBaseParser.RENAME - 143)) | (1 << (SqlBaseParser.REPEATABLE - 143)) | (1 << (SqlBaseParser.REPLACE - 143)) | (1 << (SqlBaseParser.RESET - 143)) | (1 << (SqlBaseParser.RESPECT - 143)) | (1 << (SqlBaseParser.RESTRICT - 143)) | (1 << (SqlBaseParser.RETURN - 143)) | (1 << (SqlBaseParser.RETURNS - 143)) | (1 << (SqlBaseParser.REVOKE - 143)) | (1 << (SqlBaseParser.ROLE - 143)) | (1 << (SqlBaseParser.ROLES - 143)) | (1 << (SqlBaseParser.ROLLBACK - 143)) | (1 << (SqlBaseParser.ROW - 143)) | (1 << (SqlBaseParser.ROWS - 143)) | (1 << (SqlBaseParser.SCHEMA - 143)) | (1 << (SqlBaseParser.SCHEMAS - 143)) | (1 << (SqlBaseParser.SECOND - 143)) | (1 << (SqlBaseParser.SECURITY - 143)) | (1 << (SqlBaseParser.SERIALIZABLE - 143)) | (1 << (SqlBaseParser.SESSION - 143)) | (1 << (SqlBaseParser.SET - 143)) | (1 << (SqlBaseParser.SETS - 143)) | (1 << (SqlBaseParser.SHOW - 143)))) !== 0) || ((((_la - 175)) & ~0x1F) === 0 && ((1 << (_la - 175)) & ((1 << (SqlBaseParser.SOME - 175)) | (1 << (SqlBaseParser.SQL - 175)) | (1 << (SqlBaseParser.START - 175)) | (1 << (SqlBaseParser.STATS - 175)) | (1 << (SqlBaseParser.SUBSTRING - 175)) | (1 << (SqlBaseParser.SYSTEM - 175)) | (1 << (SqlBaseParser.TABLES - 175)) | (1 << (SqlBaseParser.TABLESAMPLE - 175)) | (1 << (SqlBaseParser.TEMPORARY - 175)) | (1 << (SqlBaseParser.TEXT - 175)) | (1 << (SqlBaseParser.TIME - 175)) | (1 << (SqlBaseParser.TIMESTAMP - 175)) | (1 << (SqlBaseParser.TO - 175)) | (1 << (SqlBaseParser.TRANSACTION - 175)) | (1 << (SqlBaseParser.TRY_CAST - 175)) | (1 << (SqlBaseParser.TYPE - 175)) | (1 << (SqlBaseParser.UNBOUNDED - 175)) | (1 << (SqlBaseParser.UNCOMMITTED - 175)) | (1 << (SqlBaseParser.USE - 175)) | (1 << (SqlBaseParser.USER - 175)) | (1 << (SqlBaseParser.VALIDATE - 175)) | (1 << (SqlBaseParser.VERBOSE - 175)) | (1 << (SqlBaseParser.VIEW - 175)))) !== 0) || ((((_la - 210)) & ~0x1F) === 0 && ((1 << (_la - 210)) & ((1 << (SqlBaseParser.WORK - 210)) | (1 << (SqlBaseParser.WRITE - 210)) | (1 << (SqlBaseParser.YEAR - 210)) | (1 << (SqlBaseParser.ZONE - 210)) | (1 << (SqlBaseParser.IDENTIFIER - 210)) | (1 << (SqlBaseParser.DIGIT_IDENTIFIER - 210)) | (1 << (SqlBaseParser.QUOTED_IDENTIFIER - 210)) | (1 << (SqlBaseParser.BACKQUOTED_IDENTIFIER - 210)))) !== 0)) {
                                {
                                    this.state = 1456;
                                    this.identifier();
                                    this.state = 1461;
                                    this._errHandler.sync(this);
                                    _la = this._input.LA(1);
                                    while (_la === SqlBaseParser.T__3) {
                                        {
                                            {
                                                this.state = 1457;
                                                this.match(SqlBaseParser.T__3);
                                                this.state = 1458;
                                                this.identifier();
                                            }
                                        }
                                        this.state = 1463;
                                        this._errHandler.sync(this);
                                        _la = this._input.LA(1);
                                    }
                                }
                            }
                            this.state = 1466;
                            this.match(SqlBaseParser.T__2);
                            this.state = 1467;
                            this.match(SqlBaseParser.T__5);
                            this.state = 1468;
                            this.expression();
                        }
                        break;
                    case 17:
                        {
                            _localctx = new SubqueryExpressionContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1469;
                            this.match(SqlBaseParser.T__1);
                            this.state = 1470;
                            this.query();
                            this.state = 1471;
                            this.match(SqlBaseParser.T__2);
                        }
                        break;
                    case 18:
                        {
                            _localctx = new ExistsContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1473;
                            this.match(SqlBaseParser.EXISTS);
                            this.state = 1474;
                            this.match(SqlBaseParser.T__1);
                            this.state = 1475;
                            this.query();
                            this.state = 1476;
                            this.match(SqlBaseParser.T__2);
                        }
                        break;
                    case 19:
                        {
                            _localctx = new SimpleCaseContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1478;
                            this.match(SqlBaseParser.CASE);
                            this.state = 1479;
                            this.valueExpression(0);
                            this.state = 1481;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                            do {
                                {
                                    {
                                        this.state = 1480;
                                        this.whenClause();
                                    }
                                }
                                this.state = 1483;
                                this._errHandler.sync(this);
                                _la = this._input.LA(1);
                            } while (_la === SqlBaseParser.WHEN);
                            this.state = 1487;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                            if (_la === SqlBaseParser.ELSE) {
                                {
                                    this.state = 1485;
                                    this.match(SqlBaseParser.ELSE);
                                    this.state = 1486;
                                    _localctx._elseExpression = this.expression();
                                }
                            }
                            this.state = 1489;
                            this.match(SqlBaseParser.END);
                        }
                        break;
                    case 20:
                        {
                            _localctx = new SearchedCaseContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1491;
                            this.match(SqlBaseParser.CASE);
                            this.state = 1493;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                            do {
                                {
                                    {
                                        this.state = 1492;
                                        this.whenClause();
                                    }
                                }
                                this.state = 1495;
                                this._errHandler.sync(this);
                                _la = this._input.LA(1);
                            } while (_la === SqlBaseParser.WHEN);
                            this.state = 1499;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                            if (_la === SqlBaseParser.ELSE) {
                                {
                                    this.state = 1497;
                                    this.match(SqlBaseParser.ELSE);
                                    this.state = 1498;
                                    _localctx._elseExpression = this.expression();
                                }
                            }
                            this.state = 1501;
                            this.match(SqlBaseParser.END);
                        }
                        break;
                    case 21:
                        {
                            _localctx = new CastContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1503;
                            this.match(SqlBaseParser.CAST);
                            this.state = 1504;
                            this.match(SqlBaseParser.T__1);
                            this.state = 1505;
                            this.expression();
                            this.state = 1506;
                            this.match(SqlBaseParser.AS);
                            this.state = 1507;
                            this.type(0);
                            this.state = 1508;
                            this.match(SqlBaseParser.T__2);
                        }
                        break;
                    case 22:
                        {
                            _localctx = new CastContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1510;
                            this.match(SqlBaseParser.TRY_CAST);
                            this.state = 1511;
                            this.match(SqlBaseParser.T__1);
                            this.state = 1512;
                            this.expression();
                            this.state = 1513;
                            this.match(SqlBaseParser.AS);
                            this.state = 1514;
                            this.type(0);
                            this.state = 1515;
                            this.match(SqlBaseParser.T__2);
                        }
                        break;
                    case 23:
                        {
                            _localctx = new ArrayConstructorContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1517;
                            this.match(SqlBaseParser.ARRAY);
                            this.state = 1518;
                            this.match(SqlBaseParser.T__6);
                            this.state = 1527;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                            if ((((_la) & ~0x1F) === 0 && ((1 << _la) & ((1 << SqlBaseParser.T__1) | (1 << SqlBaseParser.T__4) | (1 << SqlBaseParser.ADD) | (1 << SqlBaseParser.ADMIN) | (1 << SqlBaseParser.ALL) | (1 << SqlBaseParser.ANALYZE) | (1 << SqlBaseParser.ANY) | (1 << SqlBaseParser.ARRAY) | (1 << SqlBaseParser.ASC) | (1 << SqlBaseParser.AT) | (1 << SqlBaseParser.BERNOULLI) | (1 << SqlBaseParser.CALL) | (1 << SqlBaseParser.CALLED) | (1 << SqlBaseParser.CASCADE) | (1 << SqlBaseParser.CASE) | (1 << SqlBaseParser.CAST) | (1 << SqlBaseParser.CATALOGS) | (1 << SqlBaseParser.COLUMN) | (1 << SqlBaseParser.COLUMNS))) !== 0) || ((((_la - 32)) & ~0x1F) === 0 && ((1 << (_la - 32)) & ((1 << (SqlBaseParser.COMMENT - 32)) | (1 << (SqlBaseParser.COMMIT - 32)) | (1 << (SqlBaseParser.COMMITTED - 32)) | (1 << (SqlBaseParser.CURRENT - 32)) | (1 << (SqlBaseParser.CURRENT_DATE - 32)) | (1 << (SqlBaseParser.CURRENT_ROLE - 32)) | (1 << (SqlBaseParser.CURRENT_TIME - 32)) | (1 << (SqlBaseParser.CURRENT_TIMESTAMP - 32)) | (1 << (SqlBaseParser.CURRENT_USER - 32)) | (1 << (SqlBaseParser.DATA - 32)) | (1 << (SqlBaseParser.DATE - 32)) | (1 << (SqlBaseParser.DAY - 32)) | (1 << (SqlBaseParser.DEFINER - 32)) | (1 << (SqlBaseParser.DESC - 32)) | (1 << (SqlBaseParser.DETERMINISTIC - 32)) | (1 << (SqlBaseParser.DISTRIBUTED - 32)) | (1 << (SqlBaseParser.EXCLUDING - 32)) | (1 << (SqlBaseParser.EXISTS - 32)))) !== 0) || ((((_la - 64)) & ~0x1F) === 0 && ((1 << (_la - 64)) & ((1 << (SqlBaseParser.EXPLAIN - 64)) | (1 << (SqlBaseParser.EXTRACT - 64)) | (1 << (SqlBaseParser.EXTERNAL - 64)) | (1 << (SqlBaseParser.FALSE - 64)) | (1 << (SqlBaseParser.FILTER - 64)) | (1 << (SqlBaseParser.FIRST - 64)) | (1 << (SqlBaseParser.FOLLOWING - 64)) | (1 << (SqlBaseParser.FORMAT - 64)) | (1 << (SqlBaseParser.FUNCTION - 64)) | (1 << (SqlBaseParser.FUNCTIONS - 64)) | (1 << (SqlBaseParser.GRANT - 64)) | (1 << (SqlBaseParser.GRANTED - 64)) | (1 << (SqlBaseParser.GRANTS - 64)) | (1 << (SqlBaseParser.GRAPHVIZ - 64)) | (1 << (SqlBaseParser.GROUPING - 64)) | (1 << (SqlBaseParser.HOUR - 64)) | (1 << (SqlBaseParser.IF - 64)) | (1 << (SqlBaseParser.IGNORE - 64)) | (1 << (SqlBaseParser.INCLUDING - 64)) | (1 << (SqlBaseParser.INPUT - 64)) | (1 << (SqlBaseParser.INTERVAL - 64)) | (1 << (SqlBaseParser.INVOKER - 64)))) !== 0) || ((((_la - 96)) & ~0x1F) === 0 && ((1 << (_la - 96)) & ((1 << (SqlBaseParser.IO - 96)) | (1 << (SqlBaseParser.ISOLATION - 96)) | (1 << (SqlBaseParser.JSON - 96)) | (1 << (SqlBaseParser.LANGUAGE - 96)) | (1 << (SqlBaseParser.LAST - 96)) | (1 << (SqlBaseParser.LATERAL - 96)) | (1 << (SqlBaseParser.LEVEL - 96)) | (1 << (SqlBaseParser.LIMIT - 96)) | (1 << (SqlBaseParser.LOCALTIME - 96)) | (1 << (SqlBaseParser.LOCALTIMESTAMP - 96)) | (1 << (SqlBaseParser.LOGICAL - 96)) | (1 << (SqlBaseParser.MAP - 96)) | (1 << (SqlBaseParser.MATERIALIZED - 96)) | (1 << (SqlBaseParser.MINUTE - 96)) | (1 << (SqlBaseParser.MONTH - 96)) | (1 << (SqlBaseParser.NAME - 96)) | (1 << (SqlBaseParser.NFC - 96)) | (1 << (SqlBaseParser.NFD - 96)) | (1 << (SqlBaseParser.NFKC - 96)) | (1 << (SqlBaseParser.NFKD - 96)) | (1 << (SqlBaseParser.NO - 96)) | (1 << (SqlBaseParser.NONE - 96)) | (1 << (SqlBaseParser.NORMALIZE - 96)) | (1 << (SqlBaseParser.NOT - 96)) | (1 << (SqlBaseParser.NULL - 96)) | (1 << (SqlBaseParser.NULLIF - 96)) | (1 << (SqlBaseParser.NULLS - 96)))) !== 0) || ((((_la - 128)) & ~0x1F) === 0 && ((1 << (_la - 128)) & ((1 << (SqlBaseParser.OFFSET - 128)) | (1 << (SqlBaseParser.ONLY - 128)) | (1 << (SqlBaseParser.OPTION - 128)) | (1 << (SqlBaseParser.ORDINALITY - 128)) | (1 << (SqlBaseParser.OUTPUT - 128)) | (1 << (SqlBaseParser.OVER - 128)) | (1 << (SqlBaseParser.PARTITION - 128)) | (1 << (SqlBaseParser.PARTITIONS - 128)) | (1 << (SqlBaseParser.POSITION - 128)) | (1 << (SqlBaseParser.PRECEDING - 128)) | (1 << (SqlBaseParser.PRIVILEGES - 128)) | (1 << (SqlBaseParser.PROPERTIES - 128)) | (1 << (SqlBaseParser.RANGE - 128)) | (1 << (SqlBaseParser.READ - 128)) | (1 << (SqlBaseParser.REFRESH - 128)) | (1 << (SqlBaseParser.RENAME - 128)) | (1 << (SqlBaseParser.REPEATABLE - 128)) | (1 << (SqlBaseParser.REPLACE - 128)) | (1 << (SqlBaseParser.RESET - 128)) | (1 << (SqlBaseParser.RESPECT - 128)) | (1 << (SqlBaseParser.RESTRICT - 128)) | (1 << (SqlBaseParser.RETURN - 128)) | (1 << (SqlBaseParser.RETURNS - 128)) | (1 << (SqlBaseParser.REVOKE - 128)) | (1 << (SqlBaseParser.ROLE - 128)))) !== 0) || ((((_la - 160)) & ~0x1F) === 0 && ((1 << (_la - 160)) & ((1 << (SqlBaseParser.ROLES - 160)) | (1 << (SqlBaseParser.ROLLBACK - 160)) | (1 << (SqlBaseParser.ROW - 160)) | (1 << (SqlBaseParser.ROWS - 160)) | (1 << (SqlBaseParser.SCHEMA - 160)) | (1 << (SqlBaseParser.SCHEMAS - 160)) | (1 << (SqlBaseParser.SECOND - 160)) | (1 << (SqlBaseParser.SECURITY - 160)) | (1 << (SqlBaseParser.SERIALIZABLE - 160)) | (1 << (SqlBaseParser.SESSION - 160)) | (1 << (SqlBaseParser.SET - 160)) | (1 << (SqlBaseParser.SETS - 160)) | (1 << (SqlBaseParser.SHOW - 160)) | (1 << (SqlBaseParser.SOME - 160)) | (1 << (SqlBaseParser.SQL - 160)) | (1 << (SqlBaseParser.START - 160)) | (1 << (SqlBaseParser.STATS - 160)) | (1 << (SqlBaseParser.SUBSTRING - 160)) | (1 << (SqlBaseParser.SYSTEM - 160)) | (1 << (SqlBaseParser.TABLES - 160)) | (1 << (SqlBaseParser.TABLESAMPLE - 160)) | (1 << (SqlBaseParser.TEMPORARY - 160)) | (1 << (SqlBaseParser.TEXT - 160)) | (1 << (SqlBaseParser.TIME - 160)) | (1 << (SqlBaseParser.TIMESTAMP - 160)) | (1 << (SqlBaseParser.TO - 160)) | (1 << (SqlBaseParser.TRANSACTION - 160)) | (1 << (SqlBaseParser.TRUE - 160)))) !== 0) || ((((_la - 192)) & ~0x1F) === 0 && ((1 << (_la - 192)) & ((1 << (SqlBaseParser.TRY_CAST - 192)) | (1 << (SqlBaseParser.TYPE - 192)) | (1 << (SqlBaseParser.UNBOUNDED - 192)) | (1 << (SqlBaseParser.UNCOMMITTED - 192)) | (1 << (SqlBaseParser.USE - 192)) | (1 << (SqlBaseParser.USER - 192)) | (1 << (SqlBaseParser.VALIDATE - 192)) | (1 << (SqlBaseParser.VERBOSE - 192)) | (1 << (SqlBaseParser.VIEW - 192)) | (1 << (SqlBaseParser.WORK - 192)) | (1 << (SqlBaseParser.WRITE - 192)) | (1 << (SqlBaseParser.YEAR - 192)) | (1 << (SqlBaseParser.ZONE - 192)) | (1 << (SqlBaseParser.PLUS - 192)) | (1 << (SqlBaseParser.MINUS - 192)))) !== 0) || ((((_la - 226)) & ~0x1F) === 0 && ((1 << (_la - 226)) & ((1 << (SqlBaseParser.STRING - 226)) | (1 << (SqlBaseParser.UNICODE_STRING - 226)) | (1 << (SqlBaseParser.BINARY_LITERAL - 226)) | (1 << (SqlBaseParser.INTEGER_VALUE - 226)) | (1 << (SqlBaseParser.DECIMAL_VALUE - 226)) | (1 << (SqlBaseParser.DOUBLE_VALUE - 226)) | (1 << (SqlBaseParser.IDENTIFIER - 226)) | (1 << (SqlBaseParser.DIGIT_IDENTIFIER - 226)) | (1 << (SqlBaseParser.QUOTED_IDENTIFIER - 226)) | (1 << (SqlBaseParser.BACKQUOTED_IDENTIFIER - 226)) | (1 << (SqlBaseParser.DOUBLE_PRECISION - 226)))) !== 0)) {
                                {
                                    this.state = 1519;
                                    this.expression();
                                    this.state = 1524;
                                    this._errHandler.sync(this);
                                    _la = this._input.LA(1);
                                    while (_la === SqlBaseParser.T__3) {
                                        {
                                            {
                                                this.state = 1520;
                                                this.match(SqlBaseParser.T__3);
                                                this.state = 1521;
                                                this.expression();
                                            }
                                        }
                                        this.state = 1526;
                                        this._errHandler.sync(this);
                                        _la = this._input.LA(1);
                                    }
                                }
                            }
                            this.state = 1529;
                            this.match(SqlBaseParser.T__7);
                        }
                        break;
                    case 24:
                        {
                            _localctx = new ColumnReferenceContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1530;
                            this.identifier();
                        }
                        break;
                    case 25:
                        {
                            _localctx = new SpecialDateTimeFunctionContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1531;
                            _localctx._name = this.match(SqlBaseParser.CURRENT_DATE);
                        }
                        break;
                    case 26:
                        {
                            _localctx = new SpecialDateTimeFunctionContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1532;
                            _localctx._name = this.match(SqlBaseParser.CURRENT_TIME);
                            this.state = 1536;
                            this._errHandler.sync(this);
                            switch (this.interpreter.adaptivePredict(this._input, 196, this._ctx)) {
                                case 1:
                                    {
                                        this.state = 1533;
                                        this.match(SqlBaseParser.T__1);
                                        this.state = 1534;
                                        _localctx._precision = this.match(SqlBaseParser.INTEGER_VALUE);
                                        this.state = 1535;
                                        this.match(SqlBaseParser.T__2);
                                    }
                                    break;
                            }
                        }
                        break;
                    case 27:
                        {
                            _localctx = new SpecialDateTimeFunctionContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1538;
                            _localctx._name = this.match(SqlBaseParser.CURRENT_TIMESTAMP);
                            this.state = 1542;
                            this._errHandler.sync(this);
                            switch (this.interpreter.adaptivePredict(this._input, 197, this._ctx)) {
                                case 1:
                                    {
                                        this.state = 1539;
                                        this.match(SqlBaseParser.T__1);
                                        this.state = 1540;
                                        _localctx._precision = this.match(SqlBaseParser.INTEGER_VALUE);
                                        this.state = 1541;
                                        this.match(SqlBaseParser.T__2);
                                    }
                                    break;
                            }
                        }
                        break;
                    case 28:
                        {
                            _localctx = new SpecialDateTimeFunctionContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1544;
                            _localctx._name = this.match(SqlBaseParser.LOCALTIME);
                            this.state = 1548;
                            this._errHandler.sync(this);
                            switch (this.interpreter.adaptivePredict(this._input, 198, this._ctx)) {
                                case 1:
                                    {
                                        this.state = 1545;
                                        this.match(SqlBaseParser.T__1);
                                        this.state = 1546;
                                        _localctx._precision = this.match(SqlBaseParser.INTEGER_VALUE);
                                        this.state = 1547;
                                        this.match(SqlBaseParser.T__2);
                                    }
                                    break;
                            }
                        }
                        break;
                    case 29:
                        {
                            _localctx = new SpecialDateTimeFunctionContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1550;
                            _localctx._name = this.match(SqlBaseParser.LOCALTIMESTAMP);
                            this.state = 1554;
                            this._errHandler.sync(this);
                            switch (this.interpreter.adaptivePredict(this._input, 199, this._ctx)) {
                                case 1:
                                    {
                                        this.state = 1551;
                                        this.match(SqlBaseParser.T__1);
                                        this.state = 1552;
                                        _localctx._precision = this.match(SqlBaseParser.INTEGER_VALUE);
                                        this.state = 1553;
                                        this.match(SqlBaseParser.T__2);
                                    }
                                    break;
                            }
                        }
                        break;
                    case 30:
                        {
                            _localctx = new CurrentUserContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1556;
                            _localctx._name = this.match(SqlBaseParser.CURRENT_USER);
                        }
                        break;
                    case 31:
                        {
                            _localctx = new SubstringContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1557;
                            this.match(SqlBaseParser.SUBSTRING);
                            this.state = 1558;
                            this.match(SqlBaseParser.T__1);
                            this.state = 1559;
                            this.valueExpression(0);
                            this.state = 1560;
                            this.match(SqlBaseParser.FROM);
                            this.state = 1561;
                            this.valueExpression(0);
                            this.state = 1564;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                            if (_la === SqlBaseParser.FOR) {
                                {
                                    this.state = 1562;
                                    this.match(SqlBaseParser.FOR);
                                    this.state = 1563;
                                    this.valueExpression(0);
                                }
                            }
                            this.state = 1566;
                            this.match(SqlBaseParser.T__2);
                        }
                        break;
                    case 32:
                        {
                            _localctx = new NormalizeContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1568;
                            this.match(SqlBaseParser.NORMALIZE);
                            this.state = 1569;
                            this.match(SqlBaseParser.T__1);
                            this.state = 1570;
                            this.valueExpression(0);
                            this.state = 1573;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                            if (_la === SqlBaseParser.T__3) {
                                {
                                    this.state = 1571;
                                    this.match(SqlBaseParser.T__3);
                                    this.state = 1572;
                                    this.normalForm();
                                }
                            }
                            this.state = 1575;
                            this.match(SqlBaseParser.T__2);
                        }
                        break;
                    case 33:
                        {
                            _localctx = new ExtractContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1577;
                            this.match(SqlBaseParser.EXTRACT);
                            this.state = 1578;
                            this.match(SqlBaseParser.T__1);
                            this.state = 1579;
                            this.identifier();
                            this.state = 1580;
                            this.match(SqlBaseParser.FROM);
                            this.state = 1581;
                            this.valueExpression(0);
                            this.state = 1582;
                            this.match(SqlBaseParser.T__2);
                        }
                        break;
                    case 34:
                        {
                            _localctx = new ParenthesizedExpressionContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1584;
                            this.match(SqlBaseParser.T__1);
                            this.state = 1585;
                            this.expression();
                            this.state = 1586;
                            this.match(SqlBaseParser.T__2);
                        }
                        break;
                    case 35:
                        {
                            _localctx = new GroupingOperationContext(_localctx);
                            this._ctx = _localctx;
                            _prevctx = _localctx;
                            this.state = 1588;
                            this.match(SqlBaseParser.GROUPING);
                            this.state = 1589;
                            this.match(SqlBaseParser.T__1);
                            this.state = 1598;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                            if (((((_la - 10)) & ~0x1F) === 0 && ((1 << (_la - 10)) & ((1 << (SqlBaseParser.ADD - 10)) | (1 << (SqlBaseParser.ADMIN - 10)) | (1 << (SqlBaseParser.ALL - 10)) | (1 << (SqlBaseParser.ANALYZE - 10)) | (1 << (SqlBaseParser.ANY - 10)) | (1 << (SqlBaseParser.ARRAY - 10)) | (1 << (SqlBaseParser.ASC - 10)) | (1 << (SqlBaseParser.AT - 10)) | (1 << (SqlBaseParser.BERNOULLI - 10)) | (1 << (SqlBaseParser.CALL - 10)) | (1 << (SqlBaseParser.CALLED - 10)) | (1 << (SqlBaseParser.CASCADE - 10)) | (1 << (SqlBaseParser.CATALOGS - 10)) | (1 << (SqlBaseParser.COLUMN - 10)) | (1 << (SqlBaseParser.COLUMNS - 10)) | (1 << (SqlBaseParser.COMMENT - 10)) | (1 << (SqlBaseParser.COMMIT - 10)) | (1 << (SqlBaseParser.COMMITTED - 10)) | (1 << (SqlBaseParser.CURRENT - 10)) | (1 << (SqlBaseParser.CURRENT_ROLE - 10)))) !== 0) || ((((_la - 45)) & ~0x1F) === 0 && ((1 << (_la - 45)) & ((1 << (SqlBaseParser.DATA - 45)) | (1 << (SqlBaseParser.DATE - 45)) | (1 << (SqlBaseParser.DAY - 45)) | (1 << (SqlBaseParser.DEFINER - 45)) | (1 << (SqlBaseParser.DESC - 45)) | (1 << (SqlBaseParser.DETERMINISTIC - 45)) | (1 << (SqlBaseParser.DISTRIBUTED - 45)) | (1 << (SqlBaseParser.EXCLUDING - 45)) | (1 << (SqlBaseParser.EXPLAIN - 45)) | (1 << (SqlBaseParser.EXTERNAL - 45)) | (1 << (SqlBaseParser.FILTER - 45)) | (1 << (SqlBaseParser.FIRST - 45)) | (1 << (SqlBaseParser.FOLLOWING - 45)) | (1 << (SqlBaseParser.FORMAT - 45)) | (1 << (SqlBaseParser.FUNCTION - 45)) | (1 << (SqlBaseParser.FUNCTIONS - 45)))) !== 0) || ((((_la - 77)) & ~0x1F) === 0 && ((1 << (_la - 77)) & ((1 << (SqlBaseParser.GRANT - 77)) | (1 << (SqlBaseParser.GRANTED - 77)) | (1 << (SqlBaseParser.GRANTS - 77)) | (1 << (SqlBaseParser.GRAPHVIZ - 77)) | (1 << (SqlBaseParser.HOUR - 77)) | (1 << (SqlBaseParser.IF - 77)) | (1 << (SqlBaseParser.IGNORE - 77)) | (1 << (SqlBaseParser.INCLUDING - 77)) | (1 << (SqlBaseParser.INPUT - 77)) | (1 << (SqlBaseParser.INTERVAL - 77)) | (1 << (SqlBaseParser.INVOKER - 77)) | (1 << (SqlBaseParser.IO - 77)) | (1 << (SqlBaseParser.ISOLATION - 77)) | (1 << (SqlBaseParser.JSON - 77)) | (1 << (SqlBaseParser.LANGUAGE - 77)) | (1 << (SqlBaseParser.LAST - 77)) | (1 << (SqlBaseParser.LATERAL - 77)) | (1 << (SqlBaseParser.LEVEL - 77)) | (1 << (SqlBaseParser.LIMIT - 77)))) !== 0) || ((((_la - 110)) & ~0x1F) === 0 && ((1 << (_la - 110)) & ((1 << (SqlBaseParser.LOGICAL - 110)) | (1 << (SqlBaseParser.MAP - 110)) | (1 << (SqlBaseParser.MATERIALIZED - 110)) | (1 << (SqlBaseParser.MINUTE - 110)) | (1 << (SqlBaseParser.MONTH - 110)) | (1 << (SqlBaseParser.NAME - 110)) | (1 << (SqlBaseParser.NFC - 110)) | (1 << (SqlBaseParser.NFD - 110)) | (1 << (SqlBaseParser.NFKC - 110)) | (1 << (SqlBaseParser.NFKD - 110)) | (1 << (SqlBaseParser.NO - 110)) | (1 << (SqlBaseParser.NONE - 110)) | (1 << (SqlBaseParser.NULLIF - 110)) | (1 << (SqlBaseParser.NULLS - 110)) | (1 << (SqlBaseParser.OFFSET - 110)) | (1 << (SqlBaseParser.ONLY - 110)) | (1 << (SqlBaseParser.OPTION - 110)) | (1 << (SqlBaseParser.ORDINALITY - 110)) | (1 << (SqlBaseParser.OUTPUT - 110)) | (1 << (SqlBaseParser.OVER - 110)) | (1 << (SqlBaseParser.PARTITION - 110)) | (1 << (SqlBaseParser.PARTITIONS - 110)) | (1 << (SqlBaseParser.POSITION - 110)) | (1 << (SqlBaseParser.PRECEDING - 110)))) !== 0) || ((((_la - 143)) & ~0x1F) === 0 && ((1 << (_la - 143)) & ((1 << (SqlBaseParser.PRIVILEGES - 143)) | (1 << (SqlBaseParser.PROPERTIES - 143)) | (1 << (SqlBaseParser.RANGE - 143)) | (1 << (SqlBaseParser.READ - 143)) | (1 << (SqlBaseParser.REFRESH - 143)) | (1 << (SqlBaseParser.RENAME - 143)) | (1 << (SqlBaseParser.REPEATABLE - 143)) | (1 << (SqlBaseParser.REPLACE - 143)) | (1 << (SqlBaseParser.RESET - 143)) | (1 << (SqlBaseParser.RESPECT - 143)) | (1 << (SqlBaseParser.RESTRICT - 143)) | (1 << (SqlBaseParser.RETURN - 143)) | (1 << (SqlBaseParser.RETURNS - 143)) | (1 << (SqlBaseParser.REVOKE - 143)) | (1 << (SqlBaseParser.ROLE - 143)) | (1 << (SqlBaseParser.ROLES - 143)) | (1 << (SqlBaseParser.ROLLBACK - 143)) | (1 << (SqlBaseParser.ROW - 143)) | (1 << (SqlBaseParser.ROWS - 143)) | (1 << (SqlBaseParser.SCHEMA - 143)) | (1 << (SqlBaseParser.SCHEMAS - 143)) | (1 << (SqlBaseParser.SECOND - 143)) | (1 << (SqlBaseParser.SECURITY - 143)) | (1 << (SqlBaseParser.SERIALIZABLE - 143)) | (1 << (SqlBaseParser.SESSION - 143)) | (1 << (SqlBaseParser.SET - 143)) | (1 << (SqlBaseParser.SETS - 143)) | (1 << (SqlBaseParser.SHOW - 143)))) !== 0) || ((((_la - 175)) & ~0x1F) === 0 && ((1 << (_la - 175)) & ((1 << (SqlBaseParser.SOME - 175)) | (1 << (SqlBaseParser.SQL - 175)) | (1 << (SqlBaseParser.START - 175)) | (1 << (SqlBaseParser.STATS - 175)) | (1 << (SqlBaseParser.SUBSTRING - 175)) | (1 << (SqlBaseParser.SYSTEM - 175)) | (1 << (SqlBaseParser.TABLES - 175)) | (1 << (SqlBaseParser.TABLESAMPLE - 175)) | (1 << (SqlBaseParser.TEMPORARY - 175)) | (1 << (SqlBaseParser.TEXT - 175)) | (1 << (SqlBaseParser.TIME - 175)) | (1 << (SqlBaseParser.TIMESTAMP - 175)) | (1 << (SqlBaseParser.TO - 175)) | (1 << (SqlBaseParser.TRANSACTION - 175)) | (1 << (SqlBaseParser.TRY_CAST - 175)) | (1 << (SqlBaseParser.TYPE - 175)) | (1 << (SqlBaseParser.UNBOUNDED - 175)) | (1 << (SqlBaseParser.UNCOMMITTED - 175)) | (1 << (SqlBaseParser.USE - 175)) | (1 << (SqlBaseParser.USER - 175)) | (1 << (SqlBaseParser.VALIDATE - 175)) | (1 << (SqlBaseParser.VERBOSE - 175)) | (1 << (SqlBaseParser.VIEW - 175)))) !== 0) || ((((_la - 210)) & ~0x1F) === 0 && ((1 << (_la - 210)) & ((1 << (SqlBaseParser.WORK - 210)) | (1 << (SqlBaseParser.WRITE - 210)) | (1 << (SqlBaseParser.YEAR - 210)) | (1 << (SqlBaseParser.ZONE - 210)) | (1 << (SqlBaseParser.IDENTIFIER - 210)) | (1 << (SqlBaseParser.DIGIT_IDENTIFIER - 210)) | (1 << (SqlBaseParser.QUOTED_IDENTIFIER - 210)) | (1 << (SqlBaseParser.BACKQUOTED_IDENTIFIER - 210)))) !== 0)) {
                                {
                                    this.state = 1590;
                                    this.qualifiedName();
                                    this.state = 1595;
                                    this._errHandler.sync(this);
                                    _la = this._input.LA(1);
                                    while (_la === SqlBaseParser.T__3) {
                                        {
                                            {
                                                this.state = 1591;
                                                this.match(SqlBaseParser.T__3);
                                                this.state = 1592;
                                                this.qualifiedName();
                                            }
                                        }
                                        this.state = 1597;
                                        this._errHandler.sync(this);
                                        _la = this._input.LA(1);
                                    }
                                }
                            }
                            this.state = 1600;
                            this.match(SqlBaseParser.T__2);
                        }
                        break;
                }
                this._ctx._stop = this._input.tryLT(-1);
                this.state = 1613;
                this._errHandler.sync(this);
                _alt = this.interpreter.adaptivePredict(this._input, 206, this._ctx);
                while (_alt !== 2 && _alt !== ATN_1.ATN.INVALID_ALT_NUMBER) {
                    if (_alt === 1) {
                        if (this._parseListeners != null) {
                            this.triggerExitRuleEvent();
                        }
                        _prevctx = _localctx;
                        {
                            this.state = 1611;
                            this._errHandler.sync(this);
                            switch (this.interpreter.adaptivePredict(this._input, 205, this._ctx)) {
                                case 1:
                                    {
                                        _localctx = new SubscriptContext(new PrimaryExpressionContext(_parentctx, _parentState));
                                        _localctx._value = _prevctx;
                                        this.pushNewRecursionContext(_localctx, _startState, SqlBaseParser.RULE_primaryExpression);
                                        this.state = 1603;
                                        if (!(this.precpred(this._ctx, 14))) {
                                            throw this.createFailedPredicateException("this.precpred(this._ctx, 14)");
                                        }
                                        this.state = 1604;
                                        this.match(SqlBaseParser.T__6);
                                        this.state = 1605;
                                        _localctx._index = this.valueExpression(0);
                                        this.state = 1606;
                                        this.match(SqlBaseParser.T__7);
                                    }
                                    break;
                                case 2:
                                    {
                                        _localctx = new DereferenceContext(new PrimaryExpressionContext(_parentctx, _parentState));
                                        _localctx._base = _prevctx;
                                        this.pushNewRecursionContext(_localctx, _startState, SqlBaseParser.RULE_primaryExpression);
                                        this.state = 1608;
                                        if (!(this.precpred(this._ctx, 12))) {
                                            throw this.createFailedPredicateException("this.precpred(this._ctx, 12)");
                                        }
                                        this.state = 1609;
                                        this.match(SqlBaseParser.T__0);
                                        this.state = 1610;
                                        _localctx._fieldName = this.identifier();
                                    }
                                    break;
                            }
                        }
                    }
                    this.state = 1615;
                    this._errHandler.sync(this);
                    _alt = this.interpreter.adaptivePredict(this._input, 206, this._ctx);
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }
    // @RuleVersion(0)
    string() {
        let _localctx = new StringContext(this._ctx, this.state);
        this.enterRule(_localctx, 100, SqlBaseParser.RULE_string);
        try {
            this.state = 1622;
            this._errHandler.sync(this);
            switch (this._input.LA(1)) {
                case SqlBaseParser.STRING:
                    _localctx = new BasicStringLiteralContext(_localctx);
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1616;
                        this.match(SqlBaseParser.STRING);
                    }
                    break;
                case SqlBaseParser.UNICODE_STRING:
                    _localctx = new UnicodeStringLiteralContext(_localctx);
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1617;
                        this.match(SqlBaseParser.UNICODE_STRING);
                        this.state = 1620;
                        this._errHandler.sync(this);
                        switch (this.interpreter.adaptivePredict(this._input, 207, this._ctx)) {
                            case 1:
                                {
                                    this.state = 1618;
                                    this.match(SqlBaseParser.UESCAPE);
                                    this.state = 1619;
                                    this.match(SqlBaseParser.STRING);
                                }
                                break;
                        }
                    }
                    break;
                default:
                    throw new NoViableAltException_1.NoViableAltException(this);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    nullTreatment() {
        let _localctx = new NullTreatmentContext(this._ctx, this.state);
        this.enterRule(_localctx, 102, SqlBaseParser.RULE_nullTreatment);
        try {
            this.state = 1628;
            this._errHandler.sync(this);
            switch (this._input.LA(1)) {
                case SqlBaseParser.IGNORE:
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1624;
                        this.match(SqlBaseParser.IGNORE);
                        this.state = 1625;
                        this.match(SqlBaseParser.NULLS);
                    }
                    break;
                case SqlBaseParser.RESPECT:
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1626;
                        this.match(SqlBaseParser.RESPECT);
                        this.state = 1627;
                        this.match(SqlBaseParser.NULLS);
                    }
                    break;
                default:
                    throw new NoViableAltException_1.NoViableAltException(this);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    timeZoneSpecifier() {
        let _localctx = new TimeZoneSpecifierContext(this._ctx, this.state);
        this.enterRule(_localctx, 104, SqlBaseParser.RULE_timeZoneSpecifier);
        try {
            this.state = 1636;
            this._errHandler.sync(this);
            switch (this.interpreter.adaptivePredict(this._input, 210, this._ctx)) {
                case 1:
                    _localctx = new TimeZoneIntervalContext(_localctx);
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1630;
                        this.match(SqlBaseParser.TIME);
                        this.state = 1631;
                        this.match(SqlBaseParser.ZONE);
                        this.state = 1632;
                        this.interval();
                    }
                    break;
                case 2:
                    _localctx = new TimeZoneStringContext(_localctx);
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1633;
                        this.match(SqlBaseParser.TIME);
                        this.state = 1634;
                        this.match(SqlBaseParser.ZONE);
                        this.state = 1635;
                        this.string();
                    }
                    break;
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    comparisonOperator() {
        let _localctx = new ComparisonOperatorContext(this._ctx, this.state);
        this.enterRule(_localctx, 106, SqlBaseParser.RULE_comparisonOperator);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1638;
                _la = this._input.LA(1);
                if (!(((((_la - 214)) & ~0x1F) === 0 && ((1 << (_la - 214)) & ((1 << (SqlBaseParser.EQ - 214)) | (1 << (SqlBaseParser.NEQ - 214)) | (1 << (SqlBaseParser.LT - 214)) | (1 << (SqlBaseParser.LTE - 214)) | (1 << (SqlBaseParser.GT - 214)) | (1 << (SqlBaseParser.GTE - 214)))) !== 0))) {
                    this._errHandler.recoverInline(this);
                }
                else {
                    if (this._input.LA(1) === Token_1.Token.EOF) {
                        this.matchedEOF = true;
                    }
                    this._errHandler.reportMatch(this);
                    this.consume();
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    comparisonQuantifier() {
        let _localctx = new ComparisonQuantifierContext(this._ctx, this.state);
        this.enterRule(_localctx, 108, SqlBaseParser.RULE_comparisonQuantifier);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1640;
                _la = this._input.LA(1);
                if (!(_la === SqlBaseParser.ALL || _la === SqlBaseParser.ANY || _la === SqlBaseParser.SOME)) {
                    this._errHandler.recoverInline(this);
                }
                else {
                    if (this._input.LA(1) === Token_1.Token.EOF) {
                        this.matchedEOF = true;
                    }
                    this._errHandler.reportMatch(this);
                    this.consume();
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    booleanValue() {
        let _localctx = new BooleanValueContext(this._ctx, this.state);
        this.enterRule(_localctx, 110, SqlBaseParser.RULE_booleanValue);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1642;
                _la = this._input.LA(1);
                if (!(_la === SqlBaseParser.FALSE || _la === SqlBaseParser.TRUE)) {
                    this._errHandler.recoverInline(this);
                }
                else {
                    if (this._input.LA(1) === Token_1.Token.EOF) {
                        this.matchedEOF = true;
                    }
                    this._errHandler.reportMatch(this);
                    this.consume();
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    interval() {
        let _localctx = new IntervalContext(this._ctx, this.state);
        this.enterRule(_localctx, 112, SqlBaseParser.RULE_interval);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1644;
                this.match(SqlBaseParser.INTERVAL);
                this.state = 1646;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la === SqlBaseParser.PLUS || _la === SqlBaseParser.MINUS) {
                    {
                        this.state = 1645;
                        _localctx._sign = this._input.LT(1);
                        _la = this._input.LA(1);
                        if (!(_la === SqlBaseParser.PLUS || _la === SqlBaseParser.MINUS)) {
                            _localctx._sign = this._errHandler.recoverInline(this);
                        }
                        else {
                            if (this._input.LA(1) === Token_1.Token.EOF) {
                                this.matchedEOF = true;
                            }
                            this._errHandler.reportMatch(this);
                            this.consume();
                        }
                    }
                }
                this.state = 1648;
                this.string();
                this.state = 1649;
                _localctx._from = this.intervalField();
                this.state = 1652;
                this._errHandler.sync(this);
                switch (this.interpreter.adaptivePredict(this._input, 212, this._ctx)) {
                    case 1:
                        {
                            this.state = 1650;
                            this.match(SqlBaseParser.TO);
                            this.state = 1651;
                            _localctx._to = this.intervalField();
                        }
                        break;
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    intervalField() {
        let _localctx = new IntervalFieldContext(this._ctx, this.state);
        this.enterRule(_localctx, 114, SqlBaseParser.RULE_intervalField);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1654;
                _la = this._input.LA(1);
                if (!(_la === SqlBaseParser.DAY || ((((_la - 84)) & ~0x1F) === 0 && ((1 << (_la - 84)) & ((1 << (SqlBaseParser.HOUR - 84)) | (1 << (SqlBaseParser.MINUTE - 84)) | (1 << (SqlBaseParser.MONTH - 84)))) !== 0) || _la === SqlBaseParser.SECOND || _la === SqlBaseParser.YEAR)) {
                    this._errHandler.recoverInline(this);
                }
                else {
                    if (this._input.LA(1) === Token_1.Token.EOF) {
                        this.matchedEOF = true;
                    }
                    this._errHandler.reportMatch(this);
                    this.consume();
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    normalForm() {
        let _localctx = new NormalFormContext(this._ctx, this.state);
        this.enterRule(_localctx, 116, SqlBaseParser.RULE_normalForm);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1656;
                _la = this._input.LA(1);
                if (!(((((_la - 117)) & ~0x1F) === 0 && ((1 << (_la - 117)) & ((1 << (SqlBaseParser.NFC - 117)) | (1 << (SqlBaseParser.NFD - 117)) | (1 << (SqlBaseParser.NFKC - 117)) | (1 << (SqlBaseParser.NFKD - 117)))) !== 0))) {
                    this._errHandler.recoverInline(this);
                }
                else {
                    if (this._input.LA(1) === Token_1.Token.EOF) {
                        this.matchedEOF = true;
                    }
                    this._errHandler.reportMatch(this);
                    this.consume();
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    types() {
        let _localctx = new TypesContext(this._ctx, this.state);
        this.enterRule(_localctx, 118, SqlBaseParser.RULE_types);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1658;
                this.match(SqlBaseParser.T__1);
                this.state = 1667;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (((((_la - 10)) & ~0x1F) === 0 && ((1 << (_la - 10)) & ((1 << (SqlBaseParser.ADD - 10)) | (1 << (SqlBaseParser.ADMIN - 10)) | (1 << (SqlBaseParser.ALL - 10)) | (1 << (SqlBaseParser.ANALYZE - 10)) | (1 << (SqlBaseParser.ANY - 10)) | (1 << (SqlBaseParser.ARRAY - 10)) | (1 << (SqlBaseParser.ASC - 10)) | (1 << (SqlBaseParser.AT - 10)) | (1 << (SqlBaseParser.BERNOULLI - 10)) | (1 << (SqlBaseParser.CALL - 10)) | (1 << (SqlBaseParser.CALLED - 10)) | (1 << (SqlBaseParser.CASCADE - 10)) | (1 << (SqlBaseParser.CATALOGS - 10)) | (1 << (SqlBaseParser.COLUMN - 10)) | (1 << (SqlBaseParser.COLUMNS - 10)) | (1 << (SqlBaseParser.COMMENT - 10)) | (1 << (SqlBaseParser.COMMIT - 10)) | (1 << (SqlBaseParser.COMMITTED - 10)) | (1 << (SqlBaseParser.CURRENT - 10)) | (1 << (SqlBaseParser.CURRENT_ROLE - 10)))) !== 0) || ((((_la - 45)) & ~0x1F) === 0 && ((1 << (_la - 45)) & ((1 << (SqlBaseParser.DATA - 45)) | (1 << (SqlBaseParser.DATE - 45)) | (1 << (SqlBaseParser.DAY - 45)) | (1 << (SqlBaseParser.DEFINER - 45)) | (1 << (SqlBaseParser.DESC - 45)) | (1 << (SqlBaseParser.DETERMINISTIC - 45)) | (1 << (SqlBaseParser.DISTRIBUTED - 45)) | (1 << (SqlBaseParser.EXCLUDING - 45)) | (1 << (SqlBaseParser.EXPLAIN - 45)) | (1 << (SqlBaseParser.EXTERNAL - 45)) | (1 << (SqlBaseParser.FILTER - 45)) | (1 << (SqlBaseParser.FIRST - 45)) | (1 << (SqlBaseParser.FOLLOWING - 45)) | (1 << (SqlBaseParser.FORMAT - 45)) | (1 << (SqlBaseParser.FUNCTION - 45)) | (1 << (SqlBaseParser.FUNCTIONS - 45)))) !== 0) || ((((_la - 77)) & ~0x1F) === 0 && ((1 << (_la - 77)) & ((1 << (SqlBaseParser.GRANT - 77)) | (1 << (SqlBaseParser.GRANTED - 77)) | (1 << (SqlBaseParser.GRANTS - 77)) | (1 << (SqlBaseParser.GRAPHVIZ - 77)) | (1 << (SqlBaseParser.HOUR - 77)) | (1 << (SqlBaseParser.IF - 77)) | (1 << (SqlBaseParser.IGNORE - 77)) | (1 << (SqlBaseParser.INCLUDING - 77)) | (1 << (SqlBaseParser.INPUT - 77)) | (1 << (SqlBaseParser.INTERVAL - 77)) | (1 << (SqlBaseParser.INVOKER - 77)) | (1 << (SqlBaseParser.IO - 77)) | (1 << (SqlBaseParser.ISOLATION - 77)) | (1 << (SqlBaseParser.JSON - 77)) | (1 << (SqlBaseParser.LANGUAGE - 77)) | (1 << (SqlBaseParser.LAST - 77)) | (1 << (SqlBaseParser.LATERAL - 77)) | (1 << (SqlBaseParser.LEVEL - 77)) | (1 << (SqlBaseParser.LIMIT - 77)))) !== 0) || ((((_la - 110)) & ~0x1F) === 0 && ((1 << (_la - 110)) & ((1 << (SqlBaseParser.LOGICAL - 110)) | (1 << (SqlBaseParser.MAP - 110)) | (1 << (SqlBaseParser.MATERIALIZED - 110)) | (1 << (SqlBaseParser.MINUTE - 110)) | (1 << (SqlBaseParser.MONTH - 110)) | (1 << (SqlBaseParser.NAME - 110)) | (1 << (SqlBaseParser.NFC - 110)) | (1 << (SqlBaseParser.NFD - 110)) | (1 << (SqlBaseParser.NFKC - 110)) | (1 << (SqlBaseParser.NFKD - 110)) | (1 << (SqlBaseParser.NO - 110)) | (1 << (SqlBaseParser.NONE - 110)) | (1 << (SqlBaseParser.NULLIF - 110)) | (1 << (SqlBaseParser.NULLS - 110)) | (1 << (SqlBaseParser.OFFSET - 110)) | (1 << (SqlBaseParser.ONLY - 110)) | (1 << (SqlBaseParser.OPTION - 110)) | (1 << (SqlBaseParser.ORDINALITY - 110)) | (1 << (SqlBaseParser.OUTPUT - 110)) | (1 << (SqlBaseParser.OVER - 110)) | (1 << (SqlBaseParser.PARTITION - 110)) | (1 << (SqlBaseParser.PARTITIONS - 110)) | (1 << (SqlBaseParser.POSITION - 110)) | (1 << (SqlBaseParser.PRECEDING - 110)))) !== 0) || ((((_la - 143)) & ~0x1F) === 0 && ((1 << (_la - 143)) & ((1 << (SqlBaseParser.PRIVILEGES - 143)) | (1 << (SqlBaseParser.PROPERTIES - 143)) | (1 << (SqlBaseParser.RANGE - 143)) | (1 << (SqlBaseParser.READ - 143)) | (1 << (SqlBaseParser.REFRESH - 143)) | (1 << (SqlBaseParser.RENAME - 143)) | (1 << (SqlBaseParser.REPEATABLE - 143)) | (1 << (SqlBaseParser.REPLACE - 143)) | (1 << (SqlBaseParser.RESET - 143)) | (1 << (SqlBaseParser.RESPECT - 143)) | (1 << (SqlBaseParser.RESTRICT - 143)) | (1 << (SqlBaseParser.RETURN - 143)) | (1 << (SqlBaseParser.RETURNS - 143)) | (1 << (SqlBaseParser.REVOKE - 143)) | (1 << (SqlBaseParser.ROLE - 143)) | (1 << (SqlBaseParser.ROLES - 143)) | (1 << (SqlBaseParser.ROLLBACK - 143)) | (1 << (SqlBaseParser.ROW - 143)) | (1 << (SqlBaseParser.ROWS - 143)) | (1 << (SqlBaseParser.SCHEMA - 143)) | (1 << (SqlBaseParser.SCHEMAS - 143)) | (1 << (SqlBaseParser.SECOND - 143)) | (1 << (SqlBaseParser.SECURITY - 143)) | (1 << (SqlBaseParser.SERIALIZABLE - 143)) | (1 << (SqlBaseParser.SESSION - 143)) | (1 << (SqlBaseParser.SET - 143)) | (1 << (SqlBaseParser.SETS - 143)) | (1 << (SqlBaseParser.SHOW - 143)))) !== 0) || ((((_la - 175)) & ~0x1F) === 0 && ((1 << (_la - 175)) & ((1 << (SqlBaseParser.SOME - 175)) | (1 << (SqlBaseParser.SQL - 175)) | (1 << (SqlBaseParser.START - 175)) | (1 << (SqlBaseParser.STATS - 175)) | (1 << (SqlBaseParser.SUBSTRING - 175)) | (1 << (SqlBaseParser.SYSTEM - 175)) | (1 << (SqlBaseParser.TABLES - 175)) | (1 << (SqlBaseParser.TABLESAMPLE - 175)) | (1 << (SqlBaseParser.TEMPORARY - 175)) | (1 << (SqlBaseParser.TEXT - 175)) | (1 << (SqlBaseParser.TIME - 175)) | (1 << (SqlBaseParser.TIMESTAMP - 175)) | (1 << (SqlBaseParser.TO - 175)) | (1 << (SqlBaseParser.TRANSACTION - 175)) | (1 << (SqlBaseParser.TRY_CAST - 175)) | (1 << (SqlBaseParser.TYPE - 175)) | (1 << (SqlBaseParser.UNBOUNDED - 175)) | (1 << (SqlBaseParser.UNCOMMITTED - 175)) | (1 << (SqlBaseParser.USE - 175)) | (1 << (SqlBaseParser.USER - 175)) | (1 << (SqlBaseParser.VALIDATE - 175)) | (1 << (SqlBaseParser.VERBOSE - 175)) | (1 << (SqlBaseParser.VIEW - 175)))) !== 0) || ((((_la - 210)) & ~0x1F) === 0 && ((1 << (_la - 210)) & ((1 << (SqlBaseParser.WORK - 210)) | (1 << (SqlBaseParser.WRITE - 210)) | (1 << (SqlBaseParser.YEAR - 210)) | (1 << (SqlBaseParser.ZONE - 210)) | (1 << (SqlBaseParser.IDENTIFIER - 210)) | (1 << (SqlBaseParser.DIGIT_IDENTIFIER - 210)) | (1 << (SqlBaseParser.QUOTED_IDENTIFIER - 210)) | (1 << (SqlBaseParser.BACKQUOTED_IDENTIFIER - 210)) | (1 << (SqlBaseParser.TIME_WITH_TIME_ZONE - 210)) | (1 << (SqlBaseParser.TIMESTAMP_WITH_TIME_ZONE - 210)) | (1 << (SqlBaseParser.DOUBLE_PRECISION - 210)))) !== 0)) {
                    {
                        this.state = 1659;
                        this.type(0);
                        this.state = 1664;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        while (_la === SqlBaseParser.T__3) {
                            {
                                {
                                    this.state = 1660;
                                    this.match(SqlBaseParser.T__3);
                                    this.state = 1661;
                                    this.type(0);
                                }
                            }
                            this.state = 1666;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                        }
                    }
                }
                this.state = 1669;
                this.match(SqlBaseParser.T__2);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    type(_p) {
        if (_p === undefined) {
            _p = 0;
        }
        let _parentctx = this._ctx;
        let _parentState = this.state;
        let _localctx = new TypeContext(this._ctx, _parentState);
        let _prevctx = _localctx;
        let _startState = 120;
        this.enterRecursionRule(_localctx, 120, SqlBaseParser.RULE_type, _p);
        let _la;
        try {
            let _alt;
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1718;
                this._errHandler.sync(this);
                switch (this.interpreter.adaptivePredict(this._input, 218, this._ctx)) {
                    case 1:
                        {
                            this.state = 1672;
                            this.match(SqlBaseParser.ARRAY);
                            this.state = 1673;
                            this.match(SqlBaseParser.LT);
                            this.state = 1674;
                            this.type(0);
                            this.state = 1675;
                            this.match(SqlBaseParser.GT);
                        }
                        break;
                    case 2:
                        {
                            this.state = 1677;
                            this.match(SqlBaseParser.MAP);
                            this.state = 1678;
                            this.match(SqlBaseParser.LT);
                            this.state = 1679;
                            this.type(0);
                            this.state = 1680;
                            this.match(SqlBaseParser.T__3);
                            this.state = 1681;
                            this.type(0);
                            this.state = 1682;
                            this.match(SqlBaseParser.GT);
                        }
                        break;
                    case 3:
                        {
                            this.state = 1684;
                            this.match(SqlBaseParser.ROW);
                            this.state = 1685;
                            this.match(SqlBaseParser.T__1);
                            this.state = 1686;
                            this.identifier();
                            this.state = 1687;
                            this.type(0);
                            this.state = 1694;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                            while (_la === SqlBaseParser.T__3) {
                                {
                                    {
                                        this.state = 1688;
                                        this.match(SqlBaseParser.T__3);
                                        this.state = 1689;
                                        this.identifier();
                                        this.state = 1690;
                                        this.type(0);
                                    }
                                }
                                this.state = 1696;
                                this._errHandler.sync(this);
                                _la = this._input.LA(1);
                            }
                            this.state = 1697;
                            this.match(SqlBaseParser.T__2);
                        }
                        break;
                    case 4:
                        {
                            this.state = 1699;
                            this.baseType();
                            this.state = 1711;
                            this._errHandler.sync(this);
                            switch (this.interpreter.adaptivePredict(this._input, 217, this._ctx)) {
                                case 1:
                                    {
                                        this.state = 1700;
                                        this.match(SqlBaseParser.T__1);
                                        this.state = 1701;
                                        this.typeParameter();
                                        this.state = 1706;
                                        this._errHandler.sync(this);
                                        _la = this._input.LA(1);
                                        while (_la === SqlBaseParser.T__3) {
                                            {
                                                {
                                                    this.state = 1702;
                                                    this.match(SqlBaseParser.T__3);
                                                    this.state = 1703;
                                                    this.typeParameter();
                                                }
                                            }
                                            this.state = 1708;
                                            this._errHandler.sync(this);
                                            _la = this._input.LA(1);
                                        }
                                        this.state = 1709;
                                        this.match(SqlBaseParser.T__2);
                                    }
                                    break;
                            }
                        }
                        break;
                    case 5:
                        {
                            this.state = 1713;
                            this.match(SqlBaseParser.INTERVAL);
                            this.state = 1714;
                            _localctx._from = this.intervalField();
                            this.state = 1715;
                            this.match(SqlBaseParser.TO);
                            this.state = 1716;
                            _localctx._to = this.intervalField();
                        }
                        break;
                }
                this._ctx._stop = this._input.tryLT(-1);
                this.state = 1724;
                this._errHandler.sync(this);
                _alt = this.interpreter.adaptivePredict(this._input, 219, this._ctx);
                while (_alt !== 2 && _alt !== ATN_1.ATN.INVALID_ALT_NUMBER) {
                    if (_alt === 1) {
                        if (this._parseListeners != null) {
                            this.triggerExitRuleEvent();
                        }
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new TypeContext(_parentctx, _parentState);
                                this.pushNewRecursionContext(_localctx, _startState, SqlBaseParser.RULE_type);
                                this.state = 1720;
                                if (!(this.precpred(this._ctx, 6))) {
                                    throw this.createFailedPredicateException("this.precpred(this._ctx, 6)");
                                }
                                this.state = 1721;
                                this.match(SqlBaseParser.ARRAY);
                            }
                        }
                    }
                    this.state = 1726;
                    this._errHandler.sync(this);
                    _alt = this.interpreter.adaptivePredict(this._input, 219, this._ctx);
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }
    // @RuleVersion(0)
    typeParameter() {
        let _localctx = new TypeParameterContext(this._ctx, this.state);
        this.enterRule(_localctx, 122, SqlBaseParser.RULE_typeParameter);
        try {
            this.state = 1729;
            this._errHandler.sync(this);
            switch (this._input.LA(1)) {
                case SqlBaseParser.INTEGER_VALUE:
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1727;
                        this.match(SqlBaseParser.INTEGER_VALUE);
                    }
                    break;
                case SqlBaseParser.ADD:
                case SqlBaseParser.ADMIN:
                case SqlBaseParser.ALL:
                case SqlBaseParser.ANALYZE:
                case SqlBaseParser.ANY:
                case SqlBaseParser.ARRAY:
                case SqlBaseParser.ASC:
                case SqlBaseParser.AT:
                case SqlBaseParser.BERNOULLI:
                case SqlBaseParser.CALL:
                case SqlBaseParser.CALLED:
                case SqlBaseParser.CASCADE:
                case SqlBaseParser.CATALOGS:
                case SqlBaseParser.COLUMN:
                case SqlBaseParser.COLUMNS:
                case SqlBaseParser.COMMENT:
                case SqlBaseParser.COMMIT:
                case SqlBaseParser.COMMITTED:
                case SqlBaseParser.CURRENT:
                case SqlBaseParser.CURRENT_ROLE:
                case SqlBaseParser.DATA:
                case SqlBaseParser.DATE:
                case SqlBaseParser.DAY:
                case SqlBaseParser.DEFINER:
                case SqlBaseParser.DESC:
                case SqlBaseParser.DETERMINISTIC:
                case SqlBaseParser.DISTRIBUTED:
                case SqlBaseParser.EXCLUDING:
                case SqlBaseParser.EXPLAIN:
                case SqlBaseParser.EXTERNAL:
                case SqlBaseParser.FILTER:
                case SqlBaseParser.FIRST:
                case SqlBaseParser.FOLLOWING:
                case SqlBaseParser.FORMAT:
                case SqlBaseParser.FUNCTION:
                case SqlBaseParser.FUNCTIONS:
                case SqlBaseParser.GRANT:
                case SqlBaseParser.GRANTED:
                case SqlBaseParser.GRANTS:
                case SqlBaseParser.GRAPHVIZ:
                case SqlBaseParser.HOUR:
                case SqlBaseParser.IF:
                case SqlBaseParser.IGNORE:
                case SqlBaseParser.INCLUDING:
                case SqlBaseParser.INPUT:
                case SqlBaseParser.INTERVAL:
                case SqlBaseParser.INVOKER:
                case SqlBaseParser.IO:
                case SqlBaseParser.ISOLATION:
                case SqlBaseParser.JSON:
                case SqlBaseParser.LANGUAGE:
                case SqlBaseParser.LAST:
                case SqlBaseParser.LATERAL:
                case SqlBaseParser.LEVEL:
                case SqlBaseParser.LIMIT:
                case SqlBaseParser.LOGICAL:
                case SqlBaseParser.MAP:
                case SqlBaseParser.MATERIALIZED:
                case SqlBaseParser.MINUTE:
                case SqlBaseParser.MONTH:
                case SqlBaseParser.NAME:
                case SqlBaseParser.NFC:
                case SqlBaseParser.NFD:
                case SqlBaseParser.NFKC:
                case SqlBaseParser.NFKD:
                case SqlBaseParser.NO:
                case SqlBaseParser.NONE:
                case SqlBaseParser.NULLIF:
                case SqlBaseParser.NULLS:
                case SqlBaseParser.OFFSET:
                case SqlBaseParser.ONLY:
                case SqlBaseParser.OPTION:
                case SqlBaseParser.ORDINALITY:
                case SqlBaseParser.OUTPUT:
                case SqlBaseParser.OVER:
                case SqlBaseParser.PARTITION:
                case SqlBaseParser.PARTITIONS:
                case SqlBaseParser.POSITION:
                case SqlBaseParser.PRECEDING:
                case SqlBaseParser.PRIVILEGES:
                case SqlBaseParser.PROPERTIES:
                case SqlBaseParser.RANGE:
                case SqlBaseParser.READ:
                case SqlBaseParser.REFRESH:
                case SqlBaseParser.RENAME:
                case SqlBaseParser.REPEATABLE:
                case SqlBaseParser.REPLACE:
                case SqlBaseParser.RESET:
                case SqlBaseParser.RESPECT:
                case SqlBaseParser.RESTRICT:
                case SqlBaseParser.RETURN:
                case SqlBaseParser.RETURNS:
                case SqlBaseParser.REVOKE:
                case SqlBaseParser.ROLE:
                case SqlBaseParser.ROLES:
                case SqlBaseParser.ROLLBACK:
                case SqlBaseParser.ROW:
                case SqlBaseParser.ROWS:
                case SqlBaseParser.SCHEMA:
                case SqlBaseParser.SCHEMAS:
                case SqlBaseParser.SECOND:
                case SqlBaseParser.SECURITY:
                case SqlBaseParser.SERIALIZABLE:
                case SqlBaseParser.SESSION:
                case SqlBaseParser.SET:
                case SqlBaseParser.SETS:
                case SqlBaseParser.SHOW:
                case SqlBaseParser.SOME:
                case SqlBaseParser.SQL:
                case SqlBaseParser.START:
                case SqlBaseParser.STATS:
                case SqlBaseParser.SUBSTRING:
                case SqlBaseParser.SYSTEM:
                case SqlBaseParser.TABLES:
                case SqlBaseParser.TABLESAMPLE:
                case SqlBaseParser.TEMPORARY:
                case SqlBaseParser.TEXT:
                case SqlBaseParser.TIME:
                case SqlBaseParser.TIMESTAMP:
                case SqlBaseParser.TO:
                case SqlBaseParser.TRANSACTION:
                case SqlBaseParser.TRY_CAST:
                case SqlBaseParser.TYPE:
                case SqlBaseParser.UNBOUNDED:
                case SqlBaseParser.UNCOMMITTED:
                case SqlBaseParser.USE:
                case SqlBaseParser.USER:
                case SqlBaseParser.VALIDATE:
                case SqlBaseParser.VERBOSE:
                case SqlBaseParser.VIEW:
                case SqlBaseParser.WORK:
                case SqlBaseParser.WRITE:
                case SqlBaseParser.YEAR:
                case SqlBaseParser.ZONE:
                case SqlBaseParser.IDENTIFIER:
                case SqlBaseParser.DIGIT_IDENTIFIER:
                case SqlBaseParser.QUOTED_IDENTIFIER:
                case SqlBaseParser.BACKQUOTED_IDENTIFIER:
                case SqlBaseParser.TIME_WITH_TIME_ZONE:
                case SqlBaseParser.TIMESTAMP_WITH_TIME_ZONE:
                case SqlBaseParser.DOUBLE_PRECISION:
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1728;
                        this.type(0);
                    }
                    break;
                default:
                    throw new NoViableAltException_1.NoViableAltException(this);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    baseType() {
        let _localctx = new BaseTypeContext(this._ctx, this.state);
        this.enterRule(_localctx, 124, SqlBaseParser.RULE_baseType);
        try {
            this.state = 1735;
            this._errHandler.sync(this);
            switch (this._input.LA(1)) {
                case SqlBaseParser.TIME_WITH_TIME_ZONE:
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1731;
                        this.match(SqlBaseParser.TIME_WITH_TIME_ZONE);
                    }
                    break;
                case SqlBaseParser.TIMESTAMP_WITH_TIME_ZONE:
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1732;
                        this.match(SqlBaseParser.TIMESTAMP_WITH_TIME_ZONE);
                    }
                    break;
                case SqlBaseParser.DOUBLE_PRECISION:
                    this.enterOuterAlt(_localctx, 3);
                    {
                        this.state = 1733;
                        this.match(SqlBaseParser.DOUBLE_PRECISION);
                    }
                    break;
                case SqlBaseParser.ADD:
                case SqlBaseParser.ADMIN:
                case SqlBaseParser.ALL:
                case SqlBaseParser.ANALYZE:
                case SqlBaseParser.ANY:
                case SqlBaseParser.ARRAY:
                case SqlBaseParser.ASC:
                case SqlBaseParser.AT:
                case SqlBaseParser.BERNOULLI:
                case SqlBaseParser.CALL:
                case SqlBaseParser.CALLED:
                case SqlBaseParser.CASCADE:
                case SqlBaseParser.CATALOGS:
                case SqlBaseParser.COLUMN:
                case SqlBaseParser.COLUMNS:
                case SqlBaseParser.COMMENT:
                case SqlBaseParser.COMMIT:
                case SqlBaseParser.COMMITTED:
                case SqlBaseParser.CURRENT:
                case SqlBaseParser.CURRENT_ROLE:
                case SqlBaseParser.DATA:
                case SqlBaseParser.DATE:
                case SqlBaseParser.DAY:
                case SqlBaseParser.DEFINER:
                case SqlBaseParser.DESC:
                case SqlBaseParser.DETERMINISTIC:
                case SqlBaseParser.DISTRIBUTED:
                case SqlBaseParser.EXCLUDING:
                case SqlBaseParser.EXPLAIN:
                case SqlBaseParser.EXTERNAL:
                case SqlBaseParser.FILTER:
                case SqlBaseParser.FIRST:
                case SqlBaseParser.FOLLOWING:
                case SqlBaseParser.FORMAT:
                case SqlBaseParser.FUNCTION:
                case SqlBaseParser.FUNCTIONS:
                case SqlBaseParser.GRANT:
                case SqlBaseParser.GRANTED:
                case SqlBaseParser.GRANTS:
                case SqlBaseParser.GRAPHVIZ:
                case SqlBaseParser.HOUR:
                case SqlBaseParser.IF:
                case SqlBaseParser.IGNORE:
                case SqlBaseParser.INCLUDING:
                case SqlBaseParser.INPUT:
                case SqlBaseParser.INTERVAL:
                case SqlBaseParser.INVOKER:
                case SqlBaseParser.IO:
                case SqlBaseParser.ISOLATION:
                case SqlBaseParser.JSON:
                case SqlBaseParser.LANGUAGE:
                case SqlBaseParser.LAST:
                case SqlBaseParser.LATERAL:
                case SqlBaseParser.LEVEL:
                case SqlBaseParser.LIMIT:
                case SqlBaseParser.LOGICAL:
                case SqlBaseParser.MAP:
                case SqlBaseParser.MATERIALIZED:
                case SqlBaseParser.MINUTE:
                case SqlBaseParser.MONTH:
                case SqlBaseParser.NAME:
                case SqlBaseParser.NFC:
                case SqlBaseParser.NFD:
                case SqlBaseParser.NFKC:
                case SqlBaseParser.NFKD:
                case SqlBaseParser.NO:
                case SqlBaseParser.NONE:
                case SqlBaseParser.NULLIF:
                case SqlBaseParser.NULLS:
                case SqlBaseParser.OFFSET:
                case SqlBaseParser.ONLY:
                case SqlBaseParser.OPTION:
                case SqlBaseParser.ORDINALITY:
                case SqlBaseParser.OUTPUT:
                case SqlBaseParser.OVER:
                case SqlBaseParser.PARTITION:
                case SqlBaseParser.PARTITIONS:
                case SqlBaseParser.POSITION:
                case SqlBaseParser.PRECEDING:
                case SqlBaseParser.PRIVILEGES:
                case SqlBaseParser.PROPERTIES:
                case SqlBaseParser.RANGE:
                case SqlBaseParser.READ:
                case SqlBaseParser.REFRESH:
                case SqlBaseParser.RENAME:
                case SqlBaseParser.REPEATABLE:
                case SqlBaseParser.REPLACE:
                case SqlBaseParser.RESET:
                case SqlBaseParser.RESPECT:
                case SqlBaseParser.RESTRICT:
                case SqlBaseParser.RETURN:
                case SqlBaseParser.RETURNS:
                case SqlBaseParser.REVOKE:
                case SqlBaseParser.ROLE:
                case SqlBaseParser.ROLES:
                case SqlBaseParser.ROLLBACK:
                case SqlBaseParser.ROW:
                case SqlBaseParser.ROWS:
                case SqlBaseParser.SCHEMA:
                case SqlBaseParser.SCHEMAS:
                case SqlBaseParser.SECOND:
                case SqlBaseParser.SECURITY:
                case SqlBaseParser.SERIALIZABLE:
                case SqlBaseParser.SESSION:
                case SqlBaseParser.SET:
                case SqlBaseParser.SETS:
                case SqlBaseParser.SHOW:
                case SqlBaseParser.SOME:
                case SqlBaseParser.SQL:
                case SqlBaseParser.START:
                case SqlBaseParser.STATS:
                case SqlBaseParser.SUBSTRING:
                case SqlBaseParser.SYSTEM:
                case SqlBaseParser.TABLES:
                case SqlBaseParser.TABLESAMPLE:
                case SqlBaseParser.TEMPORARY:
                case SqlBaseParser.TEXT:
                case SqlBaseParser.TIME:
                case SqlBaseParser.TIMESTAMP:
                case SqlBaseParser.TO:
                case SqlBaseParser.TRANSACTION:
                case SqlBaseParser.TRY_CAST:
                case SqlBaseParser.TYPE:
                case SqlBaseParser.UNBOUNDED:
                case SqlBaseParser.UNCOMMITTED:
                case SqlBaseParser.USE:
                case SqlBaseParser.USER:
                case SqlBaseParser.VALIDATE:
                case SqlBaseParser.VERBOSE:
                case SqlBaseParser.VIEW:
                case SqlBaseParser.WORK:
                case SqlBaseParser.WRITE:
                case SqlBaseParser.YEAR:
                case SqlBaseParser.ZONE:
                case SqlBaseParser.IDENTIFIER:
                case SqlBaseParser.DIGIT_IDENTIFIER:
                case SqlBaseParser.QUOTED_IDENTIFIER:
                case SqlBaseParser.BACKQUOTED_IDENTIFIER:
                    this.enterOuterAlt(_localctx, 4);
                    {
                        this.state = 1734;
                        this.qualifiedName();
                    }
                    break;
                default:
                    throw new NoViableAltException_1.NoViableAltException(this);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    whenClause() {
        let _localctx = new WhenClauseContext(this._ctx, this.state);
        this.enterRule(_localctx, 126, SqlBaseParser.RULE_whenClause);
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1737;
                this.match(SqlBaseParser.WHEN);
                this.state = 1738;
                _localctx._condition = this.expression();
                this.state = 1739;
                this.match(SqlBaseParser.THEN);
                this.state = 1740;
                _localctx._result = this.expression();
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    filter() {
        let _localctx = new FilterContext(this._ctx, this.state);
        this.enterRule(_localctx, 128, SqlBaseParser.RULE_filter);
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1742;
                this.match(SqlBaseParser.FILTER);
                this.state = 1743;
                this.match(SqlBaseParser.T__1);
                this.state = 1744;
                this.match(SqlBaseParser.WHERE);
                this.state = 1745;
                this.booleanExpression(0);
                this.state = 1746;
                this.match(SqlBaseParser.T__2);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    over() {
        let _localctx = new OverContext(this._ctx, this.state);
        this.enterRule(_localctx, 130, SqlBaseParser.RULE_over);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1748;
                this.match(SqlBaseParser.OVER);
                this.state = 1749;
                this.match(SqlBaseParser.T__1);
                this.state = 1760;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la === SqlBaseParser.PARTITION) {
                    {
                        this.state = 1750;
                        this.match(SqlBaseParser.PARTITION);
                        this.state = 1751;
                        this.match(SqlBaseParser.BY);
                        this.state = 1752;
                        _localctx._expression = this.expression();
                        _localctx._partition.push(_localctx._expression);
                        this.state = 1757;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        while (_la === SqlBaseParser.T__3) {
                            {
                                {
                                    this.state = 1753;
                                    this.match(SqlBaseParser.T__3);
                                    this.state = 1754;
                                    _localctx._expression = this.expression();
                                    _localctx._partition.push(_localctx._expression);
                                }
                            }
                            this.state = 1759;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                        }
                    }
                }
                this.state = 1772;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la === SqlBaseParser.ORDER) {
                    {
                        this.state = 1762;
                        this.match(SqlBaseParser.ORDER);
                        this.state = 1763;
                        this.match(SqlBaseParser.BY);
                        this.state = 1764;
                        this.sortItem();
                        this.state = 1769;
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                        while (_la === SqlBaseParser.T__3) {
                            {
                                {
                                    this.state = 1765;
                                    this.match(SqlBaseParser.T__3);
                                    this.state = 1766;
                                    this.sortItem();
                                }
                            }
                            this.state = 1771;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                        }
                    }
                }
                this.state = 1775;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la === SqlBaseParser.RANGE || _la === SqlBaseParser.ROWS) {
                    {
                        this.state = 1774;
                        this.windowFrame();
                    }
                }
                this.state = 1777;
                this.match(SqlBaseParser.T__2);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    windowFrame() {
        let _localctx = new WindowFrameContext(this._ctx, this.state);
        this.enterRule(_localctx, 132, SqlBaseParser.RULE_windowFrame);
        try {
            this.state = 1795;
            this._errHandler.sync(this);
            switch (this.interpreter.adaptivePredict(this._input, 227, this._ctx)) {
                case 1:
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1779;
                        _localctx._frameType = this.match(SqlBaseParser.RANGE);
                        this.state = 1780;
                        _localctx._start = this.frameBound();
                    }
                    break;
                case 2:
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1781;
                        _localctx._frameType = this.match(SqlBaseParser.ROWS);
                        this.state = 1782;
                        _localctx._start = this.frameBound();
                    }
                    break;
                case 3:
                    this.enterOuterAlt(_localctx, 3);
                    {
                        this.state = 1783;
                        _localctx._frameType = this.match(SqlBaseParser.RANGE);
                        this.state = 1784;
                        this.match(SqlBaseParser.BETWEEN);
                        this.state = 1785;
                        _localctx._start = this.frameBound();
                        this.state = 1786;
                        this.match(SqlBaseParser.AND);
                        this.state = 1787;
                        _localctx._end = this.frameBound();
                    }
                    break;
                case 4:
                    this.enterOuterAlt(_localctx, 4);
                    {
                        this.state = 1789;
                        _localctx._frameType = this.match(SqlBaseParser.ROWS);
                        this.state = 1790;
                        this.match(SqlBaseParser.BETWEEN);
                        this.state = 1791;
                        _localctx._start = this.frameBound();
                        this.state = 1792;
                        this.match(SqlBaseParser.AND);
                        this.state = 1793;
                        _localctx._end = this.frameBound();
                    }
                    break;
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    frameBound() {
        let _localctx = new FrameBoundContext(this._ctx, this.state);
        this.enterRule(_localctx, 134, SqlBaseParser.RULE_frameBound);
        let _la;
        try {
            this.state = 1806;
            this._errHandler.sync(this);
            switch (this.interpreter.adaptivePredict(this._input, 228, this._ctx)) {
                case 1:
                    _localctx = new UnboundedFrameContext(_localctx);
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1797;
                        this.match(SqlBaseParser.UNBOUNDED);
                        this.state = 1798;
                        _localctx._boundType = this.match(SqlBaseParser.PRECEDING);
                    }
                    break;
                case 2:
                    _localctx = new UnboundedFrameContext(_localctx);
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1799;
                        this.match(SqlBaseParser.UNBOUNDED);
                        this.state = 1800;
                        _localctx._boundType = this.match(SqlBaseParser.FOLLOWING);
                    }
                    break;
                case 3:
                    _localctx = new CurrentRowBoundContext(_localctx);
                    this.enterOuterAlt(_localctx, 3);
                    {
                        this.state = 1801;
                        this.match(SqlBaseParser.CURRENT);
                        this.state = 1802;
                        this.match(SqlBaseParser.ROW);
                    }
                    break;
                case 4:
                    _localctx = new BoundedFrameContext(_localctx);
                    this.enterOuterAlt(_localctx, 4);
                    {
                        this.state = 1803;
                        this.expression();
                        this.state = 1804;
                        _localctx._boundType = this._input.LT(1);
                        _la = this._input.LA(1);
                        if (!(_la === SqlBaseParser.FOLLOWING || _la === SqlBaseParser.PRECEDING)) {
                            _localctx._boundType = this._errHandler.recoverInline(this);
                        }
                        else {
                            if (this._input.LA(1) === Token_1.Token.EOF) {
                                this.matchedEOF = true;
                            }
                            this._errHandler.reportMatch(this);
                            this.consume();
                        }
                    }
                    break;
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    explainOption() {
        let _localctx = new ExplainOptionContext(this._ctx, this.state);
        this.enterRule(_localctx, 136, SqlBaseParser.RULE_explainOption);
        let _la;
        try {
            this.state = 1812;
            this._errHandler.sync(this);
            switch (this._input.LA(1)) {
                case SqlBaseParser.FORMAT:
                    _localctx = new ExplainFormatContext(_localctx);
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1808;
                        this.match(SqlBaseParser.FORMAT);
                        this.state = 1809;
                        _localctx._value = this._input.LT(1);
                        _la = this._input.LA(1);
                        if (!(_la === SqlBaseParser.GRAPHVIZ || _la === SqlBaseParser.JSON || _la === SqlBaseParser.TEXT)) {
                            _localctx._value = this._errHandler.recoverInline(this);
                        }
                        else {
                            if (this._input.LA(1) === Token_1.Token.EOF) {
                                this.matchedEOF = true;
                            }
                            this._errHandler.reportMatch(this);
                            this.consume();
                        }
                    }
                    break;
                case SqlBaseParser.TYPE:
                    _localctx = new ExplainTypeContext(_localctx);
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1810;
                        this.match(SqlBaseParser.TYPE);
                        this.state = 1811;
                        _localctx._value = this._input.LT(1);
                        _la = this._input.LA(1);
                        if (!(_la === SqlBaseParser.DISTRIBUTED || _la === SqlBaseParser.IO || _la === SqlBaseParser.LOGICAL || _la === SqlBaseParser.VALIDATE)) {
                            _localctx._value = this._errHandler.recoverInline(this);
                        }
                        else {
                            if (this._input.LA(1) === Token_1.Token.EOF) {
                                this.matchedEOF = true;
                            }
                            this._errHandler.reportMatch(this);
                            this.consume();
                        }
                    }
                    break;
                default:
                    throw new NoViableAltException_1.NoViableAltException(this);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    transactionMode() {
        let _localctx = new TransactionModeContext(this._ctx, this.state);
        this.enterRule(_localctx, 138, SqlBaseParser.RULE_transactionMode);
        let _la;
        try {
            this.state = 1819;
            this._errHandler.sync(this);
            switch (this._input.LA(1)) {
                case SqlBaseParser.ISOLATION:
                    _localctx = new IsolationLevelContext(_localctx);
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1814;
                        this.match(SqlBaseParser.ISOLATION);
                        this.state = 1815;
                        this.match(SqlBaseParser.LEVEL);
                        this.state = 1816;
                        this.levelOfIsolation();
                    }
                    break;
                case SqlBaseParser.READ:
                    _localctx = new TransactionAccessModeContext(_localctx);
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1817;
                        this.match(SqlBaseParser.READ);
                        this.state = 1818;
                        _localctx._accessMode = this._input.LT(1);
                        _la = this._input.LA(1);
                        if (!(_la === SqlBaseParser.ONLY || _la === SqlBaseParser.WRITE)) {
                            _localctx._accessMode = this._errHandler.recoverInline(this);
                        }
                        else {
                            if (this._input.LA(1) === Token_1.Token.EOF) {
                                this.matchedEOF = true;
                            }
                            this._errHandler.reportMatch(this);
                            this.consume();
                        }
                    }
                    break;
                default:
                    throw new NoViableAltException_1.NoViableAltException(this);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    levelOfIsolation() {
        let _localctx = new LevelOfIsolationContext(this._ctx, this.state);
        this.enterRule(_localctx, 140, SqlBaseParser.RULE_levelOfIsolation);
        try {
            this.state = 1828;
            this._errHandler.sync(this);
            switch (this.interpreter.adaptivePredict(this._input, 231, this._ctx)) {
                case 1:
                    _localctx = new ReadUncommittedContext(_localctx);
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1821;
                        this.match(SqlBaseParser.READ);
                        this.state = 1822;
                        this.match(SqlBaseParser.UNCOMMITTED);
                    }
                    break;
                case 2:
                    _localctx = new ReadCommittedContext(_localctx);
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1823;
                        this.match(SqlBaseParser.READ);
                        this.state = 1824;
                        this.match(SqlBaseParser.COMMITTED);
                    }
                    break;
                case 3:
                    _localctx = new RepeatableReadContext(_localctx);
                    this.enterOuterAlt(_localctx, 3);
                    {
                        this.state = 1825;
                        this.match(SqlBaseParser.REPEATABLE);
                        this.state = 1826;
                        this.match(SqlBaseParser.READ);
                    }
                    break;
                case 4:
                    _localctx = new SerializableContext(_localctx);
                    this.enterOuterAlt(_localctx, 4);
                    {
                        this.state = 1827;
                        this.match(SqlBaseParser.SERIALIZABLE);
                    }
                    break;
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    callArgument() {
        let _localctx = new CallArgumentContext(this._ctx, this.state);
        this.enterRule(_localctx, 142, SqlBaseParser.RULE_callArgument);
        try {
            this.state = 1835;
            this._errHandler.sync(this);
            switch (this.interpreter.adaptivePredict(this._input, 232, this._ctx)) {
                case 1:
                    _localctx = new PositionalArgumentContext(_localctx);
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1830;
                        this.expression();
                    }
                    break;
                case 2:
                    _localctx = new NamedArgumentContext(_localctx);
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1831;
                        this.identifier();
                        this.state = 1832;
                        this.match(SqlBaseParser.T__8);
                        this.state = 1833;
                        this.expression();
                    }
                    break;
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    privilege() {
        let _localctx = new PrivilegeContext(this._ctx, this.state);
        this.enterRule(_localctx, 144, SqlBaseParser.RULE_privilege);
        try {
            this.state = 1841;
            this._errHandler.sync(this);
            switch (this._input.LA(1)) {
                case SqlBaseParser.SELECT:
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1837;
                        this.match(SqlBaseParser.SELECT);
                    }
                    break;
                case SqlBaseParser.DELETE:
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1838;
                        this.match(SqlBaseParser.DELETE);
                    }
                    break;
                case SqlBaseParser.INSERT:
                    this.enterOuterAlt(_localctx, 3);
                    {
                        this.state = 1839;
                        this.match(SqlBaseParser.INSERT);
                    }
                    break;
                case SqlBaseParser.ADD:
                case SqlBaseParser.ADMIN:
                case SqlBaseParser.ALL:
                case SqlBaseParser.ANALYZE:
                case SqlBaseParser.ANY:
                case SqlBaseParser.ARRAY:
                case SqlBaseParser.ASC:
                case SqlBaseParser.AT:
                case SqlBaseParser.BERNOULLI:
                case SqlBaseParser.CALL:
                case SqlBaseParser.CALLED:
                case SqlBaseParser.CASCADE:
                case SqlBaseParser.CATALOGS:
                case SqlBaseParser.COLUMN:
                case SqlBaseParser.COLUMNS:
                case SqlBaseParser.COMMENT:
                case SqlBaseParser.COMMIT:
                case SqlBaseParser.COMMITTED:
                case SqlBaseParser.CURRENT:
                case SqlBaseParser.CURRENT_ROLE:
                case SqlBaseParser.DATA:
                case SqlBaseParser.DATE:
                case SqlBaseParser.DAY:
                case SqlBaseParser.DEFINER:
                case SqlBaseParser.DESC:
                case SqlBaseParser.DETERMINISTIC:
                case SqlBaseParser.DISTRIBUTED:
                case SqlBaseParser.EXCLUDING:
                case SqlBaseParser.EXPLAIN:
                case SqlBaseParser.EXTERNAL:
                case SqlBaseParser.FILTER:
                case SqlBaseParser.FIRST:
                case SqlBaseParser.FOLLOWING:
                case SqlBaseParser.FORMAT:
                case SqlBaseParser.FUNCTION:
                case SqlBaseParser.FUNCTIONS:
                case SqlBaseParser.GRANT:
                case SqlBaseParser.GRANTED:
                case SqlBaseParser.GRANTS:
                case SqlBaseParser.GRAPHVIZ:
                case SqlBaseParser.HOUR:
                case SqlBaseParser.IF:
                case SqlBaseParser.IGNORE:
                case SqlBaseParser.INCLUDING:
                case SqlBaseParser.INPUT:
                case SqlBaseParser.INTERVAL:
                case SqlBaseParser.INVOKER:
                case SqlBaseParser.IO:
                case SqlBaseParser.ISOLATION:
                case SqlBaseParser.JSON:
                case SqlBaseParser.LANGUAGE:
                case SqlBaseParser.LAST:
                case SqlBaseParser.LATERAL:
                case SqlBaseParser.LEVEL:
                case SqlBaseParser.LIMIT:
                case SqlBaseParser.LOGICAL:
                case SqlBaseParser.MAP:
                case SqlBaseParser.MATERIALIZED:
                case SqlBaseParser.MINUTE:
                case SqlBaseParser.MONTH:
                case SqlBaseParser.NAME:
                case SqlBaseParser.NFC:
                case SqlBaseParser.NFD:
                case SqlBaseParser.NFKC:
                case SqlBaseParser.NFKD:
                case SqlBaseParser.NO:
                case SqlBaseParser.NONE:
                case SqlBaseParser.NULLIF:
                case SqlBaseParser.NULLS:
                case SqlBaseParser.OFFSET:
                case SqlBaseParser.ONLY:
                case SqlBaseParser.OPTION:
                case SqlBaseParser.ORDINALITY:
                case SqlBaseParser.OUTPUT:
                case SqlBaseParser.OVER:
                case SqlBaseParser.PARTITION:
                case SqlBaseParser.PARTITIONS:
                case SqlBaseParser.POSITION:
                case SqlBaseParser.PRECEDING:
                case SqlBaseParser.PRIVILEGES:
                case SqlBaseParser.PROPERTIES:
                case SqlBaseParser.RANGE:
                case SqlBaseParser.READ:
                case SqlBaseParser.REFRESH:
                case SqlBaseParser.RENAME:
                case SqlBaseParser.REPEATABLE:
                case SqlBaseParser.REPLACE:
                case SqlBaseParser.RESET:
                case SqlBaseParser.RESPECT:
                case SqlBaseParser.RESTRICT:
                case SqlBaseParser.RETURN:
                case SqlBaseParser.RETURNS:
                case SqlBaseParser.REVOKE:
                case SqlBaseParser.ROLE:
                case SqlBaseParser.ROLES:
                case SqlBaseParser.ROLLBACK:
                case SqlBaseParser.ROW:
                case SqlBaseParser.ROWS:
                case SqlBaseParser.SCHEMA:
                case SqlBaseParser.SCHEMAS:
                case SqlBaseParser.SECOND:
                case SqlBaseParser.SECURITY:
                case SqlBaseParser.SERIALIZABLE:
                case SqlBaseParser.SESSION:
                case SqlBaseParser.SET:
                case SqlBaseParser.SETS:
                case SqlBaseParser.SHOW:
                case SqlBaseParser.SOME:
                case SqlBaseParser.SQL:
                case SqlBaseParser.START:
                case SqlBaseParser.STATS:
                case SqlBaseParser.SUBSTRING:
                case SqlBaseParser.SYSTEM:
                case SqlBaseParser.TABLES:
                case SqlBaseParser.TABLESAMPLE:
                case SqlBaseParser.TEMPORARY:
                case SqlBaseParser.TEXT:
                case SqlBaseParser.TIME:
                case SqlBaseParser.TIMESTAMP:
                case SqlBaseParser.TO:
                case SqlBaseParser.TRANSACTION:
                case SqlBaseParser.TRY_CAST:
                case SqlBaseParser.TYPE:
                case SqlBaseParser.UNBOUNDED:
                case SqlBaseParser.UNCOMMITTED:
                case SqlBaseParser.USE:
                case SqlBaseParser.USER:
                case SqlBaseParser.VALIDATE:
                case SqlBaseParser.VERBOSE:
                case SqlBaseParser.VIEW:
                case SqlBaseParser.WORK:
                case SqlBaseParser.WRITE:
                case SqlBaseParser.YEAR:
                case SqlBaseParser.ZONE:
                case SqlBaseParser.IDENTIFIER:
                case SqlBaseParser.DIGIT_IDENTIFIER:
                case SqlBaseParser.QUOTED_IDENTIFIER:
                case SqlBaseParser.BACKQUOTED_IDENTIFIER:
                    this.enterOuterAlt(_localctx, 4);
                    {
                        this.state = 1840;
                        this.identifier();
                    }
                    break;
                default:
                    throw new NoViableAltException_1.NoViableAltException(this);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    qualifiedName() {
        let _localctx = new QualifiedNameContext(this._ctx, this.state);
        this.enterRule(_localctx, 146, SqlBaseParser.RULE_qualifiedName);
        try {
            let _alt;
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1843;
                this.identifier();
                this.state = 1848;
                this._errHandler.sync(this);
                _alt = this.interpreter.adaptivePredict(this._input, 234, this._ctx);
                while (_alt !== 2 && _alt !== ATN_1.ATN.INVALID_ALT_NUMBER) {
                    if (_alt === 1) {
                        {
                            {
                                this.state = 1844;
                                this.match(SqlBaseParser.T__0);
                                this.state = 1845;
                                this.identifier();
                            }
                        }
                    }
                    this.state = 1850;
                    this._errHandler.sync(this);
                    _alt = this.interpreter.adaptivePredict(this._input, 234, this._ctx);
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    tableNameWithAliases() {
        let _localctx = new TableNameWithAliasesContext(this._ctx, this.state);
        this.enterRule(_localctx, 148, SqlBaseParser.RULE_tableNameWithAliases);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1851;
                this.identifier();
                this.state = 1856;
                this._errHandler.sync(this);
                switch (this.interpreter.adaptivePredict(this._input, 236, this._ctx)) {
                    case 1:
                        {
                            this.state = 1853;
                            this._errHandler.sync(this);
                            _la = this._input.LA(1);
                            if (_la === SqlBaseParser.AS) {
                                {
                                    this.state = 1852;
                                    this.match(SqlBaseParser.AS);
                                }
                            }
                            this.state = 1855;
                            this.identifier();
                        }
                        break;
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    grantor() {
        let _localctx = new GrantorContext(this._ctx, this.state);
        this.enterRule(_localctx, 150, SqlBaseParser.RULE_grantor);
        try {
            this.state = 1861;
            this._errHandler.sync(this);
            switch (this.interpreter.adaptivePredict(this._input, 237, this._ctx)) {
                case 1:
                    _localctx = new CurrentUserGrantorContext(_localctx);
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1858;
                        this.match(SqlBaseParser.CURRENT_USER);
                    }
                    break;
                case 2:
                    _localctx = new CurrentRoleGrantorContext(_localctx);
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1859;
                        this.match(SqlBaseParser.CURRENT_ROLE);
                    }
                    break;
                case 3:
                    _localctx = new SpecifiedPrincipalContext(_localctx);
                    this.enterOuterAlt(_localctx, 3);
                    {
                        this.state = 1860;
                        this.principal();
                    }
                    break;
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    principal() {
        let _localctx = new PrincipalContext(this._ctx, this.state);
        this.enterRule(_localctx, 152, SqlBaseParser.RULE_principal);
        try {
            this.state = 1868;
            this._errHandler.sync(this);
            switch (this.interpreter.adaptivePredict(this._input, 238, this._ctx)) {
                case 1:
                    _localctx = new UserPrincipalContext(_localctx);
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1863;
                        this.match(SqlBaseParser.USER);
                        this.state = 1864;
                        this.identifier();
                    }
                    break;
                case 2:
                    _localctx = new RolePrincipalContext(_localctx);
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1865;
                        this.match(SqlBaseParser.ROLE);
                        this.state = 1866;
                        this.identifier();
                    }
                    break;
                case 3:
                    _localctx = new UnspecifiedPrincipalContext(_localctx);
                    this.enterOuterAlt(_localctx, 3);
                    {
                        this.state = 1867;
                        this.identifier();
                    }
                    break;
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    roles() {
        let _localctx = new RolesContext(this._ctx, this.state);
        this.enterRule(_localctx, 154, SqlBaseParser.RULE_roles);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1870;
                this.identifier();
                this.state = 1875;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                while (_la === SqlBaseParser.T__3) {
                    {
                        {
                            this.state = 1871;
                            this.match(SqlBaseParser.T__3);
                            this.state = 1872;
                            this.identifier();
                        }
                    }
                    this.state = 1877;
                    this._errHandler.sync(this);
                    _la = this._input.LA(1);
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    identifier() {
        let _localctx = new IdentifierContext(this._ctx, this.state);
        this.enterRule(_localctx, 156, SqlBaseParser.RULE_identifier);
        try {
            this.state = 1883;
            this._errHandler.sync(this);
            switch (this._input.LA(1)) {
                case SqlBaseParser.IDENTIFIER:
                    _localctx = new UnquotedIdentifierContext(_localctx);
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1878;
                        this.match(SqlBaseParser.IDENTIFIER);
                    }
                    break;
                case SqlBaseParser.QUOTED_IDENTIFIER:
                    _localctx = new QuotedIdentifierContext(_localctx);
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1879;
                        this.match(SqlBaseParser.QUOTED_IDENTIFIER);
                    }
                    break;
                case SqlBaseParser.ADD:
                case SqlBaseParser.ADMIN:
                case SqlBaseParser.ALL:
                case SqlBaseParser.ANALYZE:
                case SqlBaseParser.ANY:
                case SqlBaseParser.ARRAY:
                case SqlBaseParser.ASC:
                case SqlBaseParser.AT:
                case SqlBaseParser.BERNOULLI:
                case SqlBaseParser.CALL:
                case SqlBaseParser.CALLED:
                case SqlBaseParser.CASCADE:
                case SqlBaseParser.CATALOGS:
                case SqlBaseParser.COLUMN:
                case SqlBaseParser.COLUMNS:
                case SqlBaseParser.COMMENT:
                case SqlBaseParser.COMMIT:
                case SqlBaseParser.COMMITTED:
                case SqlBaseParser.CURRENT:
                case SqlBaseParser.CURRENT_ROLE:
                case SqlBaseParser.DATA:
                case SqlBaseParser.DATE:
                case SqlBaseParser.DAY:
                case SqlBaseParser.DEFINER:
                case SqlBaseParser.DESC:
                case SqlBaseParser.DETERMINISTIC:
                case SqlBaseParser.DISTRIBUTED:
                case SqlBaseParser.EXCLUDING:
                case SqlBaseParser.EXPLAIN:
                case SqlBaseParser.EXTERNAL:
                case SqlBaseParser.FILTER:
                case SqlBaseParser.FIRST:
                case SqlBaseParser.FOLLOWING:
                case SqlBaseParser.FORMAT:
                case SqlBaseParser.FUNCTION:
                case SqlBaseParser.FUNCTIONS:
                case SqlBaseParser.GRANT:
                case SqlBaseParser.GRANTED:
                case SqlBaseParser.GRANTS:
                case SqlBaseParser.GRAPHVIZ:
                case SqlBaseParser.HOUR:
                case SqlBaseParser.IF:
                case SqlBaseParser.IGNORE:
                case SqlBaseParser.INCLUDING:
                case SqlBaseParser.INPUT:
                case SqlBaseParser.INTERVAL:
                case SqlBaseParser.INVOKER:
                case SqlBaseParser.IO:
                case SqlBaseParser.ISOLATION:
                case SqlBaseParser.JSON:
                case SqlBaseParser.LANGUAGE:
                case SqlBaseParser.LAST:
                case SqlBaseParser.LATERAL:
                case SqlBaseParser.LEVEL:
                case SqlBaseParser.LIMIT:
                case SqlBaseParser.LOGICAL:
                case SqlBaseParser.MAP:
                case SqlBaseParser.MATERIALIZED:
                case SqlBaseParser.MINUTE:
                case SqlBaseParser.MONTH:
                case SqlBaseParser.NAME:
                case SqlBaseParser.NFC:
                case SqlBaseParser.NFD:
                case SqlBaseParser.NFKC:
                case SqlBaseParser.NFKD:
                case SqlBaseParser.NO:
                case SqlBaseParser.NONE:
                case SqlBaseParser.NULLIF:
                case SqlBaseParser.NULLS:
                case SqlBaseParser.OFFSET:
                case SqlBaseParser.ONLY:
                case SqlBaseParser.OPTION:
                case SqlBaseParser.ORDINALITY:
                case SqlBaseParser.OUTPUT:
                case SqlBaseParser.OVER:
                case SqlBaseParser.PARTITION:
                case SqlBaseParser.PARTITIONS:
                case SqlBaseParser.POSITION:
                case SqlBaseParser.PRECEDING:
                case SqlBaseParser.PRIVILEGES:
                case SqlBaseParser.PROPERTIES:
                case SqlBaseParser.RANGE:
                case SqlBaseParser.READ:
                case SqlBaseParser.REFRESH:
                case SqlBaseParser.RENAME:
                case SqlBaseParser.REPEATABLE:
                case SqlBaseParser.REPLACE:
                case SqlBaseParser.RESET:
                case SqlBaseParser.RESPECT:
                case SqlBaseParser.RESTRICT:
                case SqlBaseParser.RETURN:
                case SqlBaseParser.RETURNS:
                case SqlBaseParser.REVOKE:
                case SqlBaseParser.ROLE:
                case SqlBaseParser.ROLES:
                case SqlBaseParser.ROLLBACK:
                case SqlBaseParser.ROW:
                case SqlBaseParser.ROWS:
                case SqlBaseParser.SCHEMA:
                case SqlBaseParser.SCHEMAS:
                case SqlBaseParser.SECOND:
                case SqlBaseParser.SECURITY:
                case SqlBaseParser.SERIALIZABLE:
                case SqlBaseParser.SESSION:
                case SqlBaseParser.SET:
                case SqlBaseParser.SETS:
                case SqlBaseParser.SHOW:
                case SqlBaseParser.SOME:
                case SqlBaseParser.SQL:
                case SqlBaseParser.START:
                case SqlBaseParser.STATS:
                case SqlBaseParser.SUBSTRING:
                case SqlBaseParser.SYSTEM:
                case SqlBaseParser.TABLES:
                case SqlBaseParser.TABLESAMPLE:
                case SqlBaseParser.TEMPORARY:
                case SqlBaseParser.TEXT:
                case SqlBaseParser.TIME:
                case SqlBaseParser.TIMESTAMP:
                case SqlBaseParser.TO:
                case SqlBaseParser.TRANSACTION:
                case SqlBaseParser.TRY_CAST:
                case SqlBaseParser.TYPE:
                case SqlBaseParser.UNBOUNDED:
                case SqlBaseParser.UNCOMMITTED:
                case SqlBaseParser.USE:
                case SqlBaseParser.USER:
                case SqlBaseParser.VALIDATE:
                case SqlBaseParser.VERBOSE:
                case SqlBaseParser.VIEW:
                case SqlBaseParser.WORK:
                case SqlBaseParser.WRITE:
                case SqlBaseParser.YEAR:
                case SqlBaseParser.ZONE:
                    _localctx = new UnquotedIdentifierContext(_localctx);
                    this.enterOuterAlt(_localctx, 3);
                    {
                        this.state = 1880;
                        this.nonReserved();
                    }
                    break;
                case SqlBaseParser.BACKQUOTED_IDENTIFIER:
                    _localctx = new BackQuotedIdentifierContext(_localctx);
                    this.enterOuterAlt(_localctx, 4);
                    {
                        this.state = 1881;
                        this.match(SqlBaseParser.BACKQUOTED_IDENTIFIER);
                    }
                    break;
                case SqlBaseParser.DIGIT_IDENTIFIER:
                    _localctx = new DigitIdentifierContext(_localctx);
                    this.enterOuterAlt(_localctx, 5);
                    {
                        this.state = 1882;
                        this.match(SqlBaseParser.DIGIT_IDENTIFIER);
                    }
                    break;
                default:
                    throw new NoViableAltException_1.NoViableAltException(this);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    number() {
        let _localctx = new NumberContext(this._ctx, this.state);
        this.enterRule(_localctx, 158, SqlBaseParser.RULE_number);
        try {
            this.state = 1888;
            this._errHandler.sync(this);
            switch (this._input.LA(1)) {
                case SqlBaseParser.DECIMAL_VALUE:
                    _localctx = new DecimalLiteralContext(_localctx);
                    this.enterOuterAlt(_localctx, 1);
                    {
                        this.state = 1885;
                        this.match(SqlBaseParser.DECIMAL_VALUE);
                    }
                    break;
                case SqlBaseParser.DOUBLE_VALUE:
                    _localctx = new DoubleLiteralContext(_localctx);
                    this.enterOuterAlt(_localctx, 2);
                    {
                        this.state = 1886;
                        this.match(SqlBaseParser.DOUBLE_VALUE);
                    }
                    break;
                case SqlBaseParser.INTEGER_VALUE:
                    _localctx = new IntegerLiteralContext(_localctx);
                    this.enterOuterAlt(_localctx, 3);
                    {
                        this.state = 1887;
                        this.match(SqlBaseParser.INTEGER_VALUE);
                    }
                    break;
                default:
                    throw new NoViableAltException_1.NoViableAltException(this);
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    // @RuleVersion(0)
    nonReserved() {
        let _localctx = new NonReservedContext(this._ctx, this.state);
        this.enterRule(_localctx, 160, SqlBaseParser.RULE_nonReserved);
        let _la;
        try {
            this.enterOuterAlt(_localctx, 1);
            {
                this.state = 1890;
                _la = this._input.LA(1);
                if (!((((_la) & ~0x1F) === 0 && ((1 << _la) & ((1 << SqlBaseParser.ADD) | (1 << SqlBaseParser.ADMIN) | (1 << SqlBaseParser.ALL) | (1 << SqlBaseParser.ANALYZE) | (1 << SqlBaseParser.ANY) | (1 << SqlBaseParser.ARRAY) | (1 << SqlBaseParser.ASC) | (1 << SqlBaseParser.AT) | (1 << SqlBaseParser.BERNOULLI) | (1 << SqlBaseParser.CALL) | (1 << SqlBaseParser.CALLED) | (1 << SqlBaseParser.CASCADE) | (1 << SqlBaseParser.CATALOGS) | (1 << SqlBaseParser.COLUMN) | (1 << SqlBaseParser.COLUMNS))) !== 0) || ((((_la - 32)) & ~0x1F) === 0 && ((1 << (_la - 32)) & ((1 << (SqlBaseParser.COMMENT - 32)) | (1 << (SqlBaseParser.COMMIT - 32)) | (1 << (SqlBaseParser.COMMITTED - 32)) | (1 << (SqlBaseParser.CURRENT - 32)) | (1 << (SqlBaseParser.CURRENT_ROLE - 32)) | (1 << (SqlBaseParser.DATA - 32)) | (1 << (SqlBaseParser.DATE - 32)) | (1 << (SqlBaseParser.DAY - 32)) | (1 << (SqlBaseParser.DEFINER - 32)) | (1 << (SqlBaseParser.DESC - 32)) | (1 << (SqlBaseParser.DETERMINISTIC - 32)) | (1 << (SqlBaseParser.DISTRIBUTED - 32)) | (1 << (SqlBaseParser.EXCLUDING - 32)))) !== 0) || ((((_la - 64)) & ~0x1F) === 0 && ((1 << (_la - 64)) & ((1 << (SqlBaseParser.EXPLAIN - 64)) | (1 << (SqlBaseParser.EXTERNAL - 64)) | (1 << (SqlBaseParser.FILTER - 64)) | (1 << (SqlBaseParser.FIRST - 64)) | (1 << (SqlBaseParser.FOLLOWING - 64)) | (1 << (SqlBaseParser.FORMAT - 64)) | (1 << (SqlBaseParser.FUNCTION - 64)) | (1 << (SqlBaseParser.FUNCTIONS - 64)) | (1 << (SqlBaseParser.GRANT - 64)) | (1 << (SqlBaseParser.GRANTED - 64)) | (1 << (SqlBaseParser.GRANTS - 64)) | (1 << (SqlBaseParser.GRAPHVIZ - 64)) | (1 << (SqlBaseParser.HOUR - 64)) | (1 << (SqlBaseParser.IF - 64)) | (1 << (SqlBaseParser.IGNORE - 64)) | (1 << (SqlBaseParser.INCLUDING - 64)) | (1 << (SqlBaseParser.INPUT - 64)) | (1 << (SqlBaseParser.INTERVAL - 64)) | (1 << (SqlBaseParser.INVOKER - 64)))) !== 0) || ((((_la - 96)) & ~0x1F) === 0 && ((1 << (_la - 96)) & ((1 << (SqlBaseParser.IO - 96)) | (1 << (SqlBaseParser.ISOLATION - 96)) | (1 << (SqlBaseParser.JSON - 96)) | (1 << (SqlBaseParser.LANGUAGE - 96)) | (1 << (SqlBaseParser.LAST - 96)) | (1 << (SqlBaseParser.LATERAL - 96)) | (1 << (SqlBaseParser.LEVEL - 96)) | (1 << (SqlBaseParser.LIMIT - 96)) | (1 << (SqlBaseParser.LOGICAL - 96)) | (1 << (SqlBaseParser.MAP - 96)) | (1 << (SqlBaseParser.MATERIALIZED - 96)) | (1 << (SqlBaseParser.MINUTE - 96)) | (1 << (SqlBaseParser.MONTH - 96)) | (1 << (SqlBaseParser.NAME - 96)) | (1 << (SqlBaseParser.NFC - 96)) | (1 << (SqlBaseParser.NFD - 96)) | (1 << (SqlBaseParser.NFKC - 96)) | (1 << (SqlBaseParser.NFKD - 96)) | (1 << (SqlBaseParser.NO - 96)) | (1 << (SqlBaseParser.NONE - 96)) | (1 << (SqlBaseParser.NULLIF - 96)) | (1 << (SqlBaseParser.NULLS - 96)))) !== 0) || ((((_la - 128)) & ~0x1F) === 0 && ((1 << (_la - 128)) & ((1 << (SqlBaseParser.OFFSET - 128)) | (1 << (SqlBaseParser.ONLY - 128)) | (1 << (SqlBaseParser.OPTION - 128)) | (1 << (SqlBaseParser.ORDINALITY - 128)) | (1 << (SqlBaseParser.OUTPUT - 128)) | (1 << (SqlBaseParser.OVER - 128)) | (1 << (SqlBaseParser.PARTITION - 128)) | (1 << (SqlBaseParser.PARTITIONS - 128)) | (1 << (SqlBaseParser.POSITION - 128)) | (1 << (SqlBaseParser.PRECEDING - 128)) | (1 << (SqlBaseParser.PRIVILEGES - 128)) | (1 << (SqlBaseParser.PROPERTIES - 128)) | (1 << (SqlBaseParser.RANGE - 128)) | (1 << (SqlBaseParser.READ - 128)) | (1 << (SqlBaseParser.REFRESH - 128)) | (1 << (SqlBaseParser.RENAME - 128)) | (1 << (SqlBaseParser.REPEATABLE - 128)) | (1 << (SqlBaseParser.REPLACE - 128)) | (1 << (SqlBaseParser.RESET - 128)) | (1 << (SqlBaseParser.RESPECT - 128)) | (1 << (SqlBaseParser.RESTRICT - 128)) | (1 << (SqlBaseParser.RETURN - 128)) | (1 << (SqlBaseParser.RETURNS - 128)) | (1 << (SqlBaseParser.REVOKE - 128)) | (1 << (SqlBaseParser.ROLE - 128)))) !== 0) || ((((_la - 160)) & ~0x1F) === 0 && ((1 << (_la - 160)) & ((1 << (SqlBaseParser.ROLES - 160)) | (1 << (SqlBaseParser.ROLLBACK - 160)) | (1 << (SqlBaseParser.ROW - 160)) | (1 << (SqlBaseParser.ROWS - 160)) | (1 << (SqlBaseParser.SCHEMA - 160)) | (1 << (SqlBaseParser.SCHEMAS - 160)) | (1 << (SqlBaseParser.SECOND - 160)) | (1 << (SqlBaseParser.SECURITY - 160)) | (1 << (SqlBaseParser.SERIALIZABLE - 160)) | (1 << (SqlBaseParser.SESSION - 160)) | (1 << (SqlBaseParser.SET - 160)) | (1 << (SqlBaseParser.SETS - 160)) | (1 << (SqlBaseParser.SHOW - 160)) | (1 << (SqlBaseParser.SOME - 160)) | (1 << (SqlBaseParser.SQL - 160)) | (1 << (SqlBaseParser.START - 160)) | (1 << (SqlBaseParser.STATS - 160)) | (1 << (SqlBaseParser.SUBSTRING - 160)) | (1 << (SqlBaseParser.SYSTEM - 160)) | (1 << (SqlBaseParser.TABLES - 160)) | (1 << (SqlBaseParser.TABLESAMPLE - 160)) | (1 << (SqlBaseParser.TEMPORARY - 160)) | (1 << (SqlBaseParser.TEXT - 160)) | (1 << (SqlBaseParser.TIME - 160)) | (1 << (SqlBaseParser.TIMESTAMP - 160)) | (1 << (SqlBaseParser.TO - 160)) | (1 << (SqlBaseParser.TRANSACTION - 160)))) !== 0) || ((((_la - 192)) & ~0x1F) === 0 && ((1 << (_la - 192)) & ((1 << (SqlBaseParser.TRY_CAST - 192)) | (1 << (SqlBaseParser.TYPE - 192)) | (1 << (SqlBaseParser.UNBOUNDED - 192)) | (1 << (SqlBaseParser.UNCOMMITTED - 192)) | (1 << (SqlBaseParser.USE - 192)) | (1 << (SqlBaseParser.USER - 192)) | (1 << (SqlBaseParser.VALIDATE - 192)) | (1 << (SqlBaseParser.VERBOSE - 192)) | (1 << (SqlBaseParser.VIEW - 192)) | (1 << (SqlBaseParser.WORK - 192)) | (1 << (SqlBaseParser.WRITE - 192)) | (1 << (SqlBaseParser.YEAR - 192)) | (1 << (SqlBaseParser.ZONE - 192)))) !== 0))) {
                    this._errHandler.recoverInline(this);
                }
                else {
                    if (this._input.LA(1) === Token_1.Token.EOF) {
                        this.matchedEOF = true;
                    }
                    this._errHandler.reportMatch(this);
                    this.consume();
                }
            }
        }
        catch (re) {
            if (re instanceof RecognitionException_1.RecognitionException) {
                _localctx.exception = re;
                this._errHandler.reportError(this, re);
                this._errHandler.recover(this, re);
            }
            else {
                throw re;
            }
        }
        finally {
            this.exitRule();
        }
        return _localctx;
    }
    sempred(_localctx, ruleIndex, predIndex) {
        switch (ruleIndex) {
            case 24:
                return this.queryTerm_sempred(_localctx, predIndex);
            case 34:
                return this.relation_sempred(_localctx, predIndex);
            case 46:
                return this.booleanExpression_sempred(_localctx, predIndex);
            case 48:
                return this.valueExpression_sempred(_localctx, predIndex);
            case 49:
                return this.primaryExpression_sempred(_localctx, predIndex);
            case 60:
                return this.type_sempred(_localctx, predIndex);
        }
        return true;
    }
    queryTerm_sempred(_localctx, predIndex) {
        switch (predIndex) {
            case 0:
                return this.precpred(this._ctx, 2);
            case 1:
                return this.precpred(this._ctx, 1);
        }
        return true;
    }
    relation_sempred(_localctx, predIndex) {
        switch (predIndex) {
            case 2:
                return this.precpred(this._ctx, 2);
        }
        return true;
    }
    booleanExpression_sempred(_localctx, predIndex) {
        switch (predIndex) {
            case 3:
                return this.precpred(this._ctx, 2);
            case 4:
                return this.precpred(this._ctx, 1);
        }
        return true;
    }
    valueExpression_sempred(_localctx, predIndex) {
        switch (predIndex) {
            case 5:
                return this.precpred(this._ctx, 3);
            case 6:
                return this.precpred(this._ctx, 2);
            case 7:
                return this.precpred(this._ctx, 1);
            case 8:
                return this.precpred(this._ctx, 5);
        }
        return true;
    }
    primaryExpression_sempred(_localctx, predIndex) {
        switch (predIndex) {
            case 9:
                return this.precpred(this._ctx, 14);
            case 10:
                return this.precpred(this._ctx, 12);
        }
        return true;
    }
    type_sempred(_localctx, predIndex) {
        switch (predIndex) {
            case 11:
                return this.precpred(this._ctx, 6);
        }
        return true;
    }
    static get _ATN() {
        if (!SqlBaseParser.__ATN) {
            SqlBaseParser.__ATN = new ATNDeserializer_1.ATNDeserializer().deserialize(Utils.toCharArray(SqlBaseParser._serializedATN));
        }
        return SqlBaseParser.__ATN;
    }
}
exports.SqlBaseParser = SqlBaseParser;
SqlBaseParser.T__0 = 1;
SqlBaseParser.T__1 = 2;
SqlBaseParser.T__2 = 3;
SqlBaseParser.T__3 = 4;
SqlBaseParser.T__4 = 5;
SqlBaseParser.T__5 = 6;
SqlBaseParser.T__6 = 7;
SqlBaseParser.T__7 = 8;
SqlBaseParser.T__8 = 9;
SqlBaseParser.ADD = 10;
SqlBaseParser.ADMIN = 11;
SqlBaseParser.ALL = 12;
SqlBaseParser.ALTER = 13;
SqlBaseParser.ANALYZE = 14;
SqlBaseParser.AND = 15;
SqlBaseParser.ANY = 16;
SqlBaseParser.ARRAY = 17;
SqlBaseParser.AS = 18;
SqlBaseParser.ASC = 19;
SqlBaseParser.AT = 20;
SqlBaseParser.BERNOULLI = 21;
SqlBaseParser.BETWEEN = 22;
SqlBaseParser.BY = 23;
SqlBaseParser.CALL = 24;
SqlBaseParser.CALLED = 25;
SqlBaseParser.CASCADE = 26;
SqlBaseParser.CASE = 27;
SqlBaseParser.CAST = 28;
SqlBaseParser.CATALOGS = 29;
SqlBaseParser.COLUMN = 30;
SqlBaseParser.COLUMNS = 31;
SqlBaseParser.COMMENT = 32;
SqlBaseParser.COMMIT = 33;
SqlBaseParser.COMMITTED = 34;
SqlBaseParser.CONSTRAINT = 35;
SqlBaseParser.CREATE = 36;
SqlBaseParser.CROSS = 37;
SqlBaseParser.CUBE = 38;
SqlBaseParser.CURRENT = 39;
SqlBaseParser.CURRENT_DATE = 40;
SqlBaseParser.CURRENT_ROLE = 41;
SqlBaseParser.CURRENT_TIME = 42;
SqlBaseParser.CURRENT_TIMESTAMP = 43;
SqlBaseParser.CURRENT_USER = 44;
SqlBaseParser.DATA = 45;
SqlBaseParser.DATE = 46;
SqlBaseParser.DAY = 47;
SqlBaseParser.DEALLOCATE = 48;
SqlBaseParser.DEFINER = 49;
SqlBaseParser.DELETE = 50;
SqlBaseParser.DESC = 51;
SqlBaseParser.DESCRIBE = 52;
SqlBaseParser.DETERMINISTIC = 53;
SqlBaseParser.DISTINCT = 54;
SqlBaseParser.DISTRIBUTED = 55;
SqlBaseParser.DROP = 56;
SqlBaseParser.ELSE = 57;
SqlBaseParser.END = 58;
SqlBaseParser.ESCAPE = 59;
SqlBaseParser.EXCEPT = 60;
SqlBaseParser.EXCLUDING = 61;
SqlBaseParser.EXECUTE = 62;
SqlBaseParser.EXISTS = 63;
SqlBaseParser.EXPLAIN = 64;
SqlBaseParser.EXTRACT = 65;
SqlBaseParser.EXTERNAL = 66;
SqlBaseParser.FALSE = 67;
SqlBaseParser.FILTER = 68;
SqlBaseParser.FIRST = 69;
SqlBaseParser.FOLLOWING = 70;
SqlBaseParser.FOR = 71;
SqlBaseParser.FORMAT = 72;
SqlBaseParser.FROM = 73;
SqlBaseParser.FULL = 74;
SqlBaseParser.FUNCTION = 75;
SqlBaseParser.FUNCTIONS = 76;
SqlBaseParser.GRANT = 77;
SqlBaseParser.GRANTED = 78;
SqlBaseParser.GRANTS = 79;
SqlBaseParser.GRAPHVIZ = 80;
SqlBaseParser.GROUP = 81;
SqlBaseParser.GROUPING = 82;
SqlBaseParser.HAVING = 83;
SqlBaseParser.HOUR = 84;
SqlBaseParser.IF = 85;
SqlBaseParser.IGNORE = 86;
SqlBaseParser.IN = 87;
SqlBaseParser.INCLUDING = 88;
SqlBaseParser.INNER = 89;
SqlBaseParser.INPUT = 90;
SqlBaseParser.INSERT = 91;
SqlBaseParser.INTERSECT = 92;
SqlBaseParser.INTERVAL = 93;
SqlBaseParser.INTO = 94;
SqlBaseParser.INVOKER = 95;
SqlBaseParser.IO = 96;
SqlBaseParser.IS = 97;
SqlBaseParser.ISOLATION = 98;
SqlBaseParser.JSON = 99;
SqlBaseParser.JOIN = 100;
SqlBaseParser.LANGUAGE = 101;
SqlBaseParser.LAST = 102;
SqlBaseParser.LATERAL = 103;
SqlBaseParser.LEFT = 104;
SqlBaseParser.LEVEL = 105;
SqlBaseParser.LIKE = 106;
SqlBaseParser.LIMIT = 107;
SqlBaseParser.LOCALTIME = 108;
SqlBaseParser.LOCALTIMESTAMP = 109;
SqlBaseParser.LOGICAL = 110;
SqlBaseParser.MAP = 111;
SqlBaseParser.MATERIALIZED = 112;
SqlBaseParser.MINUTE = 113;
SqlBaseParser.MONTH = 114;
SqlBaseParser.NAME = 115;
SqlBaseParser.NATURAL = 116;
SqlBaseParser.NFC = 117;
SqlBaseParser.NFD = 118;
SqlBaseParser.NFKC = 119;
SqlBaseParser.NFKD = 120;
SqlBaseParser.NO = 121;
SqlBaseParser.NONE = 122;
SqlBaseParser.NORMALIZE = 123;
SqlBaseParser.NOT = 124;
SqlBaseParser.NULL = 125;
SqlBaseParser.NULLIF = 126;
SqlBaseParser.NULLS = 127;
SqlBaseParser.OFFSET = 128;
SqlBaseParser.ON = 129;
SqlBaseParser.ONLY = 130;
SqlBaseParser.OPTION = 131;
SqlBaseParser.OR = 132;
SqlBaseParser.ORDER = 133;
SqlBaseParser.ORDINALITY = 134;
SqlBaseParser.OUTER = 135;
SqlBaseParser.OUTPUT = 136;
SqlBaseParser.OVER = 137;
SqlBaseParser.PARTITION = 138;
SqlBaseParser.PARTITIONS = 139;
SqlBaseParser.POSITION = 140;
SqlBaseParser.PRECEDING = 141;
SqlBaseParser.PREPARE = 142;
SqlBaseParser.PRIVILEGES = 143;
SqlBaseParser.PROPERTIES = 144;
SqlBaseParser.RANGE = 145;
SqlBaseParser.READ = 146;
SqlBaseParser.RECURSIVE = 147;
SqlBaseParser.REFRESH = 148;
SqlBaseParser.RENAME = 149;
SqlBaseParser.REPEATABLE = 150;
SqlBaseParser.REPLACE = 151;
SqlBaseParser.RESET = 152;
SqlBaseParser.RESPECT = 153;
SqlBaseParser.RESTRICT = 154;
SqlBaseParser.RETURN = 155;
SqlBaseParser.RETURNS = 156;
SqlBaseParser.REVOKE = 157;
SqlBaseParser.RIGHT = 158;
SqlBaseParser.ROLE = 159;
SqlBaseParser.ROLES = 160;
SqlBaseParser.ROLLBACK = 161;
SqlBaseParser.ROLLUP = 162;
SqlBaseParser.ROW = 163;
SqlBaseParser.ROWS = 164;
SqlBaseParser.SCHEMA = 165;
SqlBaseParser.SCHEMAS = 166;
SqlBaseParser.SECOND = 167;
SqlBaseParser.SECURITY = 168;
SqlBaseParser.SELECT = 169;
SqlBaseParser.SERIALIZABLE = 170;
SqlBaseParser.SESSION = 171;
SqlBaseParser.SET = 172;
SqlBaseParser.SETS = 173;
SqlBaseParser.SHOW = 174;
SqlBaseParser.SOME = 175;
SqlBaseParser.SQL = 176;
SqlBaseParser.START = 177;
SqlBaseParser.STATS = 178;
SqlBaseParser.SUBSTRING = 179;
SqlBaseParser.SYSTEM = 180;
SqlBaseParser.TABLE = 181;
SqlBaseParser.TABLES = 182;
SqlBaseParser.TABLESAMPLE = 183;
SqlBaseParser.TEMPORARY = 184;
SqlBaseParser.TEXT = 185;
SqlBaseParser.THEN = 186;
SqlBaseParser.TIME = 187;
SqlBaseParser.TIMESTAMP = 188;
SqlBaseParser.TO = 189;
SqlBaseParser.TRANSACTION = 190;
SqlBaseParser.TRUE = 191;
SqlBaseParser.TRY_CAST = 192;
SqlBaseParser.TYPE = 193;
SqlBaseParser.UESCAPE = 194;
SqlBaseParser.UNBOUNDED = 195;
SqlBaseParser.UNCOMMITTED = 196;
SqlBaseParser.UNION = 197;
SqlBaseParser.UNNEST = 198;
SqlBaseParser.USE = 199;
SqlBaseParser.UPDATE = 200;
SqlBaseParser.USER = 201;
SqlBaseParser.USING = 202;
SqlBaseParser.VALIDATE = 203;
SqlBaseParser.VALUES = 204;
SqlBaseParser.VERBOSE = 205;
SqlBaseParser.VIEW = 206;
SqlBaseParser.WHEN = 207;
SqlBaseParser.WHERE = 208;
SqlBaseParser.WITH = 209;
SqlBaseParser.WORK = 210;
SqlBaseParser.WRITE = 211;
SqlBaseParser.YEAR = 212;
SqlBaseParser.ZONE = 213;
SqlBaseParser.EQ = 214;
SqlBaseParser.NEQ = 215;
SqlBaseParser.LT = 216;
SqlBaseParser.LTE = 217;
SqlBaseParser.GT = 218;
SqlBaseParser.GTE = 219;
SqlBaseParser.PLUS = 220;
SqlBaseParser.MINUS = 221;
SqlBaseParser.ASTERISK = 222;
SqlBaseParser.SLASH = 223;
SqlBaseParser.PERCENT = 224;
SqlBaseParser.CONCAT = 225;
SqlBaseParser.STRING = 226;
SqlBaseParser.UNICODE_STRING = 227;
SqlBaseParser.BINARY_LITERAL = 228;
SqlBaseParser.INTEGER_VALUE = 229;
SqlBaseParser.DECIMAL_VALUE = 230;
SqlBaseParser.DOUBLE_VALUE = 231;
SqlBaseParser.IDENTIFIER = 232;
SqlBaseParser.DIGIT_IDENTIFIER = 233;
SqlBaseParser.QUOTED_IDENTIFIER = 234;
SqlBaseParser.BACKQUOTED_IDENTIFIER = 235;
SqlBaseParser.TIME_WITH_TIME_ZONE = 236;
SqlBaseParser.TIMESTAMP_WITH_TIME_ZONE = 237;
SqlBaseParser.DOUBLE_PRECISION = 238;
SqlBaseParser.SIMPLE_COMMENT = 239;
SqlBaseParser.BRACKETED_COMMENT = 240;
SqlBaseParser.WS = 241;
SqlBaseParser.UNRECOGNIZED = 242;
SqlBaseParser.DELIMITER = 243;
SqlBaseParser.RULE_singleStatement = 0;
SqlBaseParser.RULE_standaloneExpression = 1;
SqlBaseParser.RULE_standaloneRoutineBody = 2;
SqlBaseParser.RULE_statement = 3;
SqlBaseParser.RULE_query = 4;
SqlBaseParser.RULE_queryWith = 5;
SqlBaseParser.RULE_tableElement = 6;
SqlBaseParser.RULE_columnDefinition = 7;
SqlBaseParser.RULE_likeClause = 8;
SqlBaseParser.RULE_properties = 9;
SqlBaseParser.RULE_property = 10;
SqlBaseParser.RULE_sqlParameterDeclaration = 11;
SqlBaseParser.RULE_routineCharacteristics = 12;
SqlBaseParser.RULE_routineCharacteristic = 13;
SqlBaseParser.RULE_alterRoutineCharacteristics = 14;
SqlBaseParser.RULE_alterRoutineCharacteristic = 15;
SqlBaseParser.RULE_routineBody = 16;
SqlBaseParser.RULE_returnStatement = 17;
SqlBaseParser.RULE_externalBodyReference = 18;
SqlBaseParser.RULE_language = 19;
SqlBaseParser.RULE_determinism = 20;
SqlBaseParser.RULE_nullCallClause = 21;
SqlBaseParser.RULE_externalRoutineName = 22;
SqlBaseParser.RULE_queryNoWith = 23;
SqlBaseParser.RULE_queryTerm = 24;
SqlBaseParser.RULE_queryPrimary = 25;
SqlBaseParser.RULE_sortItem = 26;
SqlBaseParser.RULE_querySpecification = 27;
SqlBaseParser.RULE_groupBy = 28;
SqlBaseParser.RULE_groupingElement = 29;
SqlBaseParser.RULE_groupingSet = 30;
SqlBaseParser.RULE_namedQuery = 31;
SqlBaseParser.RULE_setQuantifier = 32;
SqlBaseParser.RULE_selectItem = 33;
SqlBaseParser.RULE_relation = 34;
SqlBaseParser.RULE_joinType = 35;
SqlBaseParser.RULE_joinCriteria = 36;
SqlBaseParser.RULE_sampledRelation = 37;
SqlBaseParser.RULE_sampleType = 38;
SqlBaseParser.RULE_aliasedRelation = 39;
SqlBaseParser.RULE_columnAliases = 40;
SqlBaseParser.RULE_relationPrimary = 41;
SqlBaseParser.RULE_expression = 42;
SqlBaseParser.RULE_whereExpression = 43;
SqlBaseParser.RULE_updateExpression = 44;
SqlBaseParser.RULE_havingExpression = 45;
SqlBaseParser.RULE_booleanExpression = 46;
SqlBaseParser.RULE_predicate = 47;
SqlBaseParser.RULE_valueExpression = 48;
SqlBaseParser.RULE_primaryExpression = 49;
SqlBaseParser.RULE_string = 50;
SqlBaseParser.RULE_nullTreatment = 51;
SqlBaseParser.RULE_timeZoneSpecifier = 52;
SqlBaseParser.RULE_comparisonOperator = 53;
SqlBaseParser.RULE_comparisonQuantifier = 54;
SqlBaseParser.RULE_booleanValue = 55;
SqlBaseParser.RULE_interval = 56;
SqlBaseParser.RULE_intervalField = 57;
SqlBaseParser.RULE_normalForm = 58;
SqlBaseParser.RULE_types = 59;
SqlBaseParser.RULE_type = 60;
SqlBaseParser.RULE_typeParameter = 61;
SqlBaseParser.RULE_baseType = 62;
SqlBaseParser.RULE_whenClause = 63;
SqlBaseParser.RULE_filter = 64;
SqlBaseParser.RULE_over = 65;
SqlBaseParser.RULE_windowFrame = 66;
SqlBaseParser.RULE_frameBound = 67;
SqlBaseParser.RULE_explainOption = 68;
SqlBaseParser.RULE_transactionMode = 69;
SqlBaseParser.RULE_levelOfIsolation = 70;
SqlBaseParser.RULE_callArgument = 71;
SqlBaseParser.RULE_privilege = 72;
SqlBaseParser.RULE_qualifiedName = 73;
SqlBaseParser.RULE_tableNameWithAliases = 74;
SqlBaseParser.RULE_grantor = 75;
SqlBaseParser.RULE_principal = 76;
SqlBaseParser.RULE_roles = 77;
SqlBaseParser.RULE_identifier = 78;
SqlBaseParser.RULE_number = 79;
SqlBaseParser.RULE_nonReserved = 80;
// tslint:disable:no-trailing-whitespace
SqlBaseParser.ruleNames = [
    "singleStatement", "standaloneExpression", "standaloneRoutineBody", "statement",
    "query", "queryWith", "tableElement", "columnDefinition", "likeClause",
    "properties", "property", "sqlParameterDeclaration", "routineCharacteristics",
    "routineCharacteristic", "alterRoutineCharacteristics", "alterRoutineCharacteristic",
    "routineBody", "returnStatement", "externalBodyReference", "language",
    "determinism", "nullCallClause", "externalRoutineName", "queryNoWith",
    "queryTerm", "queryPrimary", "sortItem", "querySpecification", "groupBy",
    "groupingElement", "groupingSet", "namedQuery", "setQuantifier", "selectItem",
    "relation", "joinType", "joinCriteria", "sampledRelation", "sampleType",
    "aliasedRelation", "columnAliases", "relationPrimary", "expression", "whereExpression",
    "updateExpression", "havingExpression", "booleanExpression", "predicate",
    "valueExpression", "primaryExpression", "string", "nullTreatment", "timeZoneSpecifier",
    "comparisonOperator", "comparisonQuantifier", "booleanValue", "interval",
    "intervalField", "normalForm", "types", "type", "typeParameter", "baseType",
    "whenClause", "filter", "over", "windowFrame", "frameBound", "explainOption",
    "transactionMode", "levelOfIsolation", "callArgument", "privilege", "qualifiedName",
    "tableNameWithAliases", "grantor", "principal", "roles", "identifier",
    "number", "nonReserved",
];
SqlBaseParser._LITERAL_NAMES = [
    undefined, "'.'", "'('", "')'", "','", "'?'", "'->'", "'['", "']'", "'=>'",
    "'ADD'", "'ADMIN'", "'ALL'", "'ALTER'", "'ANALYZE'", "'AND'", "'ANY'",
    "'ARRAY'", "'AS'", "'ASC'", "'AT'", "'BERNOULLI'", "'BETWEEN'", "'BY'",
    "'CALL'", "'CALLED'", "'CASCADE'", "'CASE'", "'CAST'", "'CATALOGS'", "'COLUMN'",
    "'COLUMNS'", "'COMMENT'", "'COMMIT'", "'COMMITTED'", "'CONSTRAINT'", "'CREATE'",
    "'CROSS'", "'CUBE'", "'CURRENT'", "'CURRENT_DATE'", "'CURRENT_ROLE'",
    "'CURRENT_TIME'", "'CURRENT_TIMESTAMP'", "'CURRENT_USER'", "'DATA'", "'DATE'",
    "'DAY'", "'DEALLOCATE'", "'DEFINER'", "'DELETE'", "'DESC'", "'DESCRIBE'",
    "'DETERMINISTIC'", "'DISTINCT'", "'DISTRIBUTED'", "'DROP'", "'ELSE'",
    "'END'", "'ESCAPE'", "'EXCEPT'", "'EXCLUDING'", "'EXECUTE'", "'EXISTS'",
    "'EXPLAIN'", "'EXTRACT'", "'EXTERNAL'", "'FALSE'", "'FILTER'", "'FIRST'",
    "'FOLLOWING'", "'FOR'", "'FORMAT'", "'FROM'", "'FULL'", "'FUNCTION'",
    "'FUNCTIONS'", "'GRANT'", "'GRANTED'", "'GRANTS'", "'GRAPHVIZ'", "'GROUP'",
    "'GROUPING'", "'HAVING'", "'HOUR'", "'IF'", "'IGNORE'", "'IN'", "'INCLUDING'",
    "'INNER'", "'INPUT'", "'INSERT'", "'INTERSECT'", "'INTERVAL'", "'INTO'",
    "'INVOKER'", "'IO'", "'IS'", "'ISOLATION'", "'JSON'", "'JOIN'", "'LANGUAGE'",
    "'LAST'", "'LATERAL'", "'LEFT'", "'LEVEL'", "'LIKE'", "'LIMIT'", "'LOCALTIME'",
    "'LOCALTIMESTAMP'", "'LOGICAL'", "'MAP'", "'MATERIALIZED'", "'MINUTE'",
    "'MONTH'", "'NAME'", "'NATURAL'", "'NFC'", "'NFD'", "'NFKC'", "'NFKD'",
    "'NO'", "'NONE'", "'NORMALIZE'", "'NOT'", "'NULL'", "'NULLIF'", "'NULLS'",
    "'OFFSET'", "'ON'", "'ONLY'", "'OPTION'", "'OR'", "'ORDER'", "'ORDINALITY'",
    "'OUTER'", "'OUTPUT'", "'OVER'", "'PARTITION'", "'PARTITIONS'", "'POSITION'",
    "'PRECEDING'", "'PREPARE'", "'PRIVILEGES'", "'PROPERTIES'", "'RANGE'",
    "'READ'", "'RECURSIVE'", "'REFRESH'", "'RENAME'", "'REPEATABLE'", "'REPLACE'",
    "'RESET'", "'RESPECT'", "'RESTRICT'", "'RETURN'", "'RETURNS'", "'REVOKE'",
    "'RIGHT'", "'ROLE'", "'ROLES'", "'ROLLBACK'", "'ROLLUP'", "'ROW'", "'ROWS'",
    "'SCHEMA'", "'SCHEMAS'", "'SECOND'", "'SECURITY'", "'SELECT'", "'SERIALIZABLE'",
    "'SESSION'", "'SET'", "'SETS'", "'SHOW'", "'SOME'", "'SQL'", "'START'",
    "'STATS'", "'SUBSTRING'", "'SYSTEM'", "'TABLE'", "'TABLES'", "'TABLESAMPLE'",
    "'TEMPORARY'", "'TEXT'", "'THEN'", "'TIME'", "'TIMESTAMP'", "'TO'", "'TRANSACTION'",
    "'TRUE'", "'TRY_CAST'", "'TYPE'", "'UESCAPE'", "'UNBOUNDED'", "'UNCOMMITTED'",
    "'UNION'", "'UNNEST'", "'USE'", "'UPDATE'", "'USER'", "'USING'", "'VALIDATE'",
    "'VALUES'", "'VERBOSE'", "'VIEW'", "'WHEN'", "'WHERE'", "'WITH'", "'WORK'",
    "'WRITE'", "'YEAR'", "'ZONE'", "'='", undefined, "'<'", "'<='", "'>'",
    "'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'||'",
];
SqlBaseParser._SYMBOLIC_NAMES = [
    undefined, undefined, undefined, undefined, undefined, undefined, undefined,
    undefined, undefined, undefined, "ADD", "ADMIN", "ALL", "ALTER", "ANALYZE",
    "AND", "ANY", "ARRAY", "AS", "ASC", "AT", "BERNOULLI", "BETWEEN", "BY",
    "CALL", "CALLED", "CASCADE", "CASE", "CAST", "CATALOGS", "COLUMN", "COLUMNS",
    "COMMENT", "COMMIT", "COMMITTED", "CONSTRAINT", "CREATE", "CROSS", "CUBE",
    "CURRENT", "CURRENT_DATE", "CURRENT_ROLE", "CURRENT_TIME", "CURRENT_TIMESTAMP",
    "CURRENT_USER", "DATA", "DATE", "DAY", "DEALLOCATE", "DEFINER", "DELETE",
    "DESC", "DESCRIBE", "DETERMINISTIC", "DISTINCT", "DISTRIBUTED", "DROP",
    "ELSE", "END", "ESCAPE", "EXCEPT", "EXCLUDING", "EXECUTE", "EXISTS", "EXPLAIN",
    "EXTRACT", "EXTERNAL", "FALSE", "FILTER", "FIRST", "FOLLOWING", "FOR",
    "FORMAT", "FROM", "FULL", "FUNCTION", "FUNCTIONS", "GRANT", "GRANTED",
    "GRANTS", "GRAPHVIZ", "GROUP", "GROUPING", "HAVING", "HOUR", "IF", "IGNORE",
    "IN", "INCLUDING", "INNER", "INPUT", "INSERT", "INTERSECT", "INTERVAL",
    "INTO", "INVOKER", "IO", "IS", "ISOLATION", "JSON", "JOIN", "LANGUAGE",
    "LAST", "LATERAL", "LEFT", "LEVEL", "LIKE", "LIMIT", "LOCALTIME", "LOCALTIMESTAMP",
    "LOGICAL", "MAP", "MATERIALIZED", "MINUTE", "MONTH", "NAME", "NATURAL",
    "NFC", "NFD", "NFKC", "NFKD", "NO", "NONE", "NORMALIZE", "NOT", "NULL",
    "NULLIF", "NULLS", "OFFSET", "ON", "ONLY", "OPTION", "OR", "ORDER", "ORDINALITY",
    "OUTER", "OUTPUT", "OVER", "PARTITION", "PARTITIONS", "POSITION", "PRECEDING",
    "PREPARE", "PRIVILEGES", "PROPERTIES", "RANGE", "READ", "RECURSIVE", "REFRESH",
    "RENAME", "REPEATABLE", "REPLACE", "RESET", "RESPECT", "RESTRICT", "RETURN",
    "RETURNS", "REVOKE", "RIGHT", "ROLE", "ROLES", "ROLLBACK", "ROLLUP", "ROW",
    "ROWS", "SCHEMA", "SCHEMAS", "SECOND", "SECURITY", "SELECT", "SERIALIZABLE",
    "SESSION", "SET", "SETS", "SHOW", "SOME", "SQL", "START", "STATS", "SUBSTRING",
    "SYSTEM", "TABLE", "TABLES", "TABLESAMPLE", "TEMPORARY", "TEXT", "THEN",
    "TIME", "TIMESTAMP", "TO", "TRANSACTION", "TRUE", "TRY_CAST", "TYPE",
    "UESCAPE", "UNBOUNDED", "UNCOMMITTED", "UNION", "UNNEST", "USE", "UPDATE",
    "USER", "USING", "VALIDATE", "VALUES", "VERBOSE", "VIEW", "WHEN", "WHERE",
    "WITH", "WORK", "WRITE", "YEAR", "ZONE", "EQ", "NEQ", "LT", "LTE", "GT",
    "GTE", "PLUS", "MINUS", "ASTERISK", "SLASH", "PERCENT", "CONCAT", "STRING",
    "UNICODE_STRING", "BINARY_LITERAL", "INTEGER_VALUE", "DECIMAL_VALUE",
    "DOUBLE_VALUE", "IDENTIFIER", "DIGIT_IDENTIFIER", "QUOTED_IDENTIFIER",
    "BACKQUOTED_IDENTIFIER", "TIME_WITH_TIME_ZONE", "TIMESTAMP_WITH_TIME_ZONE",
    "DOUBLE_PRECISION", "SIMPLE_COMMENT", "BRACKETED_COMMENT", "WS", "UNRECOGNIZED",
    "DELIMITER",
];
SqlBaseParser.VOCABULARY = new VocabularyImpl_1.VocabularyImpl(SqlBaseParser._LITERAL_NAMES, SqlBaseParser._SYMBOLIC_NAMES, []);
SqlBaseParser._serializedATNSegments = 4;
SqlBaseParser._serializedATNSegment0 = "\x03\uC91D\uCABA\u058D\uAFBA\u4F53\u0607\uEA8B\uC241\x03\xF5\u0767\x04" +
    "\x02\t\x02\x04\x03\t\x03\x04\x04\t\x04\x04\x05\t\x05\x04\x06\t\x06\x04" +
    "\x07\t\x07\x04\b\t\b\x04\t\t\t\x04\n\t\n\x04\v\t\v\x04\f\t\f\x04\r\t\r" +
    "\x04\x0E\t\x0E\x04\x0F\t\x0F\x04\x10\t\x10\x04\x11\t\x11\x04\x12\t\x12" +
    "\x04\x13\t\x13\x04\x14\t\x14\x04\x15\t\x15\x04\x16\t\x16\x04\x17\t\x17" +
    "\x04\x18\t\x18\x04\x19\t\x19\x04\x1A\t\x1A\x04\x1B\t\x1B\x04\x1C\t\x1C" +
    "\x04\x1D\t\x1D\x04\x1E\t\x1E\x04\x1F\t\x1F\x04 \t \x04!\t!\x04\"\t\"\x04" +
    "#\t#\x04$\t$\x04%\t%\x04&\t&\x04\'\t\'\x04(\t(\x04)\t)\x04*\t*\x04+\t" +
    "+\x04,\t,\x04-\t-\x04.\t.\x04/\t/\x040\t0\x041\t1\x042\t2\x043\t3\x04" +
    "4\t4\x045\t5\x046\t6\x047\t7\x048\t8\x049\t9\x04:\t:\x04;\t;\x04<\t<\x04" +
    "=\t=\x04>\t>\x04?\t?\x04@\t@\x04A\tA\x04B\tB\x04C\tC\x04D\tD\x04E\tE\x04" +
    "F\tF\x04G\tG\x04H\tH\x04I\tI\x04J\tJ\x04K\tK\x04L\tL\x04M\tM\x04N\tN\x04" +
    "O\tO\x04P\tP\x04Q\tQ\x04R\tR\x03\x02\x03\x02\x03\x02\x03\x03\x03\x03\x03" +
    "\x03\x03\x04\x03\x04\x03\x04\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03" +
    "\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x05\x05\xBB" +
    "\n\x05\x03\x05\x03\x05\x03\x05\x05\x05\xC0\n\x05\x03\x05\x03\x05\x03\x05" +
    "\x03\x05\x05\x05\xC6\n\x05\x03\x05\x03\x05\x05\x05\xCA\n\x05\x03\x05\x03" +
    "\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03" +
    "\x05\x03\x05\x05\x05\xD8\n\x05\x03\x05\x03\x05\x05\x05\xDC\n\x05\x03\x05" +
    "\x03\x05\x05\x05\xE0\n\x05\x03\x05\x03\x05\x05\x05\xE4\n\x05\x03\x05\x03" +
    "\x05\x03\x05\x03\x05\x03\x05\x03\x05\x05\x05\xEC\n\x05\x03\x05\x03\x05" +
    "\x05\x05\xF0\n\x05\x03\x05\x05\x05\xF3\n\x05\x03\x05\x03\x05\x03\x05\x03" +
    "\x05\x03\x05\x05\x05\xFA\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05" +
    "\x07\x05\u0101\n\x05\f\x05\x0E\x05\u0104\v\x05\x03\x05\x03\x05\x03\x05" +
    "\x05\x05\u0109\n\x05\x03\x05\x03\x05\x05\x05\u010D\n\x05\x03\x05\x03\x05" +
    "\x03\x05\x03\x05\x05\x05\u0113\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03" +
    "\x05\x05\x05\u011A\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05" +
    "\x03\x05\x03\x05\x07\x05\u0124\n\x05\f\x05\x0E\x05\u0127\v\x05\x03\x05" +
    "\x03\x05\x05\x05\u012B\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x05" +
    "\x05\u0132\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x05\x05\u0138\n\x05\x03" +
    "\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x05" +
    "\x05\u0143\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x05\x05\u014A" +
    "\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05" +
    "\x05\x05\u0154\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x05\x05\u015B" +
    "\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x05\x05\u0163\n" +
    "\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x05\x05\u016B\n\x05" +
    "\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x05\x05\u0173\n\x05\x03" +
    "\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x07\x05\u017D" +
    "\n\x05\f\x05\x0E\x05\u0180\v\x05\x03\x05\x03\x05\x03\x05\x05\x05\u0185" +
    "\n\x05\x03\x05\x03\x05\x03\x05\x05\x05\u018A\n\x05\x03\x05\x03\x05\x03" +
    "\x05\x03\x05\x05\x05\u0190\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05" +
    "\x03\x05\x03\x05\x05\x05\u0199\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03" +
    "\x05\x03\x05\x03\x05\x05\x05\u01A2\n\x05\x03\x05\x03\x05\x03\x05\x05\x05" +
    "\u01A7\n\x05\x03\x05\x03\x05\x05\x05\u01AB\n\x05\x03\x05\x03\x05\x03\x05" +
    "\x03\x05\x03\x05\x03\x05\x05\x05\u01B3\n\x05\x03\x05\x03\x05\x03\x05\x03" +
    "\x05\x03\x05\x05\x05\u01BA\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05" +
    "\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x05\x05\u01C7\n\x05\x03" +
    "\x05\x05\x05\u01CA\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05" +
    "\x07\x05\u01D2\n\x05\f\x05\x0E\x05\u01D5\v\x05\x05\x05\u01D7\n\x05\x03" +
    "\x05\x03\x05\x03\x05\x03\x05\x03\x05\x05\x05\u01DE\n\x05\x03\x05\x03\x05" +
    "\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x05\x05\u01E7\n\x05\x03\x05\x03" +
    "\x05\x03\x05\x03\x05\x05\x05\u01ED\n\x05\x03\x05\x03\x05\x03\x05\x05\x05" +
    "\u01F2\n\x05\x03\x05\x03\x05\x05\x05\u01F6\n\x05\x03\x05\x03\x05\x03\x05" +
    "\x03\x05\x03\x05\x03\x05\x07\x05\u01FE\n\x05\f\x05\x0E\x05\u0201\v\x05" +
    "\x05\x05\u0203\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03" +
    "\x05\x03\x05\x05\x05\u020D\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05" +
    "\x03\x05\x03\x05\x03\x05\x03\x05\x07\x05\u0218\n\x05\f\x05\x0E\x05\u021B" +
    "\v\x05\x03\x05\x03\x05\x03\x05\x05\x05\u0220\n\x05\x03\x05\x03\x05\x03" +
    "\x05\x05\x05\u0225\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x05\x05\u022B" +
    "\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x07\x05\u0232\n\x05\f\x05" +
    "\x0E\x05\u0235\v\x05\x03\x05\x03\x05\x03\x05\x05\x05\u023A\n\x05\x03\x05" +
    "\x03\x05\x03\x05\x03\x05\x03\x05\x05\x05\u0241\n\x05\x03\x05\x03\x05\x03" +
    "\x05\x03\x05\x07\x05\u0247\n\x05\f\x05\x0E\x05\u024A\v\x05\x03\x05\x03" +
    "\x05\x05\x05\u024E\n\x05\x03\x05\x03\x05\x05\x05\u0252\n\x05\x03\x05\x03" +
    "\x05\x03\x05\x03\x05\x03\x05\x03\x05\x05\x05\u025A\n\x05\x03\x05\x03\x05" +
    "\x03\x05\x03\x05\x05\x05\u0260\n\x05\x03\x05\x03\x05\x03\x05\x07\x05\u0265" +
    "\n\x05\f\x05\x0E\x05\u0268\v\x05\x03\x05\x03\x05\x05\x05\u026C\n\x05\x03" +
    "\x05\x03\x05\x05\x05\u0270\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05" +
    "\x03\x05\x03\x05\x03\x05\x05\x05\u027A\n\x05\x03\x05\x05\x05\u027D\n\x05" +
    "\x03\x05\x03\x05\x05\x05\u0281\n\x05\x03\x05\x05\x05\u0284\n\x05\x03\x05" +
    "\x03\x05\x03\x05\x03\x05\x07\x05\u028A\n\x05\f\x05\x0E\x05\u028D\v\x05" +
    "\x03\x05\x03\x05\x05\x05\u0291\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03" +
    "\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03" +
    "\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x05\x05\u02A6\n\x05\x03\x05" +
    "\x03\x05\x03\x05\x03\x05\x05\x05\u02AC\n\x05\x03\x05\x03\x05\x03\x05\x03" +
    "\x05\x05\x05\u02B2\n\x05\x05\x05\u02B4\n\x05\x03\x05\x03\x05\x03\x05\x03" +
    "\x05\x05\x05\u02BA\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x05\x05\u02C0" +
    "\n\x05\x05\x05\u02C2\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x05\x05\u02C8" +
    "\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05" +
    "\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05" +
    "\x05\x05\u02DB\n\x05\x03\x05\x03\x05\x03\x05\x05\x05\u02E0\n\x05\x03\x05" +
    "\x03\x05\x03\x05\x03\x05\x03\x05\x05\x05\u02E7\n\x05\x03\x05\x03\x05\x03" +
    "\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x05\x05\u02F3" +
    "\n\x05\x05\x05\u02F5\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03" +
    "\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03" +
    "\x05\x03\x05\x07\x05\u0307\n\x05\f\x05\x0E\x05\u030A\v\x05\x05\x05\u030C" +
    "\n\x05\x03\x05\x03\x05\x05\x05\u0310\n\x05\x03\x05\x03\x05\x05\x05\u0314" +
    "\n\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05" +
    "\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x07\x05\u0324\n\x05\f" +
    "\x05\x0E\x05\u0327\v\x05\x05\x05\u0329\n\x05\x03\x05\x03\x05\x03\x05\x03" +
    "\x05\x03\x05\x03\x05\x05\x05\u0331\n\x05\x03\x06\x05\x06\u0334\n\x06\x03" +
    "\x06\x03\x06\x03\x07\x03\x07\x05\x07\u033A\n\x07\x03\x07\x03\x07\x03\x07" +
    "\x07\x07\u033F\n\x07\f\x07\x0E\x07\u0342\v\x07\x03\b\x03\b\x05\b\u0346" +
    "\n\b\x03\t\x03\t\x03\t\x03\t\x05\t\u034C\n\t\x03\t\x03\t\x05\t\u0350\n" +
    "\t\x03\t\x03\t\x05\t\u0354\n\t\x03\n\x03\n\x03\n\x03\n\x05\n\u035A\n\n" +
    "\x03\v\x03\v\x03\v\x03\v\x07\v\u0360\n\v\f\v\x0E\v\u0363\v\v\x03\v\x03" +
    "\v\x03\f\x03\f\x03\f\x03\f\x03\r\x03\r\x03\r\x03\x0E\x07\x0E\u036F\n\x0E" +
    "\f\x0E\x0E\x0E\u0372\v\x0E\x03\x0F\x03\x0F\x03\x0F\x03\x0F\x05\x0F\u0378" +
    "\n\x0F\x03\x10\x07\x10\u037B\n\x10\f\x10\x0E\x10\u037E\v\x10\x03\x11\x03" +
    "\x11\x03\x12\x03\x12\x05\x12\u0384\n\x12\x03\x13\x03\x13\x03\x13\x03\x14" +
    "\x03\x14\x03\x14\x05\x14\u038C\n\x14\x03\x15\x03\x15\x05\x15\u0390\n\x15" +
    "\x03\x16\x03\x16\x03\x16\x05\x16\u0395\n\x16\x03\x17\x03\x17\x03\x17\x03" +
    "\x17\x03\x17\x03\x17\x03\x17\x03\x17\x03\x17\x05\x17\u03A0\n\x17\x03\x18" +
    "\x03\x18\x03\x19\x03\x19\x03\x19\x03\x19\x03\x19\x03\x19\x07\x19\u03AA" +
    "\n\x19\f\x19\x0E\x19\u03AD\v\x19\x05\x19\u03AF\n\x19\x03\x19\x03\x19\x03" +
    "\x19\x05\x19\u03B4\n\x19\x05\x19\u03B6\n\x19\x03\x19\x03\x19\x05\x19\u03BA" +
    "\n\x19\x03\x1A\x03\x1A\x03\x1A\x03\x1A\x03\x1A\x03\x1A\x05\x1A\u03C2\n" +
    "\x1A\x03\x1A\x03\x1A\x03\x1A\x03\x1A\x05\x1A\u03C8\n\x1A\x03\x1A\x07\x1A" +
    "\u03CB\n\x1A\f\x1A\x0E\x1A\u03CE\v\x1A\x03\x1B\x03\x1B\x03\x1B\x03\x1B" +
    "\x03\x1B\x03\x1B\x03\x1B\x07\x1B\u03D7\n\x1B\f\x1B\x0E\x1B\u03DA\v\x1B" +
    "\x03\x1B\x03\x1B\x03\x1B\x03\x1B\x05\x1B\u03E0\n\x1B\x03\x1C\x03\x1C\x05" +
    "\x1C\u03E4\n\x1C\x03\x1C\x03\x1C\x05\x1C\u03E8\n\x1C\x03\x1D\x03\x1D\x05" +
    "\x1D\u03EC\n\x1D\x03\x1D\x03\x1D\x03\x1D\x07\x1D\u03F1\n\x1D\f\x1D\x0E" +
    "\x1D\u03F4\v\x1D\x03\x1D\x03\x1D\x03\x1D\x03\x1D\x07\x1D\u03FA\n\x1D\f" +
    "\x1D\x0E\x1D\u03FD\v\x1D\x05\x1D\u03FF\n\x1D\x03\x1D\x03\x1D\x05\x1D\u0403" +
    "\n\x1D\x03\x1D\x03\x1D\x03\x1D\x05\x1D\u0408\n\x1D\x03\x1D\x03\x1D\x05" +
    "\x1D\u040C\n\x1D\x03\x1E\x05\x1E\u040F\n\x1E\x03\x1E\x03\x1E\x03\x1E\x07" +
    "\x1E\u0414\n\x1E\f\x1E\x0E\x1E\u0417\v\x1E\x03\x1F\x03\x1F\x03\x1F\x03" +
    "\x1F\x03\x1F\x03\x1F\x07\x1F\u041F\n\x1F\f\x1F\x0E\x1F\u0422\v\x1F\x05" +
    "\x1F\u0424\n\x1F\x03\x1F\x03\x1F\x03\x1F\x03\x1F\x03\x1F\x03\x1F\x07\x1F" +
    "\u042C\n\x1F\f\x1F\x0E\x1F\u042F\v\x1F\x05\x1F\u0431\n\x1F\x03\x1F\x03" +
    "\x1F\x03\x1F\x03\x1F\x03\x1F\x03\x1F\x03\x1F\x07\x1F\u043A\n\x1F\f\x1F" +
    "\x0E\x1F\u043D\v\x1F\x03\x1F\x03\x1F\x05\x1F\u0441\n\x1F\x03 \x03 \x03" +
    " \x03 \x07 \u0447\n \f \x0E \u044A\v \x05 \u044C\n \x03 \x03 \x05 \u0450" +
    "\n \x03!\x03!\x05!\u0454\n!\x03!\x03!\x03!\x03!\x03!\x03\"\x03\"\x03#" +
    "\x03#\x05#\u045F\n#\x03#\x05#\u0462\n#\x03#\x03#\x03#\x03#\x03#\x05#\u0469" +
    "\n#\x03$\x03$\x03$\x03$\x03$\x03$\x03$\x03$\x03$\x03$\x03$\x03$\x03$\x03" +
    "$\x03$\x03$\x03$\x05$\u047C\n$\x07$\u047E\n$\f$\x0E$\u0481\v$\x03%\x05" +
    "%\u0484\n%\x03%\x03%\x05%\u0488\n%\x03%\x03%\x05%\u048C\n%\x03%\x03%\x05" +
    "%\u0490\n%\x05%\u0492\n%\x03&\x03&\x03&\x03&\x03&\x03&\x03&\x07&\u049B" +
    "\n&\f&\x0E&\u049E\v&\x03&\x03&\x05&\u04A2\n&\x03\'\x03\'\x03\'\x03\'\x03" +
    "\'\x03\'\x03\'\x05\'\u04AB\n\'\x03(\x03(\x03)\x03)\x05)\u04B1\n)\x03)" +
    "\x03)\x05)\u04B5\n)\x05)\u04B7\n)\x03*\x03*\x03*\x03*\x07*\u04BD\n*\f" +
    "*\x0E*\u04C0\v*\x03*\x03*\x03+\x03+\x03+\x03+\x03+\x03+\x03+\x03+\x03" +
    "+\x03+\x07+\u04CE\n+\f+\x0E+\u04D1\v+\x03+\x03+\x03+\x05+\u04D6\n+\x03" +
    "+\x03+\x03+\x03+\x03+\x03+\x03+\x03+\x03+\x05+\u04E1\n+\x03,\x03,\x03" +
    "-\x03-\x03.\x03.\x03/\x03/\x030\x030\x030\x050\u04EE\n0\x030\x030\x05" +
    "0\u04F2\n0\x030\x030\x030\x030\x030\x030\x070\u04FA\n0\f0\x0E0\u04FD\v" +
    "0\x031\x031\x031\x031\x031\x031\x031\x031\x031\x031\x051\u0509\n1\x03" +
    "1\x031\x031\x031\x031\x031\x051\u0511\n1\x031\x031\x031\x031\x031\x07" +
    "1\u0518\n1\f1\x0E1\u051B\v1\x031\x031\x031\x051\u0520\n1\x031\x031\x03" +
    "1\x031\x031\x031\x051\u0528\n1\x031\x031\x031\x031\x051\u052E\n1\x031" +
    "\x031\x051\u0532\n1\x031\x031\x031\x051\u0537\n1\x031\x031\x031\x051\u053C" +
    "\n1\x032\x032\x032\x032\x052\u0542\n2\x032\x032\x032\x032\x032\x032\x03" +
    "2\x032\x032\x032\x032\x032\x072\u0550\n2\f2\x0E2\u0553\v2\x033\x033\x03" +
    "3\x033\x033\x033\x033\x033\x033\x033\x033\x033\x033\x033\x033\x033\x03" +
    "3\x033\x033\x033\x033\x033\x033\x033\x063\u056D\n3\r3\x0E3\u056E\x033" +
    "\x033\x033\x033\x033\x033\x033\x073\u0578\n3\f3\x0E3\u057B\v3\x033\x03" +
    "3\x033\x033\x033\x033\x033\x053\u0584\n3\x033\x053\u0587\n3\x033\x033" +
    "\x033\x053\u058C\n3\x033\x033\x033\x073\u0591\n3\f3\x0E3\u0594\v3\x05" +
    "3\u0596\n3\x033\x033\x033\x033\x033\x073\u059D\n3\f3\x0E3\u05A0\v3\x05" +
    "3\u05A2\n3\x033\x033\x053\u05A6\n3\x033\x053\u05A9\n3\x033\x053\u05AC" +
    "\n3\x033\x033\x033\x033\x033\x033\x033\x033\x073\u05B6\n3\f3\x0E3\u05B9" +
    "\v3\x053\u05BB\n3\x033\x033\x033\x033\x033\x033\x033\x033\x033\x033\x03" +
    "3\x033\x033\x033\x033\x063\u05CC\n3\r3\x0E3\u05CD\x033\x033\x053\u05D2" +
    "\n3\x033\x033\x033\x033\x063\u05D8\n3\r3\x0E3\u05D9\x033\x033\x053\u05DE" +
    "\n3\x033\x033\x033\x033\x033\x033\x033\x033\x033\x033\x033\x033\x033\x03" +
    "3\x033\x033\x033\x033\x033\x033\x033\x073\u05F5\n3\f3\x0E3\u05F8\v3\x05" +
    "3\u05FA\n3\x033\x033\x033\x033\x033\x033\x033\x053\u0603\n3\x033\x033" +
    "\x033\x033\x053\u0609\n3\x033\x033\x033\x033\x053\u060F\n3\x033\x033\x03" +
    "3\x033\x053\u0615\n3\x033\x033\x033\x033\x033\x033\x033\x033\x053\u061F" +
    "\n3\x033\x033\x033\x033\x033\x033\x033\x053\u0628\n3\x033\x033\x033\x03" +
    "3\x033\x033\x033\x033\x033\x033\x033\x033\x033\x033\x033\x033\x033\x03" +
    "3\x073\u063C\n3\f3\x0E3\u063F\v3\x053\u0641\n3\x033\x053\u0644\n3\x03" +
    "3\x033\x033\x033\x033\x033\x033\x033\x073\u064E\n3\f3\x0E3\u0651\v3\x03" +
    "4\x034\x034\x034\x054\u0657\n4\x054\u0659\n4\x035\x035\x035\x035\x055" +
    "\u065F\n5\x036\x036\x036\x036\x036\x036\x056\u0667\n6\x037\x037\x038\x03" +
    "8\x039\x039\x03:\x03:\x05:\u0671\n:\x03:\x03:\x03:\x03:\x05:\u0677\n:" +
    "\x03;\x03;\x03<\x03<\x03=\x03=\x03=\x03=\x07=\u0681\n=\f=\x0E=\u0684\v" +
    "=\x05=\u0686\n=\x03=\x03=\x03>\x03>\x03>\x03>\x03>\x03>\x03>\x03>\x03" +
    ">\x03>\x03>\x03>\x03>\x03>\x03>\x03>\x03>\x03>\x03>\x03>\x03>\x07>\u069F" +
    "\n>\f>\x0E>\u06A2\v>\x03>\x03>\x03>\x03>\x03>\x03>\x03>\x07>\u06AB\n>" +
    "\f>\x0E>\u06AE\v>\x03>\x03>\x05>\u06B2\n>\x03>\x03>\x03>\x03>\x03>\x05" +
    ">\u06B9\n>\x03>\x03>\x07>\u06BD\n>\f>\x0E>\u06C0\v>\x03?\x03?\x05?\u06C4" +
    "\n?\x03@\x03@\x03@\x03@\x05@\u06CA\n@\x03A\x03A\x03A\x03A\x03A\x03B\x03" +
    "B\x03B\x03B\x03B\x03B\x03C\x03C\x03C\x03C\x03C\x03C\x03C\x07C\u06DE\n" +
    "C\fC\x0EC\u06E1\vC\x05C\u06E3\nC\x03C\x03C\x03C\x03C\x03C\x07C\u06EA\n" +
    "C\fC\x0EC\u06ED\vC\x05C\u06EF\nC\x03C\x05C\u06F2\nC\x03C\x03C\x03D\x03" +
    "D\x03D\x03D\x03D\x03D\x03D\x03D\x03D\x03D\x03D\x03D\x03D\x03D\x03D\x03" +
    "D\x05D\u0706\nD\x03E\x03E\x03E\x03E\x03E\x03E\x03E\x03E\x03E\x05E\u0711" +
    "\nE\x03F\x03F\x03F\x03F\x05F\u0717\nF\x03G\x03G\x03G\x03G\x03G\x05G\u071E" +
    "\nG\x03H\x03H\x03H\x03H\x03H\x03H\x03H\x05H\u0727\nH\x03I\x03I\x03I\x03" +
    "I\x03I\x05I\u072E\nI\x03J\x03J\x03J\x03J\x05J\u0734\nJ\x03K\x03K\x03K" +
    "\x07K\u0739\nK\fK\x0EK\u073C\vK\x03L\x03L\x05L\u0740\nL\x03L\x05L\u0743" +
    "\nL\x03M\x03M\x03M\x05M\u0748\nM\x03N\x03N\x03N\x03N\x03N\x05N\u074F\n" +
    "N\x03O\x03O\x03O\x07O\u0754\nO\fO\x0EO\u0757\vO\x03P\x03P\x03P\x03P\x03" +
    "P\x05P\u075E\nP\x03Q\x03Q\x03Q\x05Q\u0763\nQ\x03R\x03R\x03R\x02\x02\b" +
    "2F^bdzS\x02\x02\x04\x02\x06\x02\b\x02\n\x02\f\x02\x0E\x02\x10\x02\x12" +
    "\x02\x14\x02\x16\x02\x18\x02\x1A\x02\x1C\x02\x1E\x02 \x02\"\x02$\x02&" +
    "\x02(\x02*\x02,\x02.\x020\x022\x024\x026\x028\x02:\x02<\x02>\x02@\x02" +
    "B\x02D\x02F\x02H\x02J\x02L\x02N\x02P\x02R\x02T\x02V\x02X\x02Z\x02\\\x02" +
    "^\x02`\x02b\x02d\x02f\x02h\x02j\x02l\x02n\x02p\x02r\x02t\x02v\x02x\x02" +
    "z\x02|\x02~\x02\x80\x02\x82\x02\x84\x02\x86\x02\x88\x02\x8A\x02\x8C\x02" +
    "\x8E\x02\x90\x02\x92\x02\x94\x02\x96\x02\x98\x02\x9A\x02\x9C\x02\x9E\x02" +
    "\xA0\x02\xA2\x02\x02\x19\x04\x02\x1C\x1C\x9C\x9C\x04\x0233aa\x04\x02K" +
    "KYY\x04\x02??ZZ\x03\x02\xA5\xA6\x04\x02\x0E\x0E\xE7\xE7\x04\x02>>\xC7" +
    "\xC7\x04\x02\x15\x1555\x04\x02GGhh\x04\x02\x0E\x0E88\x04\x02\x17\x17\xB6" +
    "\xB6\x03\x02\xDE\xDF\x03\x02\xE0\xE2\x03\x02\xD8\xDD\x05\x02\x0E\x0E\x12" +
    "\x12\xB1\xB1\x04\x02EE\xC1\xC1\x07\x0211VVst\xA9\xA9\xD6\xD6\x03\x02w" +
    "z\x04\x02HH\x8F\x8F\x05\x02RRee\xBB\xBB\x06\x0299bbpp\xCD\xCD\x04\x02" +
    "\x84\x84\xD5\xD52\x02\f\x0E\x10\x10\x12\x13\x15\x17\x1A\x1C\x1F$))++/" +
    "133557799??BBDDFHJJMRVXZZ\\\\__abdegikkmmpuw|\x80\x82\x84\x85\x88\x88" +
    "\x8A\x8F\x91\x94\x96\x9F\xA1\xA3\xA5\xAA\xAC\xB6\xB8\xBB\xBD\xC0\xC2\xC3" +
    "\xC5\xC6\xC9\xC9\xCB\xCB\xCD\xCD\xCF\xD0\xD4\xD7\x02\u088C\x02\xA4\x03" +
    "\x02\x02\x02\x04\xA7\x03\x02\x02\x02\x06\xAA\x03\x02\x02\x02\b\u0330\x03" +
    "\x02\x02\x02\n\u0333\x03\x02\x02\x02\f\u0337\x03\x02\x02\x02\x0E\u0345" +
    "\x03\x02\x02\x02\x10\u0347\x03\x02\x02\x02\x12\u0355\x03\x02\x02\x02\x14" +
    "\u035B\x03\x02\x02\x02\x16\u0366\x03\x02\x02\x02\x18\u036A\x03\x02\x02" +
    "\x02\x1A\u0370\x03\x02\x02\x02\x1C\u0377\x03\x02\x02\x02\x1E\u037C\x03" +
    "\x02\x02\x02 \u037F\x03\x02\x02\x02\"\u0383\x03\x02\x02\x02$\u0385\x03" +
    "\x02\x02\x02&\u0388\x03\x02\x02\x02(\u038F\x03\x02\x02\x02*\u0394\x03" +
    "\x02\x02\x02,\u039F\x03\x02\x02\x02.\u03A1\x03\x02\x02\x020\u03A3\x03" +
    "\x02\x02\x022\u03BB\x03\x02\x02\x024\u03DF\x03\x02\x02\x026\u03E1\x03" +
    "\x02\x02\x028\u03E9\x03\x02\x02\x02:\u040E\x03\x02\x02\x02<\u0440\x03" +
    "\x02\x02\x02>\u044F\x03\x02\x02\x02@\u0451\x03\x02\x02\x02B\u045A\x03" +
    "\x02\x02\x02D\u0468\x03\x02\x02\x02F\u046A\x03\x02\x02\x02H\u0491\x03" +
    "\x02\x02\x02J\u04A1\x03\x02\x02\x02L\u04A3\x03\x02\x02\x02N\u04AC\x03" +
    "\x02\x02\x02P\u04AE\x03\x02\x02\x02R\u04B8\x03\x02\x02\x02T\u04E0\x03" +
    "\x02\x02\x02V\u04E2\x03\x02\x02\x02X\u04E4\x03\x02\x02\x02Z\u04E6\x03" +
    "\x02\x02\x02\\\u04E8\x03\x02\x02\x02^\u04F1\x03\x02\x02\x02`\u053B\x03" +
    "\x02\x02\x02b\u0541\x03\x02\x02\x02d\u0643\x03\x02\x02\x02f\u0658\x03" +
    "\x02\x02\x02h\u065E\x03\x02\x02\x02j\u0666\x03\x02\x02\x02l\u0668\x03" +
    "\x02\x02\x02n\u066A\x03\x02\x02\x02p\u066C\x03\x02\x02\x02r\u066E\x03" +
    "\x02\x02\x02t\u0678\x03\x02\x02\x02v\u067A\x03\x02\x02\x02x\u067C\x03" +
    "\x02\x02\x02z\u06B8\x03\x02\x02\x02|\u06C3\x03\x02\x02\x02~\u06C9\x03" +
    "\x02\x02\x02\x80\u06CB\x03\x02\x02\x02\x82\u06D0\x03\x02\x02\x02\x84\u06D6" +
    "\x03\x02\x02\x02\x86\u0705\x03\x02\x02\x02\x88\u0710\x03\x02\x02\x02\x8A" +
    "\u0716\x03\x02\x02\x02\x8C\u071D\x03\x02\x02\x02\x8E\u0726\x03\x02\x02" +
    "\x02\x90\u072D\x03\x02\x02\x02\x92\u0733\x03\x02\x02\x02\x94\u0735\x03" +
    "\x02\x02\x02\x96\u073D\x03\x02\x02\x02\x98\u0747\x03\x02\x02\x02\x9A\u074E" +
    "\x03\x02\x02\x02\x9C\u0750\x03\x02\x02\x02\x9E\u075D\x03\x02\x02\x02\xA0" +
    "\u0762\x03\x02\x02\x02\xA2\u0764\x03\x02\x02\x02\xA4\xA5\x05\b\x05\x02" +
    "\xA5\xA6\x07\x02\x02\x03\xA6\x03\x03\x02\x02";
SqlBaseParser._serializedATNSegment1 = "\x02\xA7\xA8\x05V,\x02\xA8\xA9\x07\x02\x02\x03\xA9\x05\x03\x02\x02\x02" +
    "\xAA\xAB\x05\"\x12\x02\xAB\xAC\x07\x02\x02\x03\xAC\x07\x03\x02\x02\x02" +
    "\xAD\u0331\x05\n\x06\x02\xAE\xAF\x07\xC9\x02\x02\xAF\u0331\x05\x9EP\x02" +
    "\xB0\xB1\x07\xC9\x02\x02\xB1\xB2\x05\x9EP\x02\xB2\xB3\x07\x03\x02\x02" +
    "\xB3\xB4\x05\x9EP\x02\xB4\u0331\x03\x02\x02\x02\xB5\xB6\x07&\x02\x02\xB6" +
    "\xBA\x07\xA7\x02\x02\xB7\xB8\x07W\x02\x02\xB8\xB9\x07~\x02\x02\xB9\xBB" +
    "\x07A\x02\x02\xBA\xB7\x03\x02\x02\x02\xBA\xBB\x03\x02\x02\x02\xBB\xBC" +
    "\x03\x02\x02\x02\xBC\xBF\x05\x94K\x02\xBD\xBE\x07\xD3\x02\x02\xBE\xC0" +
    "\x05\x14\v\x02\xBF\xBD\x03\x02\x02\x02\xBF\xC0\x03\x02\x02\x02\xC0\u0331" +
    "\x03\x02\x02\x02\xC1\xC2\x07:\x02\x02\xC2\xC5\x07\xA7\x02\x02\xC3\xC4" +
    "\x07W\x02\x02\xC4\xC6\x07A\x02\x02\xC5\xC3\x03\x02\x02\x02\xC5\xC6\x03" +
    "\x02\x02\x02\xC6\xC7\x03\x02\x02\x02\xC7\xC9\x05\x94K\x02\xC8\xCA\t\x02" +
    "\x02\x02\xC9\xC8\x03\x02\x02\x02\xC9\xCA\x03\x02\x02\x02\xCA\u0331\x03" +
    "\x02\x02\x02\xCB\xCC\x07\x0F\x02\x02\xCC\xCD\x07\xA7\x02\x02\xCD\xCE\x05" +
    "\x94K\x02\xCE\xCF\x07\x97\x02\x02\xCF\xD0\x07\xBF\x02\x02\xD0\xD1\x05" +
    "\x9EP\x02\xD1\u0331\x03\x02\x02\x02\xD2\xD3\x07&\x02\x02\xD3\xD7\x07\xB7" +
    "\x02\x02\xD4\xD5\x07W\x02\x02\xD5\xD6\x07~\x02\x02\xD6\xD8\x07A\x02\x02" +
    "\xD7\xD4\x03\x02\x02\x02\xD7\xD8\x03\x02\x02\x02\xD8\xD9\x03\x02\x02\x02" +
    "\xD9\xDB\x05\x94K\x02\xDA\xDC\x05R*\x02\xDB\xDA\x03\x02\x02\x02\xDB\xDC" +
    "\x03\x02\x02\x02\xDC\xDF\x03\x02\x02\x02\xDD\xDE\x07\"\x02\x02\xDE\xE0" +
    "\x05f4\x02\xDF\xDD\x03\x02\x02\x02\xDF\xE0\x03\x02\x02\x02\xE0\xE3\x03" +
    "\x02\x02\x02\xE1\xE2\x07\xD3\x02\x02\xE2\xE4\x05\x14\v\x02\xE3\xE1\x03" +
    "\x02\x02\x02\xE3\xE4\x03\x02\x02\x02\xE4\xE5\x03\x02\x02\x02\xE5\xEB\x07" +
    "\x14\x02\x02\xE6\xEC\x05\n\x06\x02\xE7\xE8\x07\x04\x02\x02\xE8\xE9\x05" +
    "\n\x06\x02\xE9\xEA\x07\x05\x02\x02\xEA\xEC\x03\x02\x02\x02\xEB\xE6\x03" +
    "\x02\x02\x02\xEB\xE7\x03\x02\x02\x02\xEC\xF2\x03\x02\x02\x02\xED\xEF\x07" +
    "\xD3\x02\x02\xEE\xF0\x07{\x02\x02\xEF\xEE\x03\x02\x02\x02\xEF\xF0\x03" +
    "\x02\x02\x02\xF0\xF1\x03\x02\x02\x02\xF1\xF3\x07/\x02\x02\xF2\xED\x03" +
    "\x02\x02\x02\xF2\xF3\x03\x02\x02\x02\xF3\u0331\x03\x02\x02\x02\xF4\xF5" +
    "\x07&\x02\x02\xF5\xF9\x07\xB7\x02\x02\xF6\xF7\x07W\x02\x02\xF7\xF8\x07" +
    "~\x02\x02\xF8\xFA\x07A\x02\x02\xF9\xF6\x03\x02\x02\x02\xF9\xFA\x03\x02" +
    "\x02\x02\xFA\xFB\x03\x02\x02\x02\xFB\xFC\x05\x94K\x02\xFC\xFD\x07\x04" +
    "\x02\x02\xFD\u0102\x05\x0E\b\x02\xFE\xFF\x07\x06\x02\x02\xFF\u0101\x05" +
    "\x0E\b\x02\u0100\xFE\x03\x02\x02\x02\u0101\u0104\x03\x02\x02\x02\u0102" +
    "\u0100\x03\x02\x02\x02\u0102\u0103\x03\x02\x02\x02\u0103\u0105\x03\x02" +
    "\x02\x02\u0104\u0102\x03\x02\x02\x02\u0105\u0108\x07\x05\x02\x02\u0106" +
    "\u0107\x07\"\x02\x02\u0107\u0109\x05f4\x02\u0108\u0106\x03\x02\x02\x02" +
    "\u0108\u0109\x03\x02\x02\x02\u0109\u010C\x03\x02\x02\x02\u010A\u010B\x07" +
    "\xD3\x02\x02\u010B\u010D\x05\x14\v\x02\u010C\u010A\x03\x02\x02\x02\u010C" +
    "\u010D\x03\x02\x02\x02\u010D\u0331\x03\x02\x02\x02\u010E\u010F\x07:\x02" +
    "\x02\u010F\u0112\x07\xB7\x02\x02\u0110\u0111\x07W\x02\x02\u0111\u0113" +
    "\x07A\x02\x02\u0112\u0110\x03\x02\x02\x02\u0112\u0113\x03\x02\x02\x02" +
    "\u0113\u0114\x03\x02\x02\x02\u0114\u0331\x05\x94K\x02\u0115\u0116\x07" +
    "]\x02\x02\u0116\u0117\x07`\x02\x02\u0117\u0119\x05\x96L\x02\u0118\u011A" +
    "\x05R*\x02\u0119\u0118\x03\x02\x02\x02\u0119\u011A\x03\x02\x02\x02\u011A" +
    "\u011B\x03\x02\x02\x02\u011B\u011C\x05\n\x06\x02\u011C\u0331\x03\x02\x02" +
    "\x02\u011D\u011E\x07\xCA\x02\x02\u011E\u011F\x05\x96L\x02\u011F\u0120" +
    "\x07\xAE\x02\x02\u0120\u0125\x05Z.\x02\u0121\u0122\x07\x06\x02\x02\u0122" +
    "\u0124\x05Z.\x02\u0123\u0121\x03\x02\x02\x02\u0124\u0127\x03\x02\x02\x02" +
    "\u0125\u0123\x03\x02\x02\x02\u0125\u0126\x03\x02\x02\x02\u0126\u012A\x03" +
    "\x02\x02\x02\u0127\u0125\x03\x02\x02\x02\u0128\u0129\x07\xD2\x02\x02\u0129" +
    "\u012B\x05X-\x02\u012A\u0128\x03\x02\x02\x02\u012A\u012B\x03\x02\x02\x02" +
    "\u012B\u0331\x03\x02\x02\x02\u012C\u012D\x074\x02\x02\u012D\u012E\x07" +
    "K\x02\x02\u012E\u0131\x05\x94K\x02\u012F\u0130\x07\xD2\x02\x02\u0130\u0132" +
    "\x05X-\x02\u0131\u012F\x03\x02\x02\x02\u0131\u0132\x03\x02\x02\x02\u0132" +
    "\u0331\x03\x02\x02\x02\u0133\u0134\x07\x0F\x02\x02\u0134\u0137\x07\xB7" +
    "\x02\x02\u0135\u0136\x07W\x02\x02\u0136\u0138\x07A\x02\x02\u0137\u0135" +
    "\x03\x02\x02\x02\u0137\u0138\x03\x02\x02\x02\u0138\u0139\x03\x02\x02\x02" +
    "\u0139\u013A\x05\x94K\x02\u013A\u013B\x07\x97\x02\x02\u013B\u013C\x07" +
    "\xBF\x02\x02\u013C\u013D\x05\x94K\x02\u013D\u0331\x03\x02\x02\x02\u013E" +
    "\u013F\x07\x0F\x02\x02\u013F\u0142\x07\xB7\x02\x02\u0140\u0141\x07W\x02" +
    "\x02\u0141\u0143\x07A\x02\x02\u0142\u0140\x03\x02\x02\x02\u0142\u0143" +
    "\x03\x02\x02\x02\u0143\u0144\x03\x02\x02\x02\u0144\u0145\x05\x94K\x02" +
    "\u0145\u0146\x07\x97\x02\x02\u0146\u0149\x07 \x02\x02\u0147\u0148\x07" +
    "W\x02\x02\u0148\u014A\x07A\x02\x02\u0149\u0147\x03\x02\x02\x02\u0149\u014A" +
    "\x03\x02\x02\x02\u014A\u014B\x03\x02\x02\x02\u014B\u014C\x05\x9EP\x02" +
    "\u014C\u014D\x07\xBF\x02\x02\u014D\u014E\x05\x9EP\x02\u014E\u0331\x03" +
    "\x02\x02\x02\u014F\u0150\x07\x0F\x02\x02\u0150\u0153\x07\xB7\x02\x02\u0151" +
    "\u0152\x07W\x02\x02\u0152\u0154\x07A\x02\x02\u0153\u0151\x03\x02\x02\x02" +
    "\u0153\u0154\x03\x02\x02\x02\u0154\u0155\x03\x02\x02\x02\u0155\u0156\x05" +
    "\x94K\x02\u0156\u0157\x07:\x02\x02\u0157\u015A\x07 \x02\x02\u0158\u0159" +
    "\x07W\x02\x02\u0159\u015B\x07A\x02\x02\u015A\u0158\x03\x02\x02\x02\u015A" +
    "\u015B\x03\x02\x02\x02\u015B\u015C\x03\x02\x02\x02\u015C\u015D\x05\x94" +
    "K\x02\u015D\u0331\x03\x02\x02\x02\u015E\u015F\x07\x0F\x02\x02\u015F\u0162" +
    "\x07\xB7\x02\x02\u0160\u0161\x07W\x02\x02\u0161\u0163\x07A\x02\x02\u0162" +
    "\u0160\x03\x02\x02\x02\u0162\u0163\x03\x02\x02\x02\u0163\u0164\x03\x02" +
    "\x02\x02\u0164\u0165\x05\x94K\x02\u0165\u0166\x07\f\x02\x02\u0166\u016A" +
    "\x07 \x02\x02\u0167\u0168\x07W\x02\x02\u0168\u0169\x07~\x02\x02\u0169" +
    "\u016B\x07A\x02\x02\u016A\u0167\x03\x02\x02\x02\u016A\u016B\x03\x02\x02" +
    "\x02\u016B\u016C\x03\x02\x02\x02\u016C\u016D\x05\x10\t\x02\u016D\u0331" +
    "\x03\x02\x02\x02\u016E\u016F\x07\x10\x02\x02\u016F\u0172\x05\x94K\x02" +
    "\u0170\u0171\x07\xD3\x02\x02\u0171\u0173\x05\x14\v\x02\u0172\u0170\x03" +
    "\x02\x02\x02\u0172\u0173\x03\x02\x02\x02\u0173\u0331\x03\x02\x02\x02\u0174" +
    "\u0175\x07&\x02\x02\u0175\u0176\x07\xC3\x02\x02\u0176\u0177\x05\x94K\x02" +
    "\u0177\u0184\x07\x14\x02\x02\u0178\u0179\x07\x04\x02\x02\u0179\u017E\x05" +
    "\x18\r\x02\u017A\u017B\x07\x06\x02\x02\u017B\u017D\x05\x18\r\x02\u017C" +
    "\u017A\x03\x02\x02\x02\u017D\u0180\x03\x02\x02\x02\u017E\u017C\x03\x02" +
    "\x02\x02\u017E\u017F\x03\x02\x02\x02\u017F\u0181\x03\x02\x02\x02\u0180" +
    "\u017E\x03\x02\x02\x02\u0181\u0182\x07\x05\x02\x02\u0182\u0185\x03\x02" +
    "\x02\x02\u0183\u0185\x05z>\x02\u0184\u0178\x03\x02\x02\x02\u0184\u0183" +
    "\x03\x02\x02\x02\u0185\u0331\x03\x02\x02\x02\u0186\u0189\x07&\x02\x02" +
    "\u0187\u0188\x07\x86\x02\x02\u0188\u018A\x07\x99\x02\x02\u0189\u0187\x03" +
    "\x02\x02\x02\u0189\u018A\x03\x02\x02\x02\u018A\u018B\x03\x02\x02\x02\u018B" +
    "\u018C\x07\xD0\x02\x02\u018C\u018F\x05\x94K\x02\u018D\u018E\x07\xAA\x02" +
    "\x02\u018E\u0190\t\x03\x02\x02\u018F\u018D\x03\x02\x02\x02\u018F\u0190" +
    "\x03\x02\x02\x02\u0190\u0191\x03\x02\x02\x02\u0191\u0192\x07\x14\x02\x02" +
    "\u0192\u0193\x05\n\x06\x02\u0193\u0331\x03\x02\x02\x02\u0194\u0195\x07" +
    ":\x02\x02\u0195\u0198\x07\xD0\x02\x02\u0196\u0197\x07W\x02\x02\u0197\u0199" +
    "\x07A\x02\x02\u0198\u0196\x03\x02\x02\x02\u0198\u0199\x03\x02\x02\x02" +
    "\u0199\u019A\x03\x02\x02\x02\u019A\u0331\x05\x94K\x02\u019B\u019C\x07" +
    "&\x02\x02\u019C\u019D\x07r\x02\x02\u019D\u01A1\x07\xD0\x02\x02\u019E\u019F" +
    "\x07W\x02\x02\u019F\u01A0\x07~\x02\x02\u01A0\u01A2\x07A\x02\x02\u01A1" +
    "\u019E\x03\x02\x02\x02\u01A1\u01A2\x03\x02\x02\x02\u01A2\u01A3\x03\x02" +
    "\x02\x02\u01A3\u01A6\x05\x94K\x02\u01A4\u01A5\x07\"\x02\x02\u01A5\u01A7" +
    "\x05f4\x02\u01A6\u01A4\x03\x02\x02\x02\u01A6\u01A7\x03\x02\x02\x02\u01A7" +
    "\u01AA\x03\x02\x02\x02\u01A8\u01A9\x07\xD3\x02\x02\u01A9\u01AB\x05\x14" +
    "\v\x02\u01AA\u01A8\x03\x02\x02\x02\u01AA\u01AB\x03\x02\x02\x02\u01AB\u01AC" +
    "\x03\x02\x02\x02\u01AC\u01B2\x07\x14\x02\x02\u01AD\u01B3\x05\n\x06\x02" +
    "\u01AE\u01AF\x07\x04\x02\x02\u01AF\u01B0\x05\n\x06\x02\u01B0\u01B1\x07" +
    "\x05\x02\x02\u01B1\u01B3\x03\x02\x02\x02\u01B2\u01AD\x03\x02\x02\x02\u01B2" +
    "\u01AE\x03\x02\x02\x02\u01B3\u0331\x03\x02\x02\x02\u01B4\u01B5\x07:\x02" +
    "\x02\u01B5\u01B6\x07r\x02\x02\u01B6\u01B9\x07\xD0\x02\x02\u01B7\u01B8" +
    "\x07W\x02\x02\u01B8\u01BA\x07A\x02\x02\u01B9\u01B7\x03\x02\x02\x02\u01B9" +
    "\u01BA\x03\x02\x02\x02\u01BA\u01BB\x03\x02\x02\x02\u01BB\u0331\x05\x94" +
    "K\x02\u01BC\u01BD\x07\x96\x02\x02\u01BD\u01BE\x07r\x02\x02\u01BE\u01BF" +
    "\x07\xD0\x02\x02\u01BF\u01C0\x05\x94K\x02\u01C0\u01C1\x07\xD2\x02\x02" +
    "\u01C1\u01C2\x05^0\x02\u01C2\u0331\x03\x02\x02\x02\u01C3\u01C6\x07&\x02" +
    "\x02\u01C4\u01C5\x07\x86\x02\x02\u01C5\u01C7\x07\x99\x02\x02\u01C6\u01C4" +
    "\x03\x02\x02\x02\u01C6\u01C7\x03\x02\x02\x02\u01C7\u01C9\x03\x02\x02\x02" +
    "\u01C8\u01CA\x07\xBA\x02\x02\u01C9\u01C8\x03\x02\x02\x02\u01C9\u01CA\x03" +
    "\x02\x02\x02\u01CA\u01CB\x03\x02\x02\x02\u01CB\u01CC\x07M\x02\x02\u01CC" +
    "\u01CD\x05\x94K\x02\u01CD\u01D6\x07\x04\x02\x02\u01CE\u01D3\x05\x18\r" +
    "\x02\u01CF\u01D0\x07\x06\x02\x02\u01D0\u01D2\x05\x18\r\x02\u01D1\u01CF" +
    "\x03\x02\x02\x02\u01D2\u01D5\x03\x02\x02\x02\u01D3\u01D1\x03\x02\x02\x02" +
    "\u01D3\u01D4\x03\x02\x02\x02\u01D4\u01D7\x03\x02\x02\x02\u01D5\u01D3\x03" +
    "\x02\x02\x02\u01D6\u01CE\x03\x02\x02\x02\u01D6\u01D7\x03\x02\x02\x02\u01D7" +
    "\u01D8\x03\x02\x02\x02\u01D8\u01D9\x07\x05\x02\x02\u01D9\u01DA\x07\x9E" +
    "\x02\x02\u01DA\u01DD\x05z>\x02\u01DB\u01DC\x07\"\x02\x02\u01DC\u01DE\x05" +
    "f4\x02\u01DD\u01DB\x03\x02\x02\x02\u01DD\u01DE\x03\x02\x02\x02\u01DE\u01DF" +
    "\x03\x02\x02\x02\u01DF\u01E0\x05\x1A\x0E\x02\u01E0\u01E1\x05\"\x12\x02" +
    "\u01E1\u0331\x03\x02\x02\x02\u01E2\u01E3\x07\x0F\x02\x02\u01E3\u01E4\x07" +
    "M\x02\x02\u01E4\u01E6\x05\x94K\x02\u01E5\u01E7\x05x=\x02\u01E6\u01E5\x03" +
    "\x02\x02\x02\u01E6\u01E7\x03\x02\x02\x02\u01E7\u01E8\x03\x02\x02\x02\u01E8" +
    "\u01E9\x05\x1E\x10\x02\u01E9\u0331\x03\x02\x02\x02\u01EA\u01EC\x07:\x02" +
    "\x02\u01EB\u01ED\x07\xBA\x02\x02\u01EC\u01EB\x03\x02\x02\x02\u01EC\u01ED" +
    "\x03\x02\x02\x02\u01ED\u01EE\x03\x02\x02\x02\u01EE\u01F1\x07M\x02\x02" +
    "\u01EF\u01F0\x07W\x02\x02\u01F0\u01F2\x07A\x02\x02\u01F1\u01EF\x03\x02" +
    "\x02\x02\u01F1\u01F2\x03\x02\x02\x02\u01F2\u01F3\x03\x02\x02\x02\u01F3" +
    "\u01F5\x05\x94K\x02\u01F4\u01F6\x05x=\x02\u01F5\u01F4\x03\x02\x02\x02" +
    "\u01F5\u01F6\x03\x02\x02\x02\u01F6\u0331\x03\x02\x02\x02\u01F7\u01F8\x07" +
    "\x1A\x02\x02\u01F8\u01F9\x05\x94K\x02\u01F9\u0202\x07\x04\x02\x02\u01FA" +
    "\u01FF\x05\x90I\x02\u01FB\u01FC\x07\x06\x02\x02\u01FC\u01FE\x05\x90I\x02" +
    "\u01FD\u01FB\x03\x02\x02\x02\u01FE\u0201\x03\x02\x02\x02\u01FF\u01FD\x03" +
    "\x02\x02\x02\u01FF\u0200\x03\x02\x02\x02\u0200\u0203\x03\x02\x02\x02\u0201" +
    "\u01FF\x03\x02\x02\x02\u0202\u01FA\x03\x02\x02\x02\u0202\u0203\x03\x02" +
    "\x02\x02\u0203\u0204\x03\x02\x02\x02\u0204\u0205\x07\x05\x02\x02\u0205" +
    "\u0331\x03\x02\x02\x02\u0206\u0207\x07&\x02\x02\u0207\u0208\x07\xA1\x02" +
    "\x02\u0208\u020C\x05\x9EP\x02\u0209\u020A\x07\xD3\x02\x02\u020A\u020B" +
    "\x07\r\x02\x02\u020B\u020D\x05\x98M\x02\u020C\u0209\x03\x02\x02\x02\u020C" +
    "\u020D\x03\x02\x02\x02\u020D\u0331\x03\x02\x02\x02\u020E\u020F\x07:\x02" +
    "\x02\u020F\u0210\x07\xA1\x02\x02\u0210\u0331\x05\x9EP\x02\u0211\u0212" +
    "\x07O\x02\x02\u0212\u0213\x05\x9CO\x02\u0213\u0214\x07\xBF\x02\x02\u0214" +
    "\u0219\x05\x9AN\x02\u0215\u0216\x07\x06\x02\x02\u0216\u0218\x05\x9AN\x02" +
    "\u0217\u0215\x03\x02\x02\x02\u0218\u021B\x03\x02\x02\x02\u0219\u0217\x03" +
    "\x02\x02\x02\u0219\u021A\x03\x02\x02\x02\u021A\u021F\x03\x02\x02\x02\u021B" +
    "\u0219\x03\x02\x02\x02\u021C\u021D\x07\xD3\x02\x02\u021D\u021E\x07\r\x02" +
    "\x02\u021E\u0220\x07\x85\x02\x02\u021F\u021C\x03\x02\x02\x02\u021F\u0220" +
    "\x03\x02\x02\x02\u0220\u0224\x03\x02\x02\x02\u0221\u0222\x07P\x02\x02" +
    "\u0222\u0223\x07\x19\x02\x02\u0223\u0225\x05\x98M\x02\u0224\u0221\x03" +
    "\x02\x02\x02\u0224\u0225\x03\x02\x02\x02\u0225\u0331\x03\x02\x02\x02\u0226" +
    "\u022A\x07\x9F\x02\x02\u0227\u0228\x07\r\x02\x02\u0228\u0229\x07\x85\x02" +
    "\x02\u0229\u022B\x07I\x02\x02\u022A\u0227\x03\x02\x02\x02\u022A\u022B" +
    "\x03\x02\x02\x02\u022B\u022C\x03\x02\x02\x02\u022C\u022D\x05\x9CO\x02" +
    "\u022D\u022E\x07K\x02\x02\u022E\u0233\x05\x9AN\x02\u022F\u0230\x07\x06" +
    "\x02\x02\u0230\u0232\x05\x9AN\x02\u0231\u022F\x03\x02\x02\x02\u0232\u0235" +
    "\x03\x02\x02\x02\u0233\u0231\x03\x02\x02\x02\u0233\u0234\x03\x02\x02\x02" +
    "\u0234\u0239\x03\x02\x02\x02\u0235\u0233\x03\x02\x02\x02\u0236\u0237\x07" +
    "P\x02\x02\u0237\u0238\x07\x19\x02\x02\u0238\u023A\x05\x98M\x02\u0239\u0236" +
    "\x03\x02\x02\x02\u0239\u023A\x03\x02\x02\x02\u023A\u0331\x03\x02\x02\x02" +
    "\u023B\u023C\x07\xAE\x02\x02\u023C\u0240\x07\xA1\x02\x02\u023D\u0241\x07" +
    "\x0E\x02\x02\u023E\u0241\x07|\x02\x02\u023F\u0241\x05\x9EP\x02\u0240\u023D" +
    "\x03\x02\x02\x02\u0240\u023E\x03\x02\x02\x02\u0240\u023F\x03\x02\x02\x02" +
    "\u0241\u0331\x03\x02\x02\x02\u0242\u024D\x07O\x02\x02\u0243\u0248\x05" +
    "\x92J\x02\u0244\u0245\x07\x06\x02\x02\u0245\u0247\x05\x92J\x02\u0246\u0244" +
    "\x03\x02\x02\x02\u0247\u024A\x03\x02\x02\x02\u0248\u0246\x03\x02\x02\x02" +
    "\u0248\u0249\x03\x02\x02\x02\u0249\u024E\x03\x02\x02\x02\u024A\u0248\x03" +
    "\x02\x02\x02\u024B\u024C\x07\x0E\x02\x02\u024C\u024E\x07\x91\x02\x02\u024D" +
    "\u0243\x03\x02\x02\x02\u024D\u024B\x03\x02\x02\x02\u024E\u024F\x03\x02" +
    "\x02\x02\u024F\u0251\x07\x83\x02\x02\u0250\u0252\x07\xB7\x02\x02\u0251" +
    "\u0250\x03\x02\x02\x02\u0251\u0252\x03\x02\x02\x02\u0252\u0253\x03\x02" +
    "\x02\x02\u0253\u0254\x05\x94K\x02\u0254\u0255\x07\xBF\x02\x02\u0255\u0259" +
    "\x05\x9AN\x02\u0256\u0257\x07\xD3\x02\x02\u0257\u0258\x07O\x02\x02\u0258" +
    "\u025A\x07\x85\x02\x02\u0259\u0256\x03\x02\x02\x02\u0259\u025A\x03\x02" +
    "\x02\x02\u025A\u0331\x03\x02\x02\x02\u025B\u025F\x07\x9F\x02\x02\u025C" +
    "\u025D\x07O\x02\x02\u025D\u025E\x07\x85\x02\x02\u025E\u0260\x07I\x02\x02" +
    "\u025F\u025C\x03\x02\x02\x02\u025F\u0260\x03\x02\x02\x02\u0260\u026B\x03" +
    "\x02\x02\x02\u0261\u0266\x05\x92J\x02\u0262\u0263\x07\x06\x02\x02\u0263" +
    "\u0265\x05\x92J\x02\u0264\u0262\x03\x02\x02\x02\u0265\u0268\x03\x02\x02" +
    "\x02\u0266\u0264\x03\x02\x02\x02\u0266\u0267\x03\x02\x02\x02\u0267\u026C" +
    "\x03\x02\x02\x02\u0268\u0266\x03\x02\x02\x02\u0269\u026A\x07\x0E\x02\x02" +
    "\u026A\u026C\x07\x91\x02\x02\u026B\u0261\x03\x02\x02\x02\u026B\u0269\x03" +
    "\x02\x02\x02\u026C\u026D\x03\x02\x02\x02\u026D\u026F\x07\x83\x02\x02\u026E" +
    "\u0270\x07\xB7\x02\x02\u026F\u026E\x03\x02\x02\x02\u026F\u0270\x03\x02" +
    "\x02\x02\u0270\u0271\x03\x02\x02\x02\u0271\u0272\x05\x94K\x02\u0272\u0273" +
    "\x07K\x02\x02\u0273\u0274\x05\x9AN\x02\u0274\u0331\x03\x02\x02\x02\u0275" +
    "\u0276\x07\xB0\x02\x02\u0276\u027C\x07Q\x02\x02\u0277\u0279\x07\x83\x02" +
    "\x02\u0278\u027A\x07\xB7\x02\x02\u0279\u0278\x03\x02\x02\x02\u0279\u027A" +
    "\x03\x02\x02\x02\u027A\u027B\x03\x02\x02\x02\u027B\u027D\x05\x94K\x02" +
    "\u027C\u0277\x03\x02\x02\x02\u027C\u027D\x03\x02\x02\x02\u027D\u0331\x03" +
    "\x02\x02\x02\u027E\u0280\x07B\x02\x02\u027F\u0281\x07\x10\x02\x02\u0280" +
    "\u027F\x03\x02\x02\x02\u0280\u0281\x03\x02\x02\x02\u0281\u0283\x03\x02" +
    "\x02\x02\u0282\u0284\x07\xCF\x02\x02\u0283\u0282\x03\x02\x02\x02\u0283" +
    "\u0284\x03\x02\x02\x02\u0284\u0290\x03\x02\x02\x02\u0285\u0286\x07\x04" +
    "\x02\x02\u0286\u028B\x05\x8AF\x02\u0287\u0288\x07\x06\x02\x02\u0288\u028A" +
    "\x05\x8AF\x02\u0289\u0287\x03\x02\x02\x02\u028A\u028D\x03\x02\x02\x02" +
    "\u028B\u0289\x03\x02\x02\x02\u028B\u028C\x03\x02\x02\x02\u028C\u028E\x03" +
    "\x02\x02\x02\u028D\u028B\x03\x02\x02\x02\u028E\u028F\x07\x05\x02\x02\u028F" +
    "\u0291\x03\x02\x02\x02\u0290\u0285\x03\x02\x02\x02\u0290\u0291\x03\x02" +
    "\x02\x02\u0291\u0292\x03\x02\x02\x02\u0292\u0331\x05\b\x05\x02\u0293\u0294" +
    "\x07\xB0\x02\x02\u0294\u0295\x07&\x02\x02\u0295\u0296\x07\xB7\x02\x02" +
    "\u0296\u0331\x05\x94K\x02\u0297\u0298\x07\xB0\x02\x02\u0298\u0299\x07" +
    "&\x02\x02\u0299\u029A\x07\xD0\x02\x02\u029A\u0331\x05\x94K\x02\u029B\u029C" +
    "\x07\xB0\x02\x02\u029C\u029D\x07&\x02\x02\u029D\u029E\x07r\x02\x02\u029E" +
    "\u029F\x07\xD0\x02\x02\u029F\u0331\x05\x94K\x02\u02A0\u02A1\x07\xB0\x02" +
    "\x02\u02A1\u02A2\x07&\x02\x02\u02A2\u02A3\x07M\x02\x02\u02A3\u02A5\x05" +
    "\x94K\x02\u02A4\u02A6\x05x=\x02\u02A5\u02A4\x03\x02\x02\x02\u02A5\u02A6" +
    "\x03\x02\x02\x02\u02A6\u0331\x03\x02\x02\x02\u02A7\u02A8\x07\xB0\x02\x02" +
    "\u02A8\u02AB\x07\xB8\x02\x02\u02A9\u02AA\t\x04\x02\x02\u02AA\u02AC\x05" +
    "\x94K\x02\u02AB\u02A9\x03\x02\x02\x02\u02AB\u02AC\x03\x02\x02\x02\u02AC" +
    "\u02B3\x03\x02\x02\x02\u02AD\u02AE\x07l\x02\x02\u02AE\u02B1\x05f4\x02" +
    "\u02AF\u02B0\x07=\x02\x02\u02B0\u02B2\x05f4\x02\u02B1\u02AF\x03\x02\x02" +
    "\x02\u02B1\u02B2\x03\x02\x02\x02\u02B2\u02B4\x03\x02\x02\x02\u02B3\u02AD" +
    "\x03\x02\x02\x02\u02B3\u02B4\x03\x02\x02\x02\u02B4\u0331\x03\x02\x02\x02" +
    "\u02B5\u02B6\x07\xB0\x02\x02\u02B6\u02B9\x07\xA8\x02\x02\u02B7\u02B8\t" +
    "\x04\x02\x02\u02B8\u02BA\x05\x9EP\x02\u02B9\u02B7\x03\x02\x02\x02\u02B9" +
    "\u02BA\x03\x02\x02\x02\u02BA\u02C1\x03\x02\x02\x02\u02BB\u02BC\x07l\x02" +
    "\x02\u02BC\u02BF\x05f4\x02\u02BD\u02BE\x07=\x02\x02\u02BE\u02C0\x05f4" +
    "\x02\u02BF\u02BD\x03\x02\x02\x02\u02BF\u02C0\x03\x02\x02\x02\u02C0\u02C2" +
    "\x03\x02\x02\x02\u02C1\u02BB\x03\x02\x02\x02\u02C1\u02C2\x03\x02\x02\x02" +
    "\u02C2\u0331\x03\x02\x02\x02\u02C3\u02C4\x07\xB0\x02\x02\u02C4\u02C7\x07" +
    "\x1F\x02\x02\u02C5\u02C6\x07l\x02\x02\u02C6\u02C8\x05f4\x02\u02C7\u02C5" +
    "\x03\x02\x02\x02\u02C7\u02C8\x03\x02\x02\x02\u02C8\u0331\x03\x02\x02\x02" +
    "\u02C9\u02CA\x07\xB0\x02\x02\u02CA\u02CB\x07!\x02\x02\u02CB\u02CC\t\x04" +
    "\x02\x02\u02CC\u0331\x05\x94K\x02\u02CD\u02CE\x07\xB0\x02\x02\u02CE\u02CF" +
    "\x07\xB4\x02\x02\u02CF\u02D0\x07I\x02\x02\u02D0\u0331\x05\x94K\x02\u02D1" +
    "\u02D2\x07\xB0\x02\x02\u02D2\u02D3\x07\xB4\x02\x02\u02D3\u02D4\x07I\x02" +
    "\x02\u02D4\u02D5\x07\x04\x02\x02\u02D5\u02D6\x058\x1D\x02\u02D6\u02D7" +
    "\x07\x05\x02\x02\u02D7\u0331\x03\x02\x02\x02\u02D8\u02DA\x07\xB0\x02\x02" +
    "\u02D9\u02DB\x07)\x02\x02\u02DA\u02D9\x03\x02\x02\x02\u02DA\u02DB\x03" +
    "\x02\x02\x02\u02DB\u02DC\x03\x02\x02\x02\u02DC\u02DF\x07\xA2\x02\x02\u02DD" +
    "\u02DE\t\x04\x02\x02\u02DE\u02E0\x05\x9EP\x02\u02DF\u02DD\x03\x02\x02" +
    "\x02\u02DF\u02E0\x03\x02\x02\x02\u02E0\u0331\x03\x02\x02\x02\u02E1\u02E2" +
    "\x07\xB0\x02\x02\u02E2\u02E3\x07\xA1\x02\x02\u02E3\u02E6\x07Q\x02\x02" +
    "\u02E4\u02E5\t\x04\x02\x02\u02E5\u02E7\x05\x9EP\x02\u02E6\u02E4\x03\x02" +
    "\x02\x02\u02E6\u02E7\x03\x02\x02\x02\u02E7\u0331\x03\x02\x02\x02\u02E8" +
    "\u02E9\x076\x02\x02\u02E9\u0331\x05\x94K\x02\u02EA\u02EB\x075\x02\x02" +
    "\u02EB\u0331\x05\x94K\x02\u02EC\u02ED\x07\xB0\x02\x02\u02ED\u02F4\x07" +
    "N\x02\x02\u02EE\u02EF\x07l\x02\x02\u02EF\u02F2\x05f4\x02\u02F0\u02F1\x07" +
    "=\x02\x02\u02F1\u02F3\x05f4\x02\u02F2\u02F0\x03\x02\x02\x02\u02F2\u02F3" +
    "\x03\x02\x02\x02\u02F3\u02F5\x03\x02\x02\x02\u02F4\u02EE\x03\x02\x02\x02" +
    "\u02F4\u02F5\x03\x02\x02\x02\u02F5\u0331\x03\x02\x02\x02\u02F6\u02F7\x07" +
    "\xB0\x02\x02\u02F7\u0331\x07\xAD\x02\x02\u02F8\u02F9\x07\xAE\x02\x02\u02F9" +
    "\u02FA\x07\xAD\x02\x02\u02FA\u02FB\x05\x94K\x02\u02FB\u02FC\x07\xD8\x02" +
    "\x02\u02FC\u02FD\x05V,\x02\u02FD\u0331\x03\x02\x02\x02\u02FE\u02FF\x07" +
    "\x9A\x02\x02\u02FF\u0300\x07\xAD\x02\x02\u0300\u0331\x05\x94K\x02\u0301" +
    "\u0302\x07\xB3\x02\x02\u0302\u030B\x07\xC0\x02\x02\u0303\u0308\x05\x8C" +
    "G\x02\u0304\u0305\x07\x06\x02\x02\u0305\u0307\x05\x8CG\x02\u0306\u0304" +
    "\x03\x02\x02\x02\u0307\u030A\x03\x02\x02\x02\u0308\u0306\x03\x02\x02\x02" +
    "\u0308\u0309\x03\x02\x02\x02\u0309\u030C\x03\x02\x02\x02\u030A\u0308\x03" +
    "\x02\x02\x02\u030B\u0303\x03\x02\x02\x02\u030B\u030C\x03\x02\x02\x02\u030C" +
    "\u0331\x03\x02\x02\x02\u030D\u030F\x07#\x02\x02\u030E\u0310\x07\xD4\x02" +
    "\x02\u030F\u030E\x03\x02\x02\x02\u030F\u0310\x03\x02\x02\x02\u0310\u0331" +
    "\x03\x02\x02\x02\u0311\u0313\x07\xA3\x02\x02\u0312\u0314\x07\xD4\x02\x02" +
    "\u0313\u0312\x03\x02\x02\x02\u0313\u0314\x03\x02\x02\x02\u0314\u0331\x03" +
    "\x02\x02\x02\u0315\u0316\x07\x90\x02\x02\u0316\u0317\x05\x9EP\x02\u0317" +
    "\u0318\x07K\x02\x02\u0318\u0319\x05\b\x05\x02\u0319\u0331\x03\x02\x02" +
    "\x02\u031A\u031B\x072\x02\x02\u031B\u031C\x07\x90\x02\x02\u031C\u0331" +
    "\x05\x9EP\x02\u031D\u031E\x07@\x02\x02\u031E\u0328\x05\x9EP\x02\u031F" +
    "\u0320\x07\xCC\x02\x02\u0320\u0325\x05V,\x02\u0321\u0322\x07\x06\x02\x02" +
    "\u0322\u0324\x05V,\x02\u0323\u0321\x03\x02\x02\x02\u0324\u0327\x03\x02" +
    "\x02\x02\u0325\u0323\x03\x02\x02\x02\u0325\u0326\x03\x02\x02\x02\u0326" +
    "\u0329\x03\x02\x02\x02\u0327\u0325\x03\x02\x02\x02\u0328\u031F\x03\x02" +
    "\x02\x02\u0328\u0329\x03\x02\x02\x02\u0329\u0331\x03\x02\x02\x02\u032A" +
    "\u032B\x076\x02\x02\u032B\u032C\x07\\\x02\x02\u032C\u0331\x05\x9EP\x02" +
    "\u032D\u032E\x076\x02\x02\u032E\u032F\x07\x8A\x02\x02\u032F\u0331\x05" +
    "\x9EP\x02\u0330\xAD\x03\x02\x02\x02\u0330\xAE\x03\x02\x02\x02\u0330\xB0" +
    "\x03\x02\x02\x02\u0330\xB5\x03\x02\x02\x02\u0330\xC1\x03\x02\x02\x02\u0330" +
    "\xCB\x03\x02\x02\x02\u0330\xD2\x03\x02\x02\x02\u0330\xF4\x03\x02\x02\x02" +
    "\u0330\u010E\x03\x02\x02\x02\u0330\u0115\x03\x02\x02\x02\u0330\u011D\x03" +
    "\x02\x02\x02\u0330\u012C\x03\x02\x02\x02\u0330\u0133\x03\x02\x02\x02\u0330" +
    "\u013E\x03\x02\x02\x02\u0330\u014F\x03\x02\x02\x02\u0330\u015E\x03\x02" +
    "\x02\x02\u0330\u016E\x03\x02\x02\x02\u0330\u0174\x03\x02\x02\x02\u0330" +
    "\u0186\x03\x02\x02\x02\u0330\u0194\x03\x02\x02\x02\u0330\u019B\x03\x02" +
    "\x02\x02\u0330\u01B4\x03\x02\x02\x02\u0330\u01BC\x03\x02\x02\x02\u0330" +
    "\u01C3\x03\x02\x02\x02\u0330\u01E2\x03\x02\x02\x02\u0330\u01EA\x03\x02" +
    "\x02\x02\u0330\u01F7\x03\x02\x02\x02\u0330\u0206\x03\x02\x02\x02\u0330" +
    "\u020E\x03\x02\x02\x02\u0330\u0211\x03\x02\x02\x02\u0330\u0226\x03\x02" +
    "\x02\x02\u0330\u023B\x03\x02\x02\x02\u0330\u0242\x03\x02\x02\x02\u0330" +
    "\u025B\x03\x02\x02\x02\u0330\u0275\x03\x02\x02\x02\u0330\u027E\x03\x02" +
    "\x02\x02\u0330\u0293\x03\x02\x02\x02\u0330\u0297\x03\x02\x02\x02\u0330" +
    "\u029B\x03\x02\x02\x02\u0330\u02A0\x03\x02\x02\x02\u0330\u02A7\x03\x02" +
    "\x02\x02\u0330\u02B5\x03\x02\x02\x02\u0330\u02C3\x03\x02\x02\x02\u0330" +
    "\u02C9\x03\x02\x02\x02\u0330\u02CD\x03\x02\x02\x02\u0330\u02D1\x03\x02" +
    "\x02\x02\u0330\u02D8\x03\x02\x02\x02\u0330\u02E1\x03\x02\x02\x02\u0330" +
    "\u02E8\x03\x02\x02\x02\u0330\u02EA\x03\x02\x02\x02\u0330\u02EC\x03\x02" +
    "\x02\x02\u0330\u02F6\x03\x02\x02\x02\u0330\u02F8\x03\x02\x02\x02\u0330" +
    "\u02FE\x03\x02\x02\x02\u0330\u0301\x03\x02\x02\x02\u0330\u030D\x03\x02" +
    "\x02\x02\u0330\u0311\x03\x02\x02\x02\u0330\u0315\x03\x02\x02\x02\u0330" +
    "\u031A\x03\x02\x02\x02\u0330\u031D\x03\x02\x02\x02\u0330\u032A\x03\x02" +
    "\x02\x02\u0330\u032D\x03\x02\x02\x02\u0331\t\x03\x02\x02\x02\u0332\u0334" +
    "\x05\f\x07\x02\u0333\u0332\x03\x02\x02\x02\u0333\u0334\x03\x02\x02\x02" +
    "\u0334\u0335\x03\x02\x02\x02\u0335\u0336\x050\x19\x02\u0336\v\x03\x02" +
    "\x02\x02\u0337\u0339\x07\xD3\x02\x02\u0338\u033A\x07\x95\x02\x02\u0339" +
    "\u0338\x03\x02\x02\x02\u0339\u033A\x03\x02\x02\x02\u033A\u033B\x03\x02" +
    "\x02\x02\u033B\u0340\x05@!\x02\u033C\u033D\x07\x06\x02\x02\u033D\u033F" +
    "\x05@!\x02\u033E\u033C\x03\x02\x02\x02\u033F\u0342\x03\x02\x02\x02\u0340" +
    "\u033E\x03\x02\x02\x02\u0340\u0341\x03\x02\x02\x02\u0341\r\x03\x02\x02" +
    "\x02\u0342\u0340\x03\x02\x02\x02\u0343\u0346\x05\x10\t\x02\u0344\u0346" +
    "\x05\x12\n\x02\u0345\u0343\x03\x02\x02\x02\u0345\u0344\x03\x02\x02\x02" +
    "\u0346\x0F\x03\x02\x02\x02\u0347\u0348\x05\x9EP\x02\u0348\u034B\x05z>" +
    "\x02\u0349\u034A\x07~\x02\x02\u034A\u034C\x07\x7F\x02\x02\u034B\u0349" +
    "\x03\x02\x02\x02\u034B";
SqlBaseParser._serializedATNSegment2 = "\u034C\x03\x02\x02\x02\u034C\u034F\x03\x02\x02\x02\u034D\u034E\x07\"\x02" +
    "\x02\u034E\u0350\x05f4\x02\u034F\u034D\x03\x02\x02\x02\u034F\u0350\x03" +
    "\x02\x02\x02\u0350\u0353\x03\x02\x02\x02\u0351\u0352\x07\xD3\x02\x02\u0352" +
    "\u0354\x05\x14\v\x02\u0353\u0351\x03\x02\x02\x02\u0353\u0354\x03\x02\x02" +
    "\x02\u0354\x11\x03\x02\x02\x02\u0355\u0356\x07l\x02\x02\u0356\u0359\x05" +
    "\x94K\x02\u0357\u0358\t\x05\x02\x02\u0358\u035A\x07\x92\x02\x02\u0359" +
    "\u0357\x03\x02\x02\x02\u0359\u035A\x03\x02\x02\x02\u035A\x13\x03\x02\x02" +
    "\x02\u035B\u035C\x07\x04\x02\x02\u035C\u0361\x05\x16\f\x02\u035D\u035E" +
    "\x07\x06\x02\x02\u035E\u0360\x05\x16\f\x02\u035F\u035D\x03\x02\x02\x02" +
    "\u0360\u0363\x03\x02\x02\x02\u0361\u035F\x03\x02\x02\x02\u0361\u0362\x03" +
    "\x02\x02\x02\u0362\u0364\x03\x02\x02\x02\u0363\u0361\x03\x02\x02\x02\u0364" +
    "\u0365\x07\x05\x02\x02\u0365\x15\x03\x02\x02\x02\u0366\u0367\x05\x9EP" +
    "\x02\u0367\u0368\x07\xD8\x02\x02\u0368\u0369\x05V,\x02\u0369\x17\x03\x02" +
    "\x02\x02\u036A\u036B\x05\x9EP\x02\u036B\u036C\x05z>\x02\u036C\x19\x03" +
    "\x02\x02\x02\u036D\u036F\x05\x1C\x0F\x02\u036E\u036D\x03\x02\x02\x02\u036F" +
    "\u0372\x03\x02\x02\x02\u0370\u036E\x03\x02\x02\x02\u0370\u0371\x03\x02" +
    "\x02\x02\u0371\x1B\x03\x02\x02\x02\u0372\u0370\x03\x02\x02\x02\u0373\u0374" +
    "\x07g\x02\x02\u0374\u0378\x05(\x15\x02\u0375\u0378\x05*\x16\x02\u0376" +
    "\u0378\x05,\x17\x02\u0377\u0373\x03\x02\x02\x02\u0377\u0375\x03\x02\x02" +
    "\x02\u0377\u0376\x03\x02\x02\x02\u0378\x1D\x03\x02\x02\x02\u0379\u037B" +
    "\x05 \x11\x02\u037A\u0379\x03\x02\x02\x02\u037B\u037E\x03\x02\x02\x02" +
    "\u037C\u037A\x03\x02\x02\x02\u037C\u037D\x03\x02\x02\x02\u037D\x1F\x03" +
    "\x02\x02\x02\u037E\u037C\x03\x02\x02\x02\u037F\u0380\x05,\x17\x02\u0380" +
    "!\x03\x02\x02\x02\u0381\u0384\x05$\x13\x02\u0382\u0384\x05&\x14\x02\u0383" +
    "\u0381\x03\x02\x02\x02\u0383\u0382\x03\x02\x02\x02\u0384#\x03\x02\x02" +
    "\x02\u0385\u0386\x07\x9D\x02\x02\u0386\u0387\x05V,\x02\u0387%\x03\x02" +
    "\x02\x02\u0388\u038B\x07D\x02\x02\u0389\u038A\x07u\x02\x02\u038A\u038C" +
    "\x05.\x18\x02\u038B\u0389\x03\x02\x02\x02\u038B\u038C\x03\x02\x02\x02" +
    "\u038C\'\x03\x02\x02\x02\u038D\u0390\x07\xB2\x02\x02\u038E\u0390\x05\x9E" +
    "P\x02\u038F\u038D\x03\x02\x02\x02\u038F\u038E\x03\x02\x02\x02\u0390)\x03" +
    "\x02\x02\x02\u0391\u0395\x077\x02\x02\u0392\u0393\x07~\x02\x02\u0393\u0395" +
    "\x077\x02\x02\u0394\u0391\x03\x02\x02\x02\u0394\u0392\x03\x02\x02\x02" +
    "\u0395+\x03\x02\x02\x02\u0396\u0397\x07\x9E\x02\x02\u0397\u0398\x07\x7F" +
    "\x02\x02\u0398\u0399\x07\x83\x02\x02\u0399\u039A\x07\x7F\x02\x02\u039A" +
    "\u03A0\x07\\\x02\x02\u039B\u039C\x07\x1B\x02\x02\u039C\u039D\x07\x83\x02" +
    "\x02\u039D\u039E\x07\x7F\x02\x02\u039E\u03A0\x07\\\x02\x02\u039F\u0396" +
    "\x03\x02\x02\x02\u039F\u039B\x03\x02\x02\x02\u03A0-\x03\x02\x02\x02\u03A1" +
    "\u03A2\x05\x9EP\x02\u03A2/\x03\x02\x02\x02\u03A3\u03AE\x052\x1A\x02\u03A4" +
    "\u03A5\x07\x87\x02\x02\u03A5\u03A6\x07\x19\x02\x02\u03A6\u03AB\x056\x1C" +
    "\x02\u03A7\u03A8\x07\x06\x02\x02\u03A8\u03AA\x056\x1C\x02\u03A9\u03A7" +
    "\x03\x02\x02\x02\u03AA\u03AD\x03\x02\x02\x02\u03AB\u03A9\x03\x02\x02\x02" +
    "\u03AB\u03AC\x03\x02\x02\x02\u03AC\u03AF\x03\x02\x02\x02\u03AD\u03AB\x03" +
    "\x02\x02\x02\u03AE\u03A4\x03\x02\x02\x02\u03AE\u03AF\x03\x02\x02\x02\u03AF" +
    "\u03B5\x03\x02\x02\x02\u03B0\u03B1\x07\x82\x02\x02\u03B1\u03B3\x07\xE7" +
    "\x02\x02\u03B2\u03B4\t\x06\x02\x02\u03B3\u03B2\x03\x02\x02\x02\u03B3\u03B4" +
    "\x03\x02\x02\x02\u03B4\u03B6\x03\x02\x02\x02\u03B5\u03B0\x03\x02\x02\x02" +
    "\u03B5\u03B6\x03\x02\x02\x02\u03B6\u03B9\x03\x02\x02\x02\u03B7\u03B8\x07" +
    "m\x02\x02\u03B8\u03BA\t\x07\x02\x02\u03B9\u03B7\x03\x02\x02\x02\u03B9" +
    "\u03BA\x03\x02\x02\x02\u03BA1\x03\x02\x02\x02\u03BB\u03BC\b\x1A\x01\x02" +
    "\u03BC\u03BD\x054\x1B\x02\u03BD\u03CC\x03\x02\x02\x02\u03BE\u03BF\f\x04" +
    "\x02\x02\u03BF\u03C1\x07^\x02\x02\u03C0\u03C2\x05B\"\x02\u03C1\u03C0\x03" +
    "\x02\x02\x02\u03C1\u03C2\x03\x02\x02\x02\u03C2\u03C3\x03\x02\x02\x02\u03C3" +
    "\u03CB\x052\x1A\x05\u03C4\u03C5\f\x03\x02\x02\u03C5\u03C7\t\b\x02\x02" +
    "\u03C6\u03C8\x05B\"\x02\u03C7\u03C6\x03\x02\x02\x02\u03C7\u03C8\x03\x02" +
    "\x02\x02\u03C8\u03C9\x03\x02\x02\x02\u03C9\u03CB\x052\x1A\x04\u03CA\u03BE" +
    "\x03\x02\x02\x02\u03CA\u03C4\x03\x02\x02\x02\u03CB\u03CE\x03\x02\x02\x02" +
    "\u03CC\u03CA\x03\x02\x02\x02\u03CC\u03CD\x03\x02\x02\x02\u03CD3\x03\x02" +
    "\x02\x02\u03CE\u03CC\x03\x02\x02\x02\u03CF\u03E0\x058\x1D\x02\u03D0\u03D1" +
    "\x07\xB7\x02\x02\u03D1\u03E0\x05\x94K\x02\u03D2\u03D3\x07\xCE\x02\x02" +
    "\u03D3\u03D8\x05V,\x02\u03D4\u03D5\x07\x06\x02\x02\u03D5\u03D7\x05V,\x02" +
    "\u03D6\u03D4\x03\x02\x02\x02\u03D7\u03DA\x03\x02\x02\x02\u03D8\u03D6\x03" +
    "\x02\x02\x02\u03D8\u03D9\x03\x02\x02\x02\u03D9\u03E0\x03\x02\x02\x02\u03DA" +
    "\u03D8\x03\x02\x02\x02\u03DB\u03DC\x07\x04\x02\x02\u03DC\u03DD\x050\x19" +
    "\x02\u03DD\u03DE\x07\x05\x02\x02\u03DE\u03E0\x03\x02\x02\x02\u03DF\u03CF" +
    "\x03\x02\x02\x02\u03DF\u03D0\x03\x02\x02\x02\u03DF\u03D2\x03\x02\x02\x02" +
    "\u03DF\u03DB\x03\x02\x02\x02\u03E05\x03\x02\x02\x02\u03E1\u03E3\x05V," +
    "\x02\u03E2\u03E4\t\t\x02\x02\u03E3\u03E2\x03\x02\x02\x02\u03E3\u03E4\x03" +
    "\x02\x02\x02\u03E4\u03E7\x03\x02\x02\x02\u03E5\u03E6\x07\x81\x02\x02\u03E6" +
    "\u03E8\t\n\x02\x02\u03E7\u03E5\x03\x02\x02\x02\u03E7\u03E8\x03\x02\x02" +
    "\x02\u03E87\x03\x02\x02\x02\u03E9\u03EB\x07\xAB\x02\x02\u03EA\u03EC\x05" +
    "B\"\x02\u03EB\u03EA\x03\x02\x02\x02\u03EB\u03EC\x03\x02\x02\x02\u03EC" +
    "\u03ED\x03\x02\x02\x02\u03ED\u03F2\x05D#\x02\u03EE\u03EF\x07\x06\x02\x02" +
    "\u03EF\u03F1\x05D#\x02\u03F0\u03EE\x03\x02\x02\x02\u03F1\u03F4\x03\x02" +
    "\x02\x02\u03F2\u03F0\x03\x02\x02\x02\u03F2\u03F3\x03\x02\x02\x02\u03F3" +
    "\u03FE\x03\x02\x02\x02\u03F4\u03F2\x03\x02\x02\x02\u03F5\u03F6\x07K\x02" +
    "\x02\u03F6\u03FB\x05F$\x02\u03F7\u03F8\x07\x06\x02\x02\u03F8\u03FA\x05" +
    "F$\x02\u03F9\u03F7\x03\x02\x02\x02\u03FA\u03FD\x03\x02\x02\x02\u03FB\u03F9" +
    "\x03\x02\x02\x02\u03FB\u03FC\x03\x02\x02\x02\u03FC\u03FF\x03\x02\x02\x02" +
    "\u03FD\u03FB\x03\x02\x02\x02\u03FE\u03F5\x03\x02\x02\x02\u03FE\u03FF\x03" +
    "\x02\x02\x02\u03FF\u0402\x03\x02\x02\x02\u0400\u0401\x07\xD2\x02\x02\u0401" +
    "\u0403\x05X-\x02\u0402\u0400\x03\x02\x02\x02\u0402\u0403\x03\x02\x02\x02" +
    "\u0403\u0407\x03\x02\x02\x02\u0404\u0405\x07S\x02\x02\u0405\u0406\x07" +
    "\x19\x02\x02\u0406\u0408\x05:\x1E\x02\u0407\u0404\x03\x02\x02\x02\u0407" +
    "\u0408\x03\x02\x02\x02\u0408\u040B\x03\x02\x02\x02\u0409\u040A\x07U\x02" +
    "\x02\u040A\u040C\x05\\/\x02\u040B\u0409\x03\x02\x02\x02\u040B\u040C\x03" +
    "\x02\x02\x02\u040C9\x03\x02\x02\x02\u040D\u040F\x05B\"\x02\u040E\u040D" +
    "\x03\x02\x02\x02\u040E\u040F\x03\x02\x02\x02\u040F\u0410\x03\x02\x02\x02" +
    "\u0410\u0415\x05<\x1F\x02\u0411\u0412\x07\x06\x02\x02\u0412\u0414\x05" +
    "<\x1F\x02\u0413\u0411\x03\x02\x02\x02\u0414\u0417\x03\x02\x02\x02\u0415" +
    "\u0413\x03\x02\x02\x02\u0415\u0416\x03\x02\x02\x02\u0416;\x03\x02\x02" +
    "\x02\u0417\u0415\x03\x02\x02\x02\u0418\u0441\x05> \x02\u0419\u041A\x07" +
    "\xA4\x02\x02\u041A\u0423\x07\x04\x02\x02\u041B\u0420\x05V,\x02\u041C\u041D" +
    "\x07\x06\x02\x02\u041D\u041F\x05V,\x02\u041E\u041C\x03\x02\x02\x02\u041F" +
    "\u0422\x03\x02\x02\x02\u0420\u041E\x03\x02\x02\x02\u0420\u0421\x03\x02" +
    "\x02\x02\u0421\u0424\x03\x02\x02\x02\u0422\u0420\x03\x02\x02\x02\u0423" +
    "\u041B\x03\x02\x02\x02\u0423\u0424\x03\x02\x02\x02\u0424\u0425\x03\x02" +
    "\x02\x02\u0425\u0441\x07\x05\x02\x02\u0426\u0427\x07(\x02\x02\u0427\u0430" +
    "\x07\x04\x02\x02\u0428\u042D\x05V,\x02\u0429\u042A\x07\x06\x02\x02\u042A" +
    "\u042C\x05V,\x02\u042B\u0429\x03\x02\x02\x02\u042C\u042F\x03\x02\x02\x02" +
    "\u042D\u042B\x03\x02\x02\x02\u042D\u042E\x03\x02\x02\x02\u042E\u0431\x03" +
    "\x02\x02\x02\u042F\u042D\x03\x02\x02\x02\u0430\u0428\x03\x02\x02\x02\u0430" +
    "\u0431\x03\x02\x02\x02\u0431\u0432\x03\x02\x02\x02\u0432\u0441\x07\x05" +
    "\x02\x02\u0433\u0434\x07T\x02\x02\u0434\u0435\x07\xAF\x02\x02\u0435\u0436" +
    "\x07\x04\x02\x02\u0436\u043B\x05> \x02\u0437\u0438\x07\x06\x02\x02\u0438" +
    "\u043A\x05> \x02\u0439\u0437\x03\x02\x02\x02\u043A\u043D\x03\x02\x02\x02" +
    "\u043B\u0439\x03\x02\x02\x02\u043B\u043C\x03\x02\x02\x02\u043C\u043E\x03" +
    "\x02\x02\x02\u043D\u043B\x03\x02\x02\x02\u043E\u043F\x07\x05\x02\x02\u043F" +
    "\u0441\x03\x02\x02\x02\u0440\u0418\x03\x02\x02\x02\u0440\u0419\x03\x02" +
    "\x02\x02\u0440\u0426\x03\x02\x02\x02\u0440\u0433\x03\x02\x02\x02\u0441" +
    "=\x03\x02\x02\x02\u0442\u044B\x07\x04\x02\x02\u0443\u0448\x05V,\x02\u0444" +
    "\u0445\x07\x06\x02\x02\u0445\u0447\x05V,\x02\u0446\u0444\x03\x02\x02\x02" +
    "\u0447\u044A\x03\x02\x02\x02\u0448\u0446\x03\x02\x02\x02\u0448\u0449\x03" +
    "\x02\x02\x02\u0449\u044C\x03\x02\x02\x02\u044A\u0448\x03\x02\x02\x02\u044B" +
    "\u0443\x03\x02\x02\x02\u044B\u044C\x03\x02\x02\x02\u044C\u044D\x03\x02" +
    "\x02\x02\u044D\u0450\x07\x05\x02\x02\u044E\u0450\x05V,\x02\u044F\u0442" +
    "\x03\x02\x02\x02\u044F\u044E\x03\x02\x02\x02\u0450?\x03\x02\x02\x02\u0451" +
    "\u0453\x05\x9EP\x02\u0452\u0454\x05R*\x02\u0453\u0452\x03\x02\x02\x02" +
    "\u0453\u0454\x03\x02\x02\x02\u0454\u0455\x03\x02\x02\x02\u0455\u0456\x07" +
    "\x14\x02\x02\u0456\u0457\x07\x04\x02\x02\u0457\u0458\x05\n\x06\x02\u0458" +
    "\u0459\x07\x05\x02\x02\u0459A\x03\x02\x02\x02\u045A\u045B\t\v\x02\x02" +
    "\u045BC\x03\x02\x02\x02\u045C\u0461\x05V,\x02\u045D\u045F\x07\x14\x02" +
    "\x02\u045E\u045D\x03\x02\x02\x02\u045E\u045F\x03\x02\x02\x02\u045F\u0460" +
    "\x03\x02\x02\x02\u0460\u0462\x05\x9EP\x02\u0461\u045E\x03\x02\x02\x02" +
    "\u0461\u0462\x03\x02\x02\x02\u0462\u0469\x03\x02\x02\x02\u0463\u0464\x05" +
    "\x94K\x02\u0464\u0465\x07\x03\x02\x02\u0465\u0466\x07\xE0\x02\x02\u0466" +
    "\u0469\x03\x02\x02\x02\u0467\u0469\x07\xE0\x02\x02\u0468\u045C\x03\x02" +
    "\x02\x02\u0468\u0463\x03\x02\x02\x02\u0468\u0467\x03\x02\x02\x02\u0469" +
    "E\x03\x02\x02\x02\u046A\u046B\b$\x01\x02\u046B\u046C\x05L\'\x02\u046C" +
    "\u047F\x03\x02\x02\x02\u046D\u047B\f\x04\x02\x02\u046E\u046F\x07\'\x02" +
    "\x02\u046F\u0470\x07f\x02\x02\u0470\u047C\x05L\'\x02\u0471\u0472\x05H" +
    "%\x02\u0472\u0473\x07f\x02\x02\u0473\u0474\x05F$\x02\u0474\u0475\x05J" +
    "&\x02\u0475\u047C\x03\x02\x02\x02\u0476\u0477\x07v\x02\x02\u0477\u0478" +
    "\x05H%\x02\u0478\u0479\x07f\x02\x02\u0479\u047A\x05L\'\x02\u047A\u047C" +
    "\x03\x02\x02\x02\u047B\u046E\x03\x02\x02\x02\u047B\u0471\x03\x02\x02\x02" +
    "\u047B\u0476\x03\x02\x02\x02\u047C\u047E\x03\x02\x02\x02\u047D\u046D\x03" +
    "\x02\x02\x02\u047E\u0481\x03\x02\x02\x02\u047F\u047D\x03\x02\x02\x02\u047F" +
    "\u0480\x03\x02\x02\x02\u0480G\x03\x02\x02\x02\u0481\u047F\x03\x02\x02" +
    "\x02\u0482\u0484\x07[\x02\x02\u0483\u0482\x03\x02\x02\x02\u0483\u0484" +
    "\x03\x02\x02\x02\u0484\u0492\x03\x02\x02\x02\u0485\u0487\x07j\x02\x02" +
    "\u0486\u0488\x07\x89\x02\x02\u0487\u0486\x03\x02\x02\x02\u0487\u0488\x03" +
    "\x02\x02\x02\u0488\u0492\x03\x02\x02\x02\u0489\u048B\x07\xA0\x02\x02\u048A" +
    "\u048C\x07\x89\x02\x02\u048B\u048A\x03\x02\x02\x02\u048B\u048C\x03\x02" +
    "\x02\x02\u048C\u0492\x03\x02\x02\x02\u048D\u048F\x07L\x02\x02\u048E\u0490" +
    "\x07\x89\x02\x02\u048F\u048E\x03\x02\x02\x02\u048F\u0490\x03\x02\x02\x02" +
    "\u0490\u0492\x03\x02\x02\x02\u0491\u0483\x03\x02\x02\x02\u0491\u0485\x03" +
    "\x02\x02\x02\u0491\u0489\x03\x02\x02\x02\u0491\u048D\x03\x02\x02\x02\u0492" +
    "I\x03\x02\x02\x02\u0493\u0494\x07\x83\x02\x02\u0494\u04A2\x05^0\x02\u0495" +
    "\u0496\x07\xCC\x02\x02\u0496\u0497\x07\x04\x02\x02\u0497\u049C\x05\x9E" +
    "P\x02\u0498\u0499\x07\x06\x02\x02\u0499\u049B\x05\x9EP\x02\u049A\u0498" +
    "\x03\x02\x02\x02\u049B\u049E\x03\x02\x02\x02\u049C\u049A\x03\x02\x02\x02" +
    "\u049C\u049D\x03\x02\x02\x02\u049D\u049F\x03\x02\x02\x02\u049E\u049C\x03" +
    "\x02\x02\x02\u049F\u04A0\x07\x05\x02\x02\u04A0\u04A2\x03\x02\x02\x02\u04A1" +
    "\u0493\x03\x02\x02\x02\u04A1\u0495\x03\x02\x02\x02\u04A2K\x03\x02\x02" +
    "\x02\u04A3\u04AA\x05P)\x02\u04A4\u04A5\x07\xB9\x02\x02\u04A5\u04A6\x05" +
    "N(\x02\u04A6\u04A7\x07\x04\x02\x02\u04A7\u04A8\x05V,\x02\u04A8\u04A9\x07" +
    "\x05\x02\x02\u04A9\u04AB\x03\x02\x02\x02\u04AA\u04A4\x03\x02\x02\x02\u04AA" +
    "\u04AB\x03\x02\x02\x02\u04ABM\x03\x02\x02\x02\u04AC\u04AD\t\f\x02\x02" +
    "\u04ADO\x03\x02\x02\x02\u04AE\u04B6\x05T+\x02\u04AF\u04B1\x07\x14\x02" +
    "\x02\u04B0\u04AF\x03\x02\x02\x02\u04B0\u04B1\x03\x02\x02\x02\u04B1\u04B2" +
    "\x03\x02\x02\x02\u04B2\u04B4\x05\x9EP\x02\u04B3\u04B5\x05R*\x02\u04B4" +
    "\u04B3\x03\x02\x02\x02\u04B4\u04B5\x03\x02\x02\x02\u04B5\u04B7\x03\x02" +
    "\x02\x02\u04B6\u04B0\x03\x02\x02\x02\u04B6\u04B7\x03\x02\x02\x02\u04B7" +
    "Q\x03\x02\x02\x02\u04B8\u04B9\x07\x04\x02\x02\u04B9\u04BE\x05\x9EP\x02" +
    "\u04BA\u04BB\x07\x06\x02\x02\u04BB\u04BD\x05\x9EP\x02\u04BC\u04BA\x03" +
    "\x02\x02\x02\u04BD\u04C0\x03\x02\x02\x02\u04BE\u04BC\x03\x02\x02\x02\u04BE" +
    "\u04BF\x03\x02\x02\x02\u04BF\u04C1\x03\x02\x02\x02\u04C0\u04BE\x03\x02" +
    "\x02\x02\u04C1\u04C2\x07\x05\x02\x02\u04C2S\x03\x02\x02\x02\u04C3\u04E1" +
    "\x05\x96L\x02\u04C4\u04C5\x07\x04\x02\x02\u04C5\u04C6\x05\n\x06\x02\u04C6" +
    "\u04C7\x07\x05\x02\x02\u04C7\u04E1\x03\x02\x02\x02\u04C8\u04C9\x07\xC8" +
    "\x02\x02\u04C9\u04CA\x07\x04\x02\x02\u04CA\u04CF\x05V,\x02\u04CB\u04CC" +
    "\x07\x06\x02\x02\u04CC\u04CE\x05V,\x02\u04CD\u04CB\x03\x02\x02\x02\u04CE" +
    "\u04D1\x03\x02\x02\x02\u04CF\u04CD\x03\x02\x02\x02\u04CF\u04D0\x03\x02" +
    "\x02\x02\u04D0\u04D2\x03\x02\x02\x02\u04D1\u04CF\x03\x02\x02\x02\u04D2" +
    "\u04D5\x07\x05\x02\x02\u04D3\u04D4\x07\xD3\x02\x02\u04D4\u04D6\x07\x88" +
    "\x02\x02\u04D5\u04D3\x03\x02\x02\x02\u04D5\u04D6\x03\x02\x02\x02\u04D6" +
    "\u04E1\x03\x02\x02\x02\u04D7\u04D8\x07i\x02\x02\u04D8\u04D9\x07\x04\x02" +
    "\x02\u04D9\u04DA\x05\n\x06\x02\u04DA\u04DB\x07\x05\x02\x02\u04DB\u04E1" +
    "\x03\x02\x02\x02\u04DC\u04DD\x07\x04\x02\x02\u04DD\u04DE\x05F$\x02\u04DE" +
    "\u04DF\x07\x05\x02\x02\u04DF\u04E1\x03\x02\x02\x02\u04E0\u04C3\x03\x02" +
    "\x02\x02\u04E0\u04C4\x03\x02\x02\x02\u04E0\u04C8\x03\x02\x02\x02\u04E0" +
    "\u04D7\x03\x02\x02\x02\u04E0\u04DC\x03\x02\x02\x02\u04E1U\x03\x02\x02" +
    "\x02\u04E2\u04E3\x05^0\x02\u04E3W\x03\x02\x02\x02\u04E4\u04E5\x05^0\x02" +
    "\u04E5Y\x03\x02\x02\x02\u04E6\u04E7\x05^0\x02\u04E7[\x03\x02\x02\x02\u04E8" +
    "\u04E9\x05^0\x02\u04E9]\x03\x02\x02\x02\u04EA\u04EB\b0\x01\x02\u04EB\u04ED" +
    "\x05b2\x02\u04EC\u04EE\x05`1\x02\u04ED\u04EC\x03\x02\x02\x02\u04ED\u04EE" +
    "\x03\x02\x02\x02\u04EE\u04F2\x03\x02\x02\x02\u04EF\u04F0\x07~\x02\x02" +
    "\u04F0\u04F2\x05^0\x05\u04F1\u04EA\x03\x02\x02\x02\u04F1\u04EF\x03\x02" +
    "\x02\x02\u04F2\u04FB\x03\x02\x02\x02\u04F3\u04F4\f\x04\x02\x02\u04F4\u04F5" +
    "\x07\x11\x02\x02\u04F5\u04FA\x05^0\x05\u04F6\u04F7\f\x03\x02\x02\u04F7" +
    "\u04F8\x07\x86\x02\x02\u04F8\u04FA\x05^0\x04\u04F9\u04F3\x03\x02\x02\x02" +
    "\u04F9\u04F6\x03\x02\x02\x02\u04FA\u04FD\x03\x02\x02\x02\u04FB\u04F9\x03" +
    "\x02\x02\x02\u04FB\u04FC\x03\x02\x02\x02\u04FC_\x03\x02\x02\x02\u04FD" +
    "\u04FB\x03\x02\x02\x02\u04FE\u04FF\x05l7\x02\u04FF\u0500\x05b2\x02\u0500" +
    "\u053C\x03\x02\x02\x02\u0501\u0502\x05l7\x02\u0502\u0503\x05n8\x02\u0503" +
    "\u0504\x07\x04\x02\x02\u0504\u0505\x05\n\x06\x02\u0505\u0506\x07\x05\x02" +
    "\x02\u0506\u053C\x03\x02\x02\x02\u0507\u0509\x07~\x02\x02\u0508\u0507" +
    "\x03\x02\x02\x02\u0508\u0509\x03\x02\x02\x02\u0509\u050A\x03\x02\x02\x02" +
    "\u050A\u050B\x07\x18\x02\x02\u050B\u050C\x05b2\x02\u050C\u050D\x07\x11" +
    "\x02\x02\u050D\u050E\x05b2\x02\u050E\u053C\x03\x02\x02\x02\u050F\u0511" +
    "\x07~\x02\x02\u0510\u050F\x03\x02\x02\x02\u0510\u0511\x03\x02\x02\x02" +
    "\u0511\u0512\x03\x02\x02\x02\u0512\u0513\x07Y\x02\x02\u0513\u0514\x07" +
    "\x04\x02\x02\u0514\u0519\x05V,\x02\u0515\u0516\x07\x06\x02\x02\u0516\u0518" +
    "\x05V,\x02\u0517\u0515\x03\x02\x02\x02\u0518\u051B\x03\x02\x02\x02\u0519" +
    "\u0517\x03\x02\x02\x02\u0519\u051A\x03\x02\x02\x02\u051A\u051C\x03\x02" +
    "\x02\x02\u051B\u0519\x03\x02\x02\x02\u051C\u051D\x07\x05\x02\x02\u051D" +
    "\u053C\x03\x02\x02\x02\u051E\u0520\x07~\x02\x02\u051F\u051E\x03\x02\x02" +
    "\x02\u051F\u0520\x03\x02\x02\x02\u0520\u0521\x03\x02\x02\x02\u0521\u0522" +
    "\x07Y\x02\x02\u0522\u0523\x07\x04\x02\x02\u0523\u0524\x05\n\x06\x02\u0524" +
    "\u0525\x07\x05\x02\x02\u0525\u053C\x03\x02\x02\x02\u0526\u0528\x07~\x02" +
    "\x02\u0527\u0526\x03\x02\x02\x02\u0527\u0528\x03\x02\x02\x02\u0528\u0529" +
    "\x03\x02\x02\x02\u0529\u052A\x07l\x02\x02\u052A\u052D\x05b2\x02\u052B" +
    "\u052C\x07=\x02\x02\u052C\u052E\x05b2\x02\u052D\u052B\x03\x02\x02\x02" +
    "\u052D\u052E\x03\x02\x02\x02\u052E\u053C\x03\x02\x02\x02\u052F\u0531\x07" +
    "c\x02\x02\u0530\u0532\x07~\x02\x02\u0531\u0530\x03\x02\x02\x02\u0531\u0532" +
    "\x03\x02\x02\x02\u0532\u0533\x03\x02\x02\x02\u0533\u053C\x07\x7F\x02\x02" +
    "\u0534\u0536\x07c\x02\x02\u0535\u0537\x07~\x02\x02\u0536\u0535\x03\x02" +
    "\x02\x02\u0536\u0537\x03\x02\x02\x02\u0537\u0538\x03\x02\x02\x02\u0538" +
    "\u0539\x078\x02\x02\u0539\u053A\x07K\x02\x02\u053A\u053C\x05b2\x02\u053B" +
    "\u04FE\x03\x02\x02\x02\u053B\u0501\x03\x02\x02\x02\u053B\u0508\x03\x02" +
    "\x02\x02\u053B\u0510\x03\x02\x02\x02\u053B\u051F\x03\x02\x02\x02\u053B" +
    "\u0527\x03\x02\x02\x02\u053B\u052F\x03\x02\x02\x02\u053B\u0534\x03\x02" +
    "\x02\x02\u053Ca\x03\x02\x02\x02\u053D\u053E\b2\x01\x02\u053E\u0542\x05" +
    "d3\x02\u053F\u0540\t\r\x02\x02\u0540\u0542\x05b2\x06\u0541\u053D\x03\x02" +
    "\x02\x02\u0541\u053F\x03\x02\x02\x02\u0542\u0551\x03\x02\x02\x02\u0543" +
    "\u0544\f\x05\x02\x02\u0544\u0545\t\x0E\x02\x02\u0545\u0550\x05b2\x06\u0546" +
    "\u0547\f\x04\x02\x02\u0547\u0548\t\r\x02\x02\u0548\u0550\x05b2\x05\u0549" +
    "\u054A\f\x03\x02\x02\u054A\u054B\x07\xE3\x02\x02\u054B\u0550\x05b2\x04" +
    "\u054C\u054D\f\x07\x02\x02\u054D\u054E\x07\x16\x02\x02\u054E\u0550\x05" +
    "j6\x02\u054F\u0543\x03\x02\x02\x02\u054F\u0546\x03\x02\x02\x02\u054F\u0549" +
    "\x03\x02\x02\x02\u054F\u054C\x03\x02\x02\x02\u0550\u0553\x03\x02\x02\x02" +
    "\u0551\u054F\x03\x02\x02\x02\u0551\u0552\x03\x02\x02\x02\u0552c\x03\x02" +
    "\x02\x02\u0553\u0551\x03\x02\x02\x02\u0554\u0555\b3\x01\x02\u0555\u0644" +
    "\x07\x7F\x02\x02\u0556\u0644\x05r:\x02\u0557\u0558\x05\x9EP\x02\u0558" +
    "\u0559\x05f4\x02\u0559\u0644\x03\x02\x02\x02\u055A\u055B\x07\xF0\x02\x02" +
    "\u055B\u0644\x05f4\x02\u055C\u0644\x05\xA0Q\x02\u055D\u0644\x05p9\x02" +
    "\u055E\u0644\x05f4\x02\u055F\u0644\x07\xE6\x02\x02\u0560\u0644\x07\x07" +
    "\x02\x02\u0561\u0562\x07\x8E\x02\x02\u0562\u0563\x07\x04\x02\x02\u0563" +
    "\u0564\x05b2\x02\u0564\u0565\x07Y\x02\x02\u0565\u0566\x05b2\x02\u0566" +
    "\u0567\x07\x05\x02\x02\u0567\u0644\x03\x02\x02\x02\u0568\u0569\x07\x04" +
    "\x02\x02\u0569\u056C\x05V,\x02\u056A\u056B\x07\x06\x02\x02\u056B\u056D" +
    "\x05V,\x02\u056C\u056A\x03\x02\x02\x02\u056D\u056E\x03\x02\x02\x02\u056E" +
    "\u056C\x03\x02\x02\x02\u056E\u056F\x03\x02\x02\x02\u056F\u0570\x03\x02" +
    "\x02\x02\u0570\u0571\x07\x05\x02\x02\u0571\u0644\x03\x02\x02\x02\u0572" +
    "\u0573\x07\xA5\x02\x02\u0573\u0574\x07\x04\x02\x02\u0574\u0579\x05V,\x02" +
    "\u0575\u0576\x07\x06\x02\x02\u0576\u0578\x05V,\x02\u0577\u0575\x03\x02" +
    "\x02\x02\u0578\u057B\x03\x02\x02\x02\u0579\u0577\x03\x02\x02\x02\u0579" +
    "\u057A\x03\x02\x02\x02\u057A\u057C\x03\x02\x02\x02\u057B\u0579\x03\x02" +
    "\x02\x02\u057C\u057D\x07\x05\x02\x02\u057D\u0644\x03\x02\x02\x02\u057E" +
    "\u057F\x05\x94K\x02\u057F\u0580\x07\x04\x02\x02\u0580\u0581\x07\xE0\x02" +
    "\x02\u0581\u0583\x07\x05\x02\x02\u0582\u0584\x05\x82B\x02\u0583\u0582" +
    "\x03\x02\x02\x02\u0583\u0584\x03\x02\x02\x02\u0584\u0586\x03\x02\x02\x02" +
    "\u0585\u0587\x05\x84C\x02\u0586\u0585\x03\x02\x02\x02\u0586\u0587\x03" +
    "\x02\x02\x02\u0587\u0644\x03\x02\x02\x02\u0588\u0589\x05\x94K\x02\u0589" +
    "\u0595\x07\x04\x02\x02\u058A\u058C\x05B\"\x02\u058B\u058A\x03\x02\x02" +
    "\x02\u058B\u058C\x03\x02\x02\x02\u058C\u058D\x03\x02\x02\x02\u058D\u0592" +
    "\x05V,\x02\u058E\u058F\x07\x06\x02\x02\u058F\u0591\x05V,\x02\u0590\u058E" +
    "\x03\x02\x02\x02\u0591\u0594\x03\x02\x02\x02\u0592\u0590\x03\x02\x02\x02" +
    "\u0592\u0593\x03\x02\x02\x02\u0593\u0596\x03\x02\x02\x02\u0594\u0592\x03" +
    "\x02\x02\x02\u0595\u058B\x03\x02\x02\x02\u0595\u0596\x03\x02\x02\x02\u0596" +
    "\u05A1\x03\x02\x02\x02\u0597\u0598\x07\x87\x02\x02\u0598\u0599\x07\x19" +
    "\x02\x02\u0599\u059E\x056\x1C\x02\u059A\u059B\x07\x06\x02\x02\u059B\u059D" +
    "\x056\x1C\x02\u059C\u059A\x03\x02\x02\x02\u059D\u05A0\x03\x02\x02\x02" +
    "\u059E\u059C\x03\x02\x02\x02\u059E\u059F\x03\x02\x02\x02\u059F\u05A2\x03" +
    "\x02\x02\x02\u05A0\u059E\x03\x02\x02\x02\u05A1\u0597\x03\x02\x02\x02\u05A1" +
    "\u05A2\x03\x02\x02\x02\u05A2\u05A3\x03\x02\x02\x02\u05A3\u05A5\x07\x05" +
    "\x02\x02\u05A4\u05A6\x05\x82B\x02\u05A5\u05A4\x03\x02\x02\x02\u05A5\u05A6" +
    "\x03\x02\x02\x02\u05A6\u05AB\x03\x02\x02\x02\u05A7\u05A9\x05h5\x02\u05A8" +
    "\u05A7\x03\x02\x02\x02\u05A8\u05A9\x03\x02\x02\x02\u05A9\u05AA\x03\x02" +
    "\x02\x02\u05AA\u05AC\x05\x84C\x02\u05AB\u05A8\x03\x02\x02\x02\u05AB\u05AC" +
    "\x03\x02\x02\x02\u05AC\u0644\x03\x02\x02\x02\u05AD\u05AE\x05\x9EP\x02" +
    "\u05AE\u05AF\x07\b\x02\x02\u05AF\u05B0\x05V,\x02\u05B0\u0644\x03\x02\x02" +
    "\x02\u05B1\u05BA\x07\x04\x02\x02\u05B2\u05B7\x05\x9EP\x02\u05B3\u05B4" +
    "\x07\x06\x02\x02\u05B4\u05B6\x05\x9EP\x02\u05B5\u05B3\x03\x02\x02\x02" +
    "\u05B6\u05B9\x03\x02\x02\x02\u05B7\u05B5\x03\x02\x02\x02\u05B7\u05B8\x03" +
    "\x02\x02\x02\u05B8\u05BB\x03\x02\x02\x02\u05B9\u05B7\x03\x02\x02\x02\u05BA" +
    "\u05B2\x03\x02\x02\x02\u05BA\u05BB\x03\x02\x02\x02\u05BB\u05BC\x03\x02" +
    "\x02\x02\u05BC\u05BD\x07\x05\x02\x02\u05BD\u05BE\x07\b\x02\x02\u05BE\u0644" +
    "\x05V,\x02\u05BF\u05C0\x07\x04\x02\x02\u05C0\u05C1\x05\n\x06\x02\u05C1" +
    "\u05C2\x07\x05\x02\x02\u05C2\u0644\x03\x02\x02\x02\u05C3\u05C4\x07A\x02" +
    "\x02\u05C4\u05C5\x07\x04\x02\x02\u05C5\u05C6\x05\n\x06\x02\u05C6\u05C7" +
    "\x07\x05\x02\x02\u05C7\u0644\x03\x02\x02\x02\u05C8\u05C9\x07\x1D\x02\x02" +
    "\u05C9\u05CB\x05b2\x02\u05CA\u05CC\x05\x80A\x02\u05CB\u05CA\x03\x02\x02" +
    "\x02\u05CC\u05CD\x03\x02\x02\x02\u05CD\u05CB\x03\x02\x02\x02\u05CD\u05CE" +
    "\x03\x02\x02\x02\u05CE\u05D1\x03\x02\x02\x02\u05CF\u05D0\x07;\x02\x02" +
    "\u05D0\u05D2\x05V,\x02\u05D1\u05CF\x03\x02\x02\x02\u05D1\u05D2\x03\x02" +
    "\x02\x02\u05D2\u05D3\x03\x02\x02\x02\u05D3\u05D4\x07<\x02\x02\u05D4\u0644" +
    "\x03\x02\x02\x02\u05D5\u05D7\x07\x1D\x02\x02\u05D6\u05D8\x05\x80A\x02" +
    "\u05D7\u05D6\x03\x02\x02\x02\u05D8\u05D9\x03\x02\x02\x02\u05D9\u05D7\x03" +
    "\x02\x02\x02\u05D9\u05DA\x03\x02\x02\x02\u05DA\u05DD\x03\x02\x02\x02\u05DB" +
    "\u05DC\x07;\x02\x02\u05DC\u05DE\x05V,\x02\u05DD\u05DB\x03\x02\x02\x02" +
    "\u05DD\u05DE\x03\x02\x02\x02\u05DE\u05DF\x03\x02\x02\x02\u05DF\u05E0\x07" +
    "<\x02\x02\u05E0\u0644\x03\x02\x02\x02\u05E1\u05E2\x07\x1E\x02\x02\u05E2" +
    "\u05E3\x07\x04\x02\x02\u05E3\u05E4\x05V,\x02\u05E4\u05E5\x07\x14\x02\x02" +
    "\u05E5\u05E6\x05z>\x02\u05E6\u05E7\x07\x05\x02\x02\u05E7\u0644\x03\x02" +
    "\x02\x02\u05E8\u05E9\x07\xC2\x02\x02\u05E9\u05EA\x07\x04\x02\x02\u05EA" +
    "\u05EB\x05V,\x02\u05EB\u05EC\x07\x14\x02\x02\u05EC\u05ED\x05z>\x02\u05ED" +
    "\u05EE\x07\x05\x02\x02\u05EE\u0644\x03\x02\x02\x02\u05EF\u05F0\x07\x13" +
    "\x02\x02\u05F0\u05F9\x07\t\x02\x02\u05F1\u05F6\x05V,\x02\u05F2\u05F3\x07" +
    "\x06\x02\x02\u05F3\u05F5\x05V,\x02\u05F4\u05F2\x03\x02\x02\x02\u05F5\u05F8" +
    "\x03\x02\x02\x02\u05F6\u05F4\x03\x02\x02\x02\u05F6\u05F7\x03\x02\x02\x02" +
    "\u05F7\u05FA\x03\x02\x02\x02\u05F8\u05F6\x03\x02\x02\x02\u05F9\u05F1\x03" +
    "\x02\x02\x02\u05F9\u05FA\x03\x02\x02\x02\u05FA\u05FB\x03\x02\x02\x02\u05FB" +
    "\u0644\x07\n\x02\x02\u05FC\u0644\x05\x9EP\x02\u05FD\u0644\x07*\x02\x02" +
    "\u05FE\u0602\x07,\x02\x02\u05FF\u0600\x07\x04\x02\x02\u0600\u0601\x07" +
    "\xE7\x02\x02\u0601\u0603\x07\x05\x02\x02\u0602\u05FF\x03\x02\x02\x02\u0602" +
    "\u0603\x03\x02\x02\x02\u0603\u0644\x03\x02\x02\x02\u0604\u0608\x07-\x02" +
    "\x02\u0605\u0606\x07\x04\x02\x02\u0606\u0607\x07\xE7\x02\x02\u0607\u0609" +
    "\x07\x05\x02\x02\u0608\u0605\x03\x02\x02\x02\u0608\u0609\x03\x02\x02\x02" +
    "\u0609\u0644\x03\x02\x02\x02\u060A\u060E\x07n\x02\x02\u060B\u060C\x07" +
    "\x04\x02\x02\u060C\u060D\x07\xE7\x02\x02\u060D\u060F\x07\x05\x02\x02\u060E" +
    "\u060B\x03\x02\x02\x02\u060E\u060F\x03\x02\x02\x02\u060F\u0644\x03\x02" +
    "\x02\x02\u0610\u0614\x07o\x02\x02\u0611\u0612\x07";
SqlBaseParser._serializedATNSegment3 = "\x04\x02\x02\u0612\u0613\x07\xE7\x02\x02\u0613\u0615\x07\x05\x02\x02\u0614" +
    "\u0611\x03\x02\x02\x02\u0614\u0615\x03\x02\x02\x02\u0615\u0644\x03\x02" +
    "\x02\x02\u0616\u0644\x07.\x02\x02\u0617\u0618\x07\xB5\x02\x02\u0618\u0619" +
    "\x07\x04\x02\x02\u0619\u061A\x05b2\x02\u061A\u061B\x07K\x02\x02\u061B" +
    "\u061E\x05b2\x02\u061C\u061D\x07I\x02\x02\u061D\u061F\x05b2\x02\u061E" +
    "\u061C\x03\x02\x02\x02\u061E\u061F\x03\x02\x02\x02\u061F\u0620\x03\x02" +
    "\x02\x02\u0620\u0621\x07\x05\x02\x02\u0621\u0644\x03\x02\x02\x02\u0622" +
    "\u0623\x07}\x02\x02\u0623\u0624\x07\x04\x02\x02\u0624\u0627\x05b2\x02" +
    "\u0625\u0626\x07\x06\x02\x02\u0626\u0628\x05v<\x02\u0627\u0625\x03\x02" +
    "\x02\x02\u0627\u0628\x03\x02\x02\x02\u0628\u0629\x03\x02\x02\x02\u0629" +
    "\u062A\x07\x05\x02\x02\u062A\u0644\x03\x02\x02\x02\u062B\u062C\x07C\x02" +
    "\x02\u062C\u062D\x07\x04\x02\x02\u062D\u062E\x05\x9EP\x02\u062E\u062F" +
    "\x07K\x02\x02\u062F\u0630\x05b2\x02\u0630\u0631\x07\x05\x02\x02\u0631" +
    "\u0644\x03\x02\x02\x02\u0632\u0633\x07\x04\x02\x02\u0633\u0634\x05V,\x02" +
    "\u0634\u0635\x07\x05\x02\x02\u0635\u0644\x03\x02\x02\x02\u0636\u0637\x07" +
    "T\x02\x02\u0637\u0640\x07\x04\x02\x02\u0638\u063D\x05\x94K\x02\u0639\u063A" +
    "\x07\x06\x02\x02\u063A\u063C\x05\x94K\x02\u063B\u0639\x03\x02\x02\x02" +
    "\u063C\u063F\x03\x02\x02\x02\u063D\u063B\x03\x02\x02\x02\u063D\u063E\x03" +
    "\x02\x02\x02\u063E\u0641\x03\x02\x02\x02\u063F\u063D\x03\x02\x02\x02\u0640" +
    "\u0638\x03\x02\x02\x02\u0640\u0641\x03\x02\x02\x02\u0641\u0642\x03\x02" +
    "\x02\x02\u0642\u0644\x07\x05\x02\x02\u0643\u0554\x03\x02\x02\x02\u0643" +
    "\u0556\x03\x02\x02\x02\u0643\u0557\x03\x02\x02\x02\u0643\u055A\x03\x02" +
    "\x02\x02\u0643\u055C\x03\x02\x02\x02\u0643\u055D\x03\x02\x02\x02\u0643" +
    "\u055E\x03\x02\x02\x02\u0643\u055F\x03\x02\x02\x02\u0643\u0560\x03\x02" +
    "\x02\x02\u0643\u0561\x03\x02\x02\x02\u0643\u0568\x03\x02\x02\x02\u0643" +
    "\u0572\x03\x02\x02\x02\u0643\u057E\x03\x02\x02\x02\u0643\u0588\x03\x02" +
    "\x02\x02\u0643\u05AD\x03\x02\x02\x02\u0643\u05B1\x03\x02\x02\x02\u0643" +
    "\u05BF\x03\x02\x02\x02\u0643\u05C3\x03\x02\x02\x02\u0643\u05C8\x03\x02" +
    "\x02\x02\u0643\u05D5\x03\x02\x02\x02\u0643\u05E1\x03\x02\x02\x02\u0643" +
    "\u05E8\x03\x02\x02\x02\u0643\u05EF\x03\x02\x02\x02\u0643\u05FC\x03\x02" +
    "\x02\x02\u0643\u05FD\x03\x02\x02\x02\u0643\u05FE\x03\x02\x02\x02\u0643" +
    "\u0604\x03\x02\x02\x02\u0643\u060A\x03\x02\x02\x02\u0643\u0610\x03\x02" +
    "\x02\x02\u0643\u0616\x03\x02\x02\x02\u0643\u0617\x03\x02\x02\x02\u0643" +
    "\u0622\x03\x02\x02\x02\u0643\u062B\x03\x02\x02\x02\u0643\u0632\x03\x02" +
    "\x02\x02\u0643\u0636\x03\x02\x02\x02\u0644\u064F\x03\x02\x02\x02\u0645" +
    "\u0646\f\x10\x02\x02\u0646\u0647\x07\t\x02\x02\u0647\u0648\x05b2\x02\u0648" +
    "\u0649\x07\n\x02\x02\u0649\u064E\x03\x02\x02\x02\u064A\u064B\f\x0E\x02" +
    "\x02\u064B\u064C\x07\x03\x02\x02\u064C\u064E\x05\x9EP\x02\u064D\u0645" +
    "\x03\x02\x02\x02\u064D\u064A\x03\x02\x02\x02\u064E\u0651\x03\x02\x02\x02" +
    "\u064F\u064D\x03\x02\x02\x02\u064F\u0650\x03\x02\x02\x02\u0650e\x03\x02" +
    "\x02\x02\u0651\u064F\x03\x02\x02\x02\u0652\u0659\x07\xE4\x02\x02\u0653" +
    "\u0656\x07\xE5\x02\x02\u0654\u0655\x07\xC4\x02\x02\u0655\u0657\x07\xE4" +
    "\x02\x02\u0656\u0654\x03\x02\x02\x02\u0656\u0657\x03\x02\x02\x02\u0657" +
    "\u0659\x03\x02\x02\x02\u0658\u0652\x03\x02\x02\x02\u0658\u0653\x03\x02" +
    "\x02\x02\u0659g\x03\x02\x02\x02\u065A\u065B\x07X\x02\x02\u065B\u065F\x07" +
    "\x81\x02\x02\u065C\u065D\x07\x9B\x02\x02\u065D\u065F\x07\x81\x02\x02\u065E" +
    "\u065A\x03\x02\x02\x02\u065E\u065C\x03\x02\x02\x02\u065Fi\x03\x02\x02" +
    "\x02\u0660\u0661\x07\xBD\x02\x02\u0661\u0662\x07\xD7\x02\x02\u0662\u0667" +
    "\x05r:\x02\u0663\u0664\x07\xBD\x02\x02\u0664\u0665\x07\xD7\x02\x02\u0665" +
    "\u0667\x05f4\x02\u0666\u0660\x03\x02\x02\x02\u0666\u0663\x03\x02\x02\x02" +
    "\u0667k\x03\x02\x02\x02\u0668\u0669\t\x0F\x02\x02\u0669m\x03\x02\x02\x02" +
    "\u066A\u066B\t\x10\x02\x02\u066Bo\x03\x02\x02\x02\u066C\u066D\t\x11\x02" +
    "\x02\u066Dq\x03\x02\x02\x02\u066E\u0670\x07_\x02\x02\u066F\u0671\t\r\x02" +
    "\x02\u0670\u066F\x03\x02\x02\x02\u0670\u0671\x03\x02\x02\x02\u0671\u0672" +
    "\x03\x02\x02\x02\u0672\u0673\x05f4\x02\u0673\u0676\x05t;\x02\u0674\u0675" +
    "\x07\xBF\x02\x02\u0675\u0677\x05t;\x02\u0676\u0674\x03\x02\x02\x02\u0676" +
    "\u0677\x03\x02\x02\x02\u0677s\x03\x02\x02\x02\u0678\u0679\t\x12\x02\x02" +
    "\u0679u\x03\x02\x02\x02\u067A\u067B\t\x13\x02\x02\u067Bw\x03\x02\x02\x02" +
    "\u067C\u0685\x07\x04\x02\x02\u067D\u0682\x05z>\x02\u067E\u067F\x07\x06" +
    "\x02\x02\u067F\u0681\x05z>\x02\u0680\u067E\x03\x02\x02\x02\u0681\u0684" +
    "\x03\x02\x02\x02\u0682\u0680\x03\x02\x02\x02\u0682\u0683\x03\x02\x02\x02" +
    "\u0683\u0686\x03\x02\x02\x02\u0684\u0682\x03\x02\x02\x02\u0685\u067D\x03" +
    "\x02\x02\x02\u0685\u0686\x03\x02\x02\x02\u0686\u0687\x03\x02\x02\x02\u0687" +
    "\u0688\x07\x05\x02\x02\u0688y\x03\x02\x02\x02\u0689\u068A\b>\x01\x02\u068A" +
    "\u068B\x07\x13\x02\x02\u068B\u068C\x07\xDA\x02\x02\u068C\u068D\x05z>\x02" +
    "\u068D\u068E\x07\xDC\x02\x02\u068E\u06B9\x03\x02\x02\x02\u068F\u0690\x07" +
    "q\x02\x02\u0690\u0691\x07\xDA\x02\x02\u0691\u0692\x05z>\x02\u0692\u0693" +
    "\x07\x06\x02\x02\u0693\u0694\x05z>\x02\u0694\u0695\x07\xDC\x02\x02\u0695" +
    "\u06B9\x03\x02\x02\x02\u0696\u0697\x07\xA5\x02\x02\u0697\u0698\x07\x04" +
    "\x02\x02\u0698\u0699\x05\x9EP\x02\u0699\u06A0\x05z>\x02\u069A\u069B\x07" +
    "\x06\x02\x02\u069B\u069C\x05\x9EP\x02\u069C\u069D\x05z>\x02\u069D\u069F" +
    "\x03\x02\x02\x02\u069E\u069A\x03\x02\x02\x02\u069F\u06A2\x03\x02\x02\x02" +
    "\u06A0\u069E\x03\x02\x02\x02\u06A0\u06A1\x03\x02\x02\x02\u06A1\u06A3\x03" +
    "\x02\x02\x02\u06A2\u06A0\x03\x02\x02\x02\u06A3\u06A4\x07\x05\x02\x02\u06A4" +
    "\u06B9\x03\x02\x02\x02\u06A5\u06B1\x05~@\x02\u06A6\u06A7\x07\x04\x02\x02" +
    "\u06A7\u06AC\x05|?\x02\u06A8\u06A9\x07\x06\x02\x02\u06A9\u06AB\x05|?\x02" +
    "\u06AA\u06A8\x03\x02\x02\x02\u06AB\u06AE\x03\x02\x02\x02\u06AC\u06AA\x03" +
    "\x02\x02\x02\u06AC\u06AD\x03\x02\x02\x02\u06AD\u06AF\x03\x02\x02\x02\u06AE" +
    "\u06AC\x03\x02\x02\x02\u06AF\u06B0\x07\x05\x02\x02\u06B0\u06B2\x03\x02" +
    "\x02\x02\u06B1\u06A6\x03\x02\x02\x02\u06B1\u06B2\x03\x02\x02\x02\u06B2" +
    "\u06B9\x03\x02\x02\x02\u06B3\u06B4\x07_\x02\x02\u06B4\u06B5\x05t;\x02" +
    "\u06B5\u06B6\x07\xBF\x02\x02\u06B6\u06B7\x05t;\x02\u06B7\u06B9\x03\x02" +
    "\x02\x02\u06B8\u0689\x03\x02\x02\x02\u06B8\u068F\x03\x02\x02\x02\u06B8" +
    "\u0696\x03\x02\x02\x02\u06B8\u06A5\x03\x02\x02\x02\u06B8\u06B3\x03\x02" +
    "\x02\x02\u06B9\u06BE\x03\x02\x02\x02\u06BA\u06BB\f\b\x02\x02\u06BB\u06BD" +
    "\x07\x13\x02\x02\u06BC\u06BA\x03\x02\x02\x02\u06BD\u06C0\x03\x02\x02\x02" +
    "\u06BE\u06BC\x03\x02\x02\x02\u06BE\u06BF\x03\x02\x02\x02\u06BF{\x03\x02" +
    "\x02\x02\u06C0\u06BE\x03\x02\x02\x02\u06C1\u06C4\x07\xE7\x02\x02\u06C2" +
    "\u06C4\x05z>\x02\u06C3\u06C1\x03\x02\x02\x02\u06C3\u06C2\x03\x02\x02\x02" +
    "\u06C4}\x03\x02\x02\x02\u06C5\u06CA\x07\xEE\x02\x02\u06C6\u06CA\x07\xEF" +
    "\x02\x02\u06C7\u06CA\x07\xF0\x02\x02\u06C8\u06CA\x05\x94K\x02\u06C9\u06C5" +
    "\x03\x02\x02\x02\u06C9\u06C6\x03\x02\x02\x02\u06C9\u06C7\x03\x02\x02\x02" +
    "\u06C9\u06C8\x03\x02\x02\x02\u06CA\x7F\x03\x02\x02\x02\u06CB\u06CC\x07" +
    "\xD1\x02\x02\u06CC\u06CD\x05V,\x02\u06CD\u06CE\x07\xBC\x02\x02\u06CE\u06CF" +
    "\x05V,\x02\u06CF\x81\x03\x02\x02\x02\u06D0\u06D1\x07F\x02\x02\u06D1\u06D2" +
    "\x07\x04\x02\x02\u06D2\u06D3\x07\xD2\x02\x02\u06D3\u06D4\x05^0\x02\u06D4" +
    "\u06D5\x07\x05\x02\x02\u06D5\x83\x03\x02\x02\x02\u06D6\u06D7\x07\x8B\x02" +
    "\x02\u06D7\u06E2\x07\x04\x02\x02\u06D8\u06D9\x07\x8C\x02\x02\u06D9\u06DA" +
    "\x07\x19\x02\x02\u06DA\u06DF\x05V,\x02\u06DB\u06DC\x07\x06\x02\x02\u06DC" +
    "\u06DE\x05V,\x02\u06DD\u06DB\x03\x02\x02\x02\u06DE\u06E1\x03\x02\x02\x02" +
    "\u06DF\u06DD\x03\x02\x02\x02\u06DF\u06E0\x03\x02\x02\x02\u06E0\u06E3\x03" +
    "\x02\x02\x02\u06E1\u06DF\x03\x02\x02\x02\u06E2\u06D8\x03\x02\x02\x02\u06E2" +
    "\u06E3\x03\x02\x02\x02\u06E3\u06EE\x03\x02\x02\x02\u06E4\u06E5\x07\x87" +
    "\x02\x02\u06E5\u06E6\x07\x19\x02\x02\u06E6\u06EB\x056\x1C\x02\u06E7\u06E8" +
    "\x07\x06\x02\x02\u06E8\u06EA\x056\x1C\x02\u06E9\u06E7\x03\x02\x02\x02" +
    "\u06EA\u06ED\x03\x02\x02\x02\u06EB\u06E9\x03\x02\x02\x02\u06EB\u06EC\x03" +
    "\x02\x02\x02\u06EC\u06EF\x03\x02\x02\x02\u06ED\u06EB\x03\x02\x02\x02\u06EE" +
    "\u06E4\x03\x02\x02\x02\u06EE\u06EF\x03\x02\x02\x02\u06EF\u06F1\x03\x02" +
    "\x02\x02\u06F0\u06F2\x05\x86D\x02\u06F1\u06F0\x03\x02\x02\x02\u06F1\u06F2" +
    "\x03\x02\x02\x02\u06F2\u06F3\x03\x02\x02\x02\u06F3\u06F4\x07\x05\x02\x02" +
    "\u06F4\x85\x03\x02\x02\x02\u06F5\u06F6\x07\x93\x02\x02\u06F6\u0706\x05" +
    "\x88E\x02\u06F7\u06F8\x07\xA6\x02\x02\u06F8\u0706\x05\x88E\x02\u06F9\u06FA" +
    "\x07\x93\x02\x02\u06FA\u06FB\x07\x18\x02\x02\u06FB\u06FC\x05\x88E\x02" +
    "\u06FC\u06FD\x07\x11\x02\x02\u06FD\u06FE\x05\x88E\x02\u06FE\u0706\x03" +
    "\x02\x02\x02\u06FF\u0700\x07\xA6\x02\x02\u0700\u0701\x07\x18\x02\x02\u0701" +
    "\u0702\x05\x88E\x02\u0702\u0703\x07\x11\x02\x02\u0703\u0704\x05\x88E\x02" +
    "\u0704\u0706\x03\x02\x02\x02\u0705\u06F5\x03\x02\x02\x02\u0705\u06F7\x03" +
    "\x02\x02\x02\u0705\u06F9\x03\x02\x02\x02\u0705\u06FF\x03\x02\x02\x02\u0706" +
    "\x87\x03\x02\x02\x02\u0707\u0708\x07\xC5\x02\x02\u0708\u0711\x07\x8F\x02" +
    "\x02\u0709\u070A\x07\xC5\x02\x02\u070A\u0711\x07H\x02\x02\u070B\u070C" +
    "\x07)\x02\x02\u070C\u0711\x07\xA5\x02\x02\u070D\u070E\x05V,\x02\u070E" +
    "\u070F\t\x14\x02\x02\u070F\u0711\x03\x02\x02\x02\u0710\u0707\x03\x02\x02" +
    "\x02\u0710\u0709\x03\x02\x02\x02\u0710\u070B\x03\x02\x02\x02\u0710\u070D" +
    "\x03\x02\x02\x02\u0711\x89\x03\x02\x02\x02\u0712\u0713\x07J\x02\x02\u0713" +
    "\u0717\t\x15\x02\x02\u0714\u0715\x07\xC3\x02\x02\u0715\u0717\t\x16\x02" +
    "\x02\u0716\u0712\x03\x02\x02\x02\u0716\u0714\x03\x02\x02\x02\u0717\x8B" +
    "\x03\x02\x02\x02\u0718\u0719\x07d\x02\x02\u0719\u071A\x07k\x02\x02\u071A" +
    "\u071E\x05\x8EH\x02\u071B\u071C\x07\x94\x02\x02\u071C\u071E\t\x17\x02" +
    "\x02\u071D\u0718\x03\x02\x02\x02\u071D\u071B\x03\x02\x02\x02\u071E\x8D" +
    "\x03\x02\x02\x02\u071F\u0720\x07\x94\x02\x02\u0720\u0727\x07\xC6\x02\x02" +
    "\u0721\u0722\x07\x94\x02\x02\u0722\u0727\x07$\x02\x02\u0723\u0724\x07" +
    "\x98\x02\x02\u0724\u0727\x07\x94\x02\x02\u0725\u0727\x07\xAC\x02\x02\u0726" +
    "\u071F\x03\x02\x02\x02\u0726\u0721\x03\x02\x02\x02\u0726\u0723\x03\x02" +
    "\x02\x02\u0726\u0725\x03\x02\x02\x02\u0727\x8F\x03\x02\x02\x02\u0728\u072E" +
    "\x05V,\x02\u0729\u072A\x05\x9EP\x02\u072A\u072B\x07\v\x02\x02\u072B\u072C" +
    "\x05V,\x02\u072C\u072E\x03\x02\x02\x02\u072D\u0728\x03\x02\x02\x02\u072D" +
    "\u0729\x03\x02\x02\x02\u072E\x91\x03\x02\x02\x02\u072F\u0734\x07\xAB\x02" +
    "\x02\u0730\u0734\x074\x02\x02\u0731\u0734\x07]\x02\x02\u0732\u0734\x05" +
    "\x9EP\x02\u0733\u072F\x03\x02\x02\x02\u0733\u0730\x03\x02\x02\x02\u0733" +
    "\u0731\x03\x02\x02\x02\u0733\u0732\x03\x02\x02\x02\u0734\x93\x03\x02\x02" +
    "\x02\u0735\u073A\x05\x9EP\x02\u0736\u0737\x07\x03\x02\x02\u0737\u0739" +
    "\x05\x9EP\x02\u0738\u0736\x03\x02\x02\x02\u0739\u073C\x03\x02\x02\x02" +
    "\u073A\u0738\x03\x02\x02\x02\u073A\u073B\x03\x02\x02\x02\u073B\x95\x03" +
    "\x02\x02\x02\u073C\u073A\x03\x02\x02\x02\u073D\u0742\x05\x9EP\x02\u073E" +
    "\u0740\x07\x14\x02\x02\u073F\u073E\x03\x02\x02\x02\u073F\u0740\x03\x02" +
    "\x02\x02\u0740\u0741\x03\x02\x02\x02\u0741\u0743\x05\x9EP\x02\u0742\u073F" +
    "\x03\x02\x02\x02\u0742\u0743\x03\x02\x02\x02\u0743\x97\x03\x02\x02\x02" +
    "\u0744\u0748\x07.\x02\x02\u0745\u0748\x07+\x02\x02\u0746\u0748\x05\x9A" +
    "N\x02\u0747\u0744\x03\x02\x02\x02\u0747\u0745\x03\x02\x02\x02\u0747\u0746" +
    "\x03\x02\x02\x02\u0748\x99\x03\x02\x02\x02\u0749\u074A\x07\xCB\x02\x02" +
    "\u074A\u074F\x05\x9EP\x02\u074B\u074C\x07\xA1\x02\x02\u074C\u074F\x05" +
    "\x9EP\x02\u074D\u074F\x05\x9EP\x02\u074E\u0749\x03\x02\x02\x02\u074E\u074B" +
    "\x03\x02\x02\x02\u074E\u074D\x03\x02\x02\x02\u074F\x9B\x03\x02\x02\x02" +
    "\u0750\u0755\x05\x9EP\x02\u0751\u0752\x07\x06\x02\x02\u0752\u0754\x05" +
    "\x9EP\x02\u0753\u0751\x03\x02\x02\x02\u0754\u0757\x03\x02\x02\x02\u0755" +
    "\u0753\x03\x02\x02\x02\u0755\u0756\x03\x02\x02\x02\u0756\x9D\x03\x02\x02" +
    "\x02\u0757\u0755\x03\x02\x02\x02\u0758\u075E\x07\xEA\x02\x02\u0759\u075E" +
    "\x07\xEC\x02\x02\u075A\u075E\x05\xA2R\x02\u075B\u075E\x07\xED\x02\x02" +
    "\u075C\u075E\x07\xEB\x02\x02\u075D\u0758\x03\x02\x02\x02\u075D\u0759\x03" +
    "\x02\x02\x02\u075D\u075A\x03\x02\x02\x02\u075D\u075B\x03\x02\x02\x02\u075D" +
    "\u075C\x03\x02\x02\x02\u075E\x9F\x03\x02\x02\x02\u075F\u0763\x07\xE8\x02" +
    "\x02\u0760\u0763\x07\xE9\x02\x02\u0761\u0763\x07\xE7\x02\x02\u0762\u075F" +
    "\x03\x02\x02\x02\u0762\u0760\x03\x02\x02\x02\u0762\u0761\x03\x02\x02\x02" +
    "\u0763\xA1\x03\x02\x02\x02\u0764\u0765\t\x18\x02\x02\u0765\xA3\x03\x02" +
    "\x02\x02\xF4\xBA\xBF\xC5\xC9\xD7\xDB\xDF\xE3\xEB\xEF\xF2\xF9\u0102\u0108" +
    "\u010C\u0112\u0119\u0125\u012A\u0131\u0137\u0142\u0149\u0153\u015A\u0162" +
    "\u016A\u0172\u017E\u0184\u0189\u018F\u0198\u01A1\u01A6\u01AA\u01B2\u01B9" +
    "\u01C6\u01C9\u01D3\u01D6\u01DD\u01E6\u01EC\u01F1\u01F5\u01FF\u0202\u020C" +
    "\u0219\u021F\u0224\u022A\u0233\u0239\u0240\u0248\u024D\u0251\u0259\u025F" +
    "\u0266\u026B\u026F\u0279\u027C\u0280\u0283\u028B\u0290\u02A5\u02AB\u02B1" +
    "\u02B3\u02B9\u02BF\u02C1\u02C7\u02DA\u02DF\u02E6\u02F2\u02F4\u0308\u030B" +
    "\u030F\u0313\u0325\u0328\u0330\u0333\u0339\u0340\u0345\u034B\u034F\u0353" +
    "\u0359\u0361\u0370\u0377\u037C\u0383\u038B\u038F\u0394\u039F\u03AB\u03AE" +
    "\u03B3\u03B5\u03B9\u03C1\u03C7\u03CA\u03CC\u03D8\u03DF\u03E3\u03E7\u03EB" +
    "\u03F2\u03FB\u03FE\u0402\u0407\u040B\u040E\u0415\u0420\u0423\u042D\u0430" +
    "\u043B\u0440\u0448\u044B\u044F\u0453\u045E\u0461\u0468\u047B\u047F\u0483" +
    "\u0487\u048B\u048F\u0491\u049C\u04A1\u04AA\u04B0\u04B4\u04B6\u04BE\u04CF" +
    "\u04D5\u04E0\u04ED\u04F1\u04F9\u04FB\u0508\u0510\u0519\u051F\u0527\u052D" +
    "\u0531\u0536\u053B\u0541\u054F\u0551\u056E\u0579\u0583\u0586\u058B\u0592" +
    "\u0595\u059E\u05A1\u05A5\u05A8\u05AB\u05B7\u05BA\u05CD\u05D1\u05D9\u05DD" +
    "\u05F6\u05F9\u0602\u0608\u060E\u0614\u061E\u0627\u063D\u0640\u0643\u064D" +
    "\u064F\u0656\u0658\u065E\u0666\u0670\u0676\u0682\u0685\u06A0\u06AC\u06B1" +
    "\u06B8\u06BE\u06C3\u06C9\u06DF\u06E2\u06EB\u06EE\u06F1\u0705\u0710\u0716" +
    "\u071D\u0726\u072D\u0733\u073A\u073F\u0742\u0747\u074E\u0755\u075D\u0762";
SqlBaseParser._serializedATN = Utils.join([
    SqlBaseParser._serializedATNSegment0,
    SqlBaseParser._serializedATNSegment1,
    SqlBaseParser._serializedATNSegment2,
    SqlBaseParser._serializedATNSegment3,
], "");
class SingleStatementContext extends ParserRuleContext_1.ParserRuleContext {
    statement() {
        return this.getRuleContext(0, StatementContext);
    }
    EOF() { return this.getToken(SqlBaseParser.EOF, 0); }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_singleStatement; }
    // @Override
    enterRule(listener) {
        if (listener.enterSingleStatement) {
            listener.enterSingleStatement(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSingleStatement) {
            listener.exitSingleStatement(this);
        }
    }
}
exports.SingleStatementContext = SingleStatementContext;
class StandaloneExpressionContext extends ParserRuleContext_1.ParserRuleContext {
    expression() {
        return this.getRuleContext(0, ExpressionContext);
    }
    EOF() { return this.getToken(SqlBaseParser.EOF, 0); }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_standaloneExpression; }
    // @Override
    enterRule(listener) {
        if (listener.enterStandaloneExpression) {
            listener.enterStandaloneExpression(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitStandaloneExpression) {
            listener.exitStandaloneExpression(this);
        }
    }
}
exports.StandaloneExpressionContext = StandaloneExpressionContext;
class StandaloneRoutineBodyContext extends ParserRuleContext_1.ParserRuleContext {
    routineBody() {
        return this.getRuleContext(0, RoutineBodyContext);
    }
    EOF() { return this.getToken(SqlBaseParser.EOF, 0); }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_standaloneRoutineBody; }
    // @Override
    enterRule(listener) {
        if (listener.enterStandaloneRoutineBody) {
            listener.enterStandaloneRoutineBody(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitStandaloneRoutineBody) {
            listener.exitStandaloneRoutineBody(this);
        }
    }
}
exports.StandaloneRoutineBodyContext = StandaloneRoutineBodyContext;
class StatementContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_statement; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.StatementContext = StatementContext;
class StatementDefaultContext extends StatementContext {
    query() {
        return this.getRuleContext(0, QueryContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterStatementDefault) {
            listener.enterStatementDefault(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitStatementDefault) {
            listener.exitStatementDefault(this);
        }
    }
}
exports.StatementDefaultContext = StatementDefaultContext;
class UseContext extends StatementContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    USE() { return this.getToken(SqlBaseParser.USE, 0); }
    identifier(i) {
        if (i === undefined) {
            return this.getRuleContexts(IdentifierContext);
        }
        else {
            return this.getRuleContext(i, IdentifierContext);
        }
    }
    // @Override
    enterRule(listener) {
        if (listener.enterUse) {
            listener.enterUse(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitUse) {
            listener.exitUse(this);
        }
    }
}
exports.UseContext = UseContext;
class CreateSchemaContext extends StatementContext {
    CREATE() { return this.getToken(SqlBaseParser.CREATE, 0); }
    SCHEMA() { return this.getToken(SqlBaseParser.SCHEMA, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    IF() { return this.tryGetToken(SqlBaseParser.IF, 0); }
    NOT() { return this.tryGetToken(SqlBaseParser.NOT, 0); }
    EXISTS() { return this.tryGetToken(SqlBaseParser.EXISTS, 0); }
    WITH() { return this.tryGetToken(SqlBaseParser.WITH, 0); }
    properties() {
        return this.tryGetRuleContext(0, PropertiesContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterCreateSchema) {
            listener.enterCreateSchema(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitCreateSchema) {
            listener.exitCreateSchema(this);
        }
    }
}
exports.CreateSchemaContext = CreateSchemaContext;
class DropSchemaContext extends StatementContext {
    DROP() { return this.getToken(SqlBaseParser.DROP, 0); }
    SCHEMA() { return this.getToken(SqlBaseParser.SCHEMA, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    IF() { return this.tryGetToken(SqlBaseParser.IF, 0); }
    EXISTS() { return this.tryGetToken(SqlBaseParser.EXISTS, 0); }
    CASCADE() { return this.tryGetToken(SqlBaseParser.CASCADE, 0); }
    RESTRICT() { return this.tryGetToken(SqlBaseParser.RESTRICT, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterDropSchema) {
            listener.enterDropSchema(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitDropSchema) {
            listener.exitDropSchema(this);
        }
    }
}
exports.DropSchemaContext = DropSchemaContext;
class RenameSchemaContext extends StatementContext {
    ALTER() { return this.getToken(SqlBaseParser.ALTER, 0); }
    SCHEMA() { return this.getToken(SqlBaseParser.SCHEMA, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    RENAME() { return this.getToken(SqlBaseParser.RENAME, 0); }
    TO() { return this.getToken(SqlBaseParser.TO, 0); }
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterRenameSchema) {
            listener.enterRenameSchema(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitRenameSchema) {
            listener.exitRenameSchema(this);
        }
    }
}
exports.RenameSchemaContext = RenameSchemaContext;
class CreateTableAsSelectContext extends StatementContext {
    CREATE() { return this.getToken(SqlBaseParser.CREATE, 0); }
    TABLE() { return this.getToken(SqlBaseParser.TABLE, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    AS() { return this.getToken(SqlBaseParser.AS, 0); }
    query() {
        return this.tryGetRuleContext(0, QueryContext);
    }
    IF() { return this.tryGetToken(SqlBaseParser.IF, 0); }
    NOT() { return this.tryGetToken(SqlBaseParser.NOT, 0); }
    EXISTS() { return this.tryGetToken(SqlBaseParser.EXISTS, 0); }
    columnAliases() {
        return this.tryGetRuleContext(0, ColumnAliasesContext);
    }
    COMMENT() { return this.tryGetToken(SqlBaseParser.COMMENT, 0); }
    string() {
        return this.tryGetRuleContext(0, StringContext);
    }
    WITH(i) {
        if (i === undefined) {
            return this.getTokens(SqlBaseParser.WITH);
        }
        else {
            return this.getToken(SqlBaseParser.WITH, i);
        }
    }
    properties() {
        return this.tryGetRuleContext(0, PropertiesContext);
    }
    DATA() { return this.tryGetToken(SqlBaseParser.DATA, 0); }
    NO() { return this.tryGetToken(SqlBaseParser.NO, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterCreateTableAsSelect) {
            listener.enterCreateTableAsSelect(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitCreateTableAsSelect) {
            listener.exitCreateTableAsSelect(this);
        }
    }
}
exports.CreateTableAsSelectContext = CreateTableAsSelectContext;
class CreateTableContext extends StatementContext {
    CREATE() { return this.getToken(SqlBaseParser.CREATE, 0); }
    TABLE() { return this.getToken(SqlBaseParser.TABLE, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    tableElement(i) {
        if (i === undefined) {
            return this.getRuleContexts(TableElementContext);
        }
        else {
            return this.getRuleContext(i, TableElementContext);
        }
    }
    IF() { return this.tryGetToken(SqlBaseParser.IF, 0); }
    NOT() { return this.tryGetToken(SqlBaseParser.NOT, 0); }
    EXISTS() { return this.tryGetToken(SqlBaseParser.EXISTS, 0); }
    COMMENT() { return this.tryGetToken(SqlBaseParser.COMMENT, 0); }
    string() {
        return this.tryGetRuleContext(0, StringContext);
    }
    WITH() { return this.tryGetToken(SqlBaseParser.WITH, 0); }
    properties() {
        return this.tryGetRuleContext(0, PropertiesContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterCreateTable) {
            listener.enterCreateTable(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitCreateTable) {
            listener.exitCreateTable(this);
        }
    }
}
exports.CreateTableContext = CreateTableContext;
class DropTableContext extends StatementContext {
    DROP() { return this.getToken(SqlBaseParser.DROP, 0); }
    TABLE() { return this.getToken(SqlBaseParser.TABLE, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    IF() { return this.tryGetToken(SqlBaseParser.IF, 0); }
    EXISTS() { return this.tryGetToken(SqlBaseParser.EXISTS, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterDropTable) {
            listener.enterDropTable(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitDropTable) {
            listener.exitDropTable(this);
        }
    }
}
exports.DropTableContext = DropTableContext;
class InsertIntoContext extends StatementContext {
    INSERT() { return this.getToken(SqlBaseParser.INSERT, 0); }
    INTO() { return this.getToken(SqlBaseParser.INTO, 0); }
    tableNameWithAliases() {
        return this.getRuleContext(0, TableNameWithAliasesContext);
    }
    query() {
        return this.getRuleContext(0, QueryContext);
    }
    columnAliases() {
        return this.tryGetRuleContext(0, ColumnAliasesContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterInsertInto) {
            listener.enterInsertInto(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitInsertInto) {
            listener.exitInsertInto(this);
        }
    }
}
exports.InsertIntoContext = InsertIntoContext;
class UpdateContext extends StatementContext {
    UPDATE() { return this.getToken(SqlBaseParser.UPDATE, 0); }
    tableNameWithAliases() {
        return this.getRuleContext(0, TableNameWithAliasesContext);
    }
    SET() { return this.getToken(SqlBaseParser.SET, 0); }
    updateExpression(i) {
        if (i === undefined) {
            return this.getRuleContexts(UpdateExpressionContext);
        }
        else {
            return this.getRuleContext(i, UpdateExpressionContext);
        }
    }
    WHERE() { return this.tryGetToken(SqlBaseParser.WHERE, 0); }
    whereExpression() {
        return this.tryGetRuleContext(0, WhereExpressionContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterUpdate) {
            listener.enterUpdate(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitUpdate) {
            listener.exitUpdate(this);
        }
    }
}
exports.UpdateContext = UpdateContext;
class DeleteContext extends StatementContext {
    DELETE() { return this.getToken(SqlBaseParser.DELETE, 0); }
    FROM() { return this.getToken(SqlBaseParser.FROM, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    WHERE() { return this.tryGetToken(SqlBaseParser.WHERE, 0); }
    whereExpression() {
        return this.tryGetRuleContext(0, WhereExpressionContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterDelete) {
            listener.enterDelete(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitDelete) {
            listener.exitDelete(this);
        }
    }
}
exports.DeleteContext = DeleteContext;
class RenameTableContext extends StatementContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    ALTER() { return this.getToken(SqlBaseParser.ALTER, 0); }
    TABLE() { return this.getToken(SqlBaseParser.TABLE, 0); }
    RENAME() { return this.getToken(SqlBaseParser.RENAME, 0); }
    TO() { return this.getToken(SqlBaseParser.TO, 0); }
    qualifiedName(i) {
        if (i === undefined) {
            return this.getRuleContexts(QualifiedNameContext);
        }
        else {
            return this.getRuleContext(i, QualifiedNameContext);
        }
    }
    IF() { return this.tryGetToken(SqlBaseParser.IF, 0); }
    EXISTS() { return this.tryGetToken(SqlBaseParser.EXISTS, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterRenameTable) {
            listener.enterRenameTable(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitRenameTable) {
            listener.exitRenameTable(this);
        }
    }
}
exports.RenameTableContext = RenameTableContext;
class RenameColumnContext extends StatementContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    ALTER() { return this.getToken(SqlBaseParser.ALTER, 0); }
    TABLE() { return this.getToken(SqlBaseParser.TABLE, 0); }
    RENAME() { return this.getToken(SqlBaseParser.RENAME, 0); }
    COLUMN() { return this.getToken(SqlBaseParser.COLUMN, 0); }
    TO() { return this.getToken(SqlBaseParser.TO, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    identifier(i) {
        if (i === undefined) {
            return this.getRuleContexts(IdentifierContext);
        }
        else {
            return this.getRuleContext(i, IdentifierContext);
        }
    }
    IF(i) {
        if (i === undefined) {
            return this.getTokens(SqlBaseParser.IF);
        }
        else {
            return this.getToken(SqlBaseParser.IF, i);
        }
    }
    EXISTS(i) {
        if (i === undefined) {
            return this.getTokens(SqlBaseParser.EXISTS);
        }
        else {
            return this.getToken(SqlBaseParser.EXISTS, i);
        }
    }
    // @Override
    enterRule(listener) {
        if (listener.enterRenameColumn) {
            listener.enterRenameColumn(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitRenameColumn) {
            listener.exitRenameColumn(this);
        }
    }
}
exports.RenameColumnContext = RenameColumnContext;
class DropColumnContext extends StatementContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    ALTER() { return this.getToken(SqlBaseParser.ALTER, 0); }
    TABLE() { return this.getToken(SqlBaseParser.TABLE, 0); }
    DROP() { return this.getToken(SqlBaseParser.DROP, 0); }
    COLUMN() { return this.getToken(SqlBaseParser.COLUMN, 0); }
    qualifiedName(i) {
        if (i === undefined) {
            return this.getRuleContexts(QualifiedNameContext);
        }
        else {
            return this.getRuleContext(i, QualifiedNameContext);
        }
    }
    IF(i) {
        if (i === undefined) {
            return this.getTokens(SqlBaseParser.IF);
        }
        else {
            return this.getToken(SqlBaseParser.IF, i);
        }
    }
    EXISTS(i) {
        if (i === undefined) {
            return this.getTokens(SqlBaseParser.EXISTS);
        }
        else {
            return this.getToken(SqlBaseParser.EXISTS, i);
        }
    }
    // @Override
    enterRule(listener) {
        if (listener.enterDropColumn) {
            listener.enterDropColumn(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitDropColumn) {
            listener.exitDropColumn(this);
        }
    }
}
exports.DropColumnContext = DropColumnContext;
class AddColumnContext extends StatementContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    ALTER() { return this.getToken(SqlBaseParser.ALTER, 0); }
    TABLE() { return this.getToken(SqlBaseParser.TABLE, 0); }
    ADD() { return this.getToken(SqlBaseParser.ADD, 0); }
    COLUMN() { return this.getToken(SqlBaseParser.COLUMN, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    columnDefinition() {
        return this.getRuleContext(0, ColumnDefinitionContext);
    }
    IF(i) {
        if (i === undefined) {
            return this.getTokens(SqlBaseParser.IF);
        }
        else {
            return this.getToken(SqlBaseParser.IF, i);
        }
    }
    EXISTS(i) {
        if (i === undefined) {
            return this.getTokens(SqlBaseParser.EXISTS);
        }
        else {
            return this.getToken(SqlBaseParser.EXISTS, i);
        }
    }
    NOT() { return this.tryGetToken(SqlBaseParser.NOT, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterAddColumn) {
            listener.enterAddColumn(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitAddColumn) {
            listener.exitAddColumn(this);
        }
    }
}
exports.AddColumnContext = AddColumnContext;
class AnalyzeContext extends StatementContext {
    ANALYZE() { return this.getToken(SqlBaseParser.ANALYZE, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    WITH() { return this.tryGetToken(SqlBaseParser.WITH, 0); }
    properties() {
        return this.tryGetRuleContext(0, PropertiesContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterAnalyze) {
            listener.enterAnalyze(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitAnalyze) {
            listener.exitAnalyze(this);
        }
    }
}
exports.AnalyzeContext = AnalyzeContext;
class CreateTypeContext extends StatementContext {
    CREATE() { return this.getToken(SqlBaseParser.CREATE, 0); }
    TYPE() { return this.getToken(SqlBaseParser.TYPE, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    AS() { return this.getToken(SqlBaseParser.AS, 0); }
    sqlParameterDeclaration(i) {
        if (i === undefined) {
            return this.getRuleContexts(SqlParameterDeclarationContext);
        }
        else {
            return this.getRuleContext(i, SqlParameterDeclarationContext);
        }
    }
    type() {
        return this.tryGetRuleContext(0, TypeContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterCreateType) {
            listener.enterCreateType(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitCreateType) {
            listener.exitCreateType(this);
        }
    }
}
exports.CreateTypeContext = CreateTypeContext;
class CreateViewContext extends StatementContext {
    CREATE() { return this.getToken(SqlBaseParser.CREATE, 0); }
    VIEW() { return this.getToken(SqlBaseParser.VIEW, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    AS() { return this.getToken(SqlBaseParser.AS, 0); }
    query() {
        return this.getRuleContext(0, QueryContext);
    }
    OR() { return this.tryGetToken(SqlBaseParser.OR, 0); }
    REPLACE() { return this.tryGetToken(SqlBaseParser.REPLACE, 0); }
    SECURITY() { return this.tryGetToken(SqlBaseParser.SECURITY, 0); }
    DEFINER() { return this.tryGetToken(SqlBaseParser.DEFINER, 0); }
    INVOKER() { return this.tryGetToken(SqlBaseParser.INVOKER, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterCreateView) {
            listener.enterCreateView(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitCreateView) {
            listener.exitCreateView(this);
        }
    }
}
exports.CreateViewContext = CreateViewContext;
class DropViewContext extends StatementContext {
    DROP() { return this.getToken(SqlBaseParser.DROP, 0); }
    VIEW() { return this.getToken(SqlBaseParser.VIEW, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    IF() { return this.tryGetToken(SqlBaseParser.IF, 0); }
    EXISTS() { return this.tryGetToken(SqlBaseParser.EXISTS, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterDropView) {
            listener.enterDropView(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitDropView) {
            listener.exitDropView(this);
        }
    }
}
exports.DropViewContext = DropViewContext;
class CreateMaterializedViewContext extends StatementContext {
    CREATE() { return this.getToken(SqlBaseParser.CREATE, 0); }
    MATERIALIZED() { return this.getToken(SqlBaseParser.MATERIALIZED, 0); }
    VIEW() { return this.getToken(SqlBaseParser.VIEW, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    AS() { return this.getToken(SqlBaseParser.AS, 0); }
    query() {
        return this.tryGetRuleContext(0, QueryContext);
    }
    IF() { return this.tryGetToken(SqlBaseParser.IF, 0); }
    NOT() { return this.tryGetToken(SqlBaseParser.NOT, 0); }
    EXISTS() { return this.tryGetToken(SqlBaseParser.EXISTS, 0); }
    COMMENT() { return this.tryGetToken(SqlBaseParser.COMMENT, 0); }
    string() {
        return this.tryGetRuleContext(0, StringContext);
    }
    WITH() { return this.tryGetToken(SqlBaseParser.WITH, 0); }
    properties() {
        return this.tryGetRuleContext(0, PropertiesContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterCreateMaterializedView) {
            listener.enterCreateMaterializedView(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitCreateMaterializedView) {
            listener.exitCreateMaterializedView(this);
        }
    }
}
exports.CreateMaterializedViewContext = CreateMaterializedViewContext;
class DropMaterializedViewContext extends StatementContext {
    DROP() { return this.getToken(SqlBaseParser.DROP, 0); }
    MATERIALIZED() { return this.getToken(SqlBaseParser.MATERIALIZED, 0); }
    VIEW() { return this.getToken(SqlBaseParser.VIEW, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    IF() { return this.tryGetToken(SqlBaseParser.IF, 0); }
    EXISTS() { return this.tryGetToken(SqlBaseParser.EXISTS, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterDropMaterializedView) {
            listener.enterDropMaterializedView(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitDropMaterializedView) {
            listener.exitDropMaterializedView(this);
        }
    }
}
exports.DropMaterializedViewContext = DropMaterializedViewContext;
class RefreshMaterializedViewContext extends StatementContext {
    REFRESH() { return this.getToken(SqlBaseParser.REFRESH, 0); }
    MATERIALIZED() { return this.getToken(SqlBaseParser.MATERIALIZED, 0); }
    VIEW() { return this.getToken(SqlBaseParser.VIEW, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    WHERE() { return this.getToken(SqlBaseParser.WHERE, 0); }
    booleanExpression() {
        return this.getRuleContext(0, BooleanExpressionContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterRefreshMaterializedView) {
            listener.enterRefreshMaterializedView(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitRefreshMaterializedView) {
            listener.exitRefreshMaterializedView(this);
        }
    }
}
exports.RefreshMaterializedViewContext = RefreshMaterializedViewContext;
class CreateFunctionContext extends StatementContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    CREATE() { return this.getToken(SqlBaseParser.CREATE, 0); }
    FUNCTION() { return this.getToken(SqlBaseParser.FUNCTION, 0); }
    RETURNS() { return this.getToken(SqlBaseParser.RETURNS, 0); }
    routineCharacteristics() {
        return this.getRuleContext(0, RoutineCharacteristicsContext);
    }
    routineBody() {
        return this.getRuleContext(0, RoutineBodyContext);
    }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    type() {
        return this.getRuleContext(0, TypeContext);
    }
    OR() { return this.tryGetToken(SqlBaseParser.OR, 0); }
    REPLACE() { return this.tryGetToken(SqlBaseParser.REPLACE, 0); }
    TEMPORARY() { return this.tryGetToken(SqlBaseParser.TEMPORARY, 0); }
    sqlParameterDeclaration(i) {
        if (i === undefined) {
            return this.getRuleContexts(SqlParameterDeclarationContext);
        }
        else {
            return this.getRuleContext(i, SqlParameterDeclarationContext);
        }
    }
    COMMENT() { return this.tryGetToken(SqlBaseParser.COMMENT, 0); }
    string() {
        return this.tryGetRuleContext(0, StringContext);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterCreateFunction) {
            listener.enterCreateFunction(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitCreateFunction) {
            listener.exitCreateFunction(this);
        }
    }
}
exports.CreateFunctionContext = CreateFunctionContext;
class AlterFunctionContext extends StatementContext {
    ALTER() { return this.getToken(SqlBaseParser.ALTER, 0); }
    FUNCTION() { return this.getToken(SqlBaseParser.FUNCTION, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    alterRoutineCharacteristics() {
        return this.getRuleContext(0, AlterRoutineCharacteristicsContext);
    }
    types() {
        return this.tryGetRuleContext(0, TypesContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterAlterFunction) {
            listener.enterAlterFunction(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitAlterFunction) {
            listener.exitAlterFunction(this);
        }
    }
}
exports.AlterFunctionContext = AlterFunctionContext;
class DropFunctionContext extends StatementContext {
    DROP() { return this.getToken(SqlBaseParser.DROP, 0); }
    FUNCTION() { return this.getToken(SqlBaseParser.FUNCTION, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    TEMPORARY() { return this.tryGetToken(SqlBaseParser.TEMPORARY, 0); }
    IF() { return this.tryGetToken(SqlBaseParser.IF, 0); }
    EXISTS() { return this.tryGetToken(SqlBaseParser.EXISTS, 0); }
    types() {
        return this.tryGetRuleContext(0, TypesContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterDropFunction) {
            listener.enterDropFunction(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitDropFunction) {
            listener.exitDropFunction(this);
        }
    }
}
exports.DropFunctionContext = DropFunctionContext;
class CallContext extends StatementContext {
    CALL() { return this.getToken(SqlBaseParser.CALL, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    callArgument(i) {
        if (i === undefined) {
            return this.getRuleContexts(CallArgumentContext);
        }
        else {
            return this.getRuleContext(i, CallArgumentContext);
        }
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterCall) {
            listener.enterCall(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitCall) {
            listener.exitCall(this);
        }
    }
}
exports.CallContext = CallContext;
class CreateRoleContext extends StatementContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    CREATE() { return this.getToken(SqlBaseParser.CREATE, 0); }
    ROLE() { return this.getToken(SqlBaseParser.ROLE, 0); }
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    WITH() { return this.tryGetToken(SqlBaseParser.WITH, 0); }
    ADMIN() { return this.tryGetToken(SqlBaseParser.ADMIN, 0); }
    grantor() {
        return this.tryGetRuleContext(0, GrantorContext);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterCreateRole) {
            listener.enterCreateRole(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitCreateRole) {
            listener.exitCreateRole(this);
        }
    }
}
exports.CreateRoleContext = CreateRoleContext;
class DropRoleContext extends StatementContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    DROP() { return this.getToken(SqlBaseParser.DROP, 0); }
    ROLE() { return this.getToken(SqlBaseParser.ROLE, 0); }
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterDropRole) {
            listener.enterDropRole(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitDropRole) {
            listener.exitDropRole(this);
        }
    }
}
exports.DropRoleContext = DropRoleContext;
class GrantRolesContext extends StatementContext {
    GRANT() { return this.getToken(SqlBaseParser.GRANT, 0); }
    roles() {
        return this.getRuleContext(0, RolesContext);
    }
    TO() { return this.getToken(SqlBaseParser.TO, 0); }
    principal(i) {
        if (i === undefined) {
            return this.getRuleContexts(PrincipalContext);
        }
        else {
            return this.getRuleContext(i, PrincipalContext);
        }
    }
    WITH() { return this.tryGetToken(SqlBaseParser.WITH, 0); }
    ADMIN() { return this.tryGetToken(SqlBaseParser.ADMIN, 0); }
    OPTION() { return this.tryGetToken(SqlBaseParser.OPTION, 0); }
    GRANTED() { return this.tryGetToken(SqlBaseParser.GRANTED, 0); }
    BY() { return this.tryGetToken(SqlBaseParser.BY, 0); }
    grantor() {
        return this.tryGetRuleContext(0, GrantorContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterGrantRoles) {
            listener.enterGrantRoles(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitGrantRoles) {
            listener.exitGrantRoles(this);
        }
    }
}
exports.GrantRolesContext = GrantRolesContext;
class RevokeRolesContext extends StatementContext {
    REVOKE() { return this.getToken(SqlBaseParser.REVOKE, 0); }
    roles() {
        return this.getRuleContext(0, RolesContext);
    }
    FROM() { return this.getToken(SqlBaseParser.FROM, 0); }
    principal(i) {
        if (i === undefined) {
            return this.getRuleContexts(PrincipalContext);
        }
        else {
            return this.getRuleContext(i, PrincipalContext);
        }
    }
    ADMIN() { return this.tryGetToken(SqlBaseParser.ADMIN, 0); }
    OPTION() { return this.tryGetToken(SqlBaseParser.OPTION, 0); }
    FOR() { return this.tryGetToken(SqlBaseParser.FOR, 0); }
    GRANTED() { return this.tryGetToken(SqlBaseParser.GRANTED, 0); }
    BY() { return this.tryGetToken(SqlBaseParser.BY, 0); }
    grantor() {
        return this.tryGetRuleContext(0, GrantorContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterRevokeRoles) {
            listener.enterRevokeRoles(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitRevokeRoles) {
            listener.exitRevokeRoles(this);
        }
    }
}
exports.RevokeRolesContext = RevokeRolesContext;
class SetRoleContext extends StatementContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    SET() { return this.getToken(SqlBaseParser.SET, 0); }
    ROLE() { return this.getToken(SqlBaseParser.ROLE, 0); }
    ALL() { return this.tryGetToken(SqlBaseParser.ALL, 0); }
    NONE() { return this.tryGetToken(SqlBaseParser.NONE, 0); }
    identifier() {
        return this.tryGetRuleContext(0, IdentifierContext);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterSetRole) {
            listener.enterSetRole(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSetRole) {
            listener.exitSetRole(this);
        }
    }
}
exports.SetRoleContext = SetRoleContext;
class GrantContext extends StatementContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    GRANT(i) {
        if (i === undefined) {
            return this.getTokens(SqlBaseParser.GRANT);
        }
        else {
            return this.getToken(SqlBaseParser.GRANT, i);
        }
    }
    ON() { return this.getToken(SqlBaseParser.ON, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    TO() { return this.getToken(SqlBaseParser.TO, 0); }
    principal() {
        return this.getRuleContext(0, PrincipalContext);
    }
    privilege(i) {
        if (i === undefined) {
            return this.getRuleContexts(PrivilegeContext);
        }
        else {
            return this.getRuleContext(i, PrivilegeContext);
        }
    }
    ALL() { return this.tryGetToken(SqlBaseParser.ALL, 0); }
    PRIVILEGES() { return this.tryGetToken(SqlBaseParser.PRIVILEGES, 0); }
    TABLE() { return this.tryGetToken(SqlBaseParser.TABLE, 0); }
    WITH() { return this.tryGetToken(SqlBaseParser.WITH, 0); }
    OPTION() { return this.tryGetToken(SqlBaseParser.OPTION, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterGrant) {
            listener.enterGrant(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitGrant) {
            listener.exitGrant(this);
        }
    }
}
exports.GrantContext = GrantContext;
class RevokeContext extends StatementContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    REVOKE() { return this.getToken(SqlBaseParser.REVOKE, 0); }
    ON() { return this.getToken(SqlBaseParser.ON, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    FROM() { return this.getToken(SqlBaseParser.FROM, 0); }
    principal() {
        return this.getRuleContext(0, PrincipalContext);
    }
    privilege(i) {
        if (i === undefined) {
            return this.getRuleContexts(PrivilegeContext);
        }
        else {
            return this.getRuleContext(i, PrivilegeContext);
        }
    }
    ALL() { return this.tryGetToken(SqlBaseParser.ALL, 0); }
    PRIVILEGES() { return this.tryGetToken(SqlBaseParser.PRIVILEGES, 0); }
    GRANT() { return this.tryGetToken(SqlBaseParser.GRANT, 0); }
    OPTION() { return this.tryGetToken(SqlBaseParser.OPTION, 0); }
    FOR() { return this.tryGetToken(SqlBaseParser.FOR, 0); }
    TABLE() { return this.tryGetToken(SqlBaseParser.TABLE, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterRevoke) {
            listener.enterRevoke(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitRevoke) {
            listener.exitRevoke(this);
        }
    }
}
exports.RevokeContext = RevokeContext;
class ShowGrantsContext extends StatementContext {
    SHOW() { return this.getToken(SqlBaseParser.SHOW, 0); }
    GRANTS() { return this.getToken(SqlBaseParser.GRANTS, 0); }
    ON() { return this.tryGetToken(SqlBaseParser.ON, 0); }
    qualifiedName() {
        return this.tryGetRuleContext(0, QualifiedNameContext);
    }
    TABLE() { return this.tryGetToken(SqlBaseParser.TABLE, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterShowGrants) {
            listener.enterShowGrants(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitShowGrants) {
            listener.exitShowGrants(this);
        }
    }
}
exports.ShowGrantsContext = ShowGrantsContext;
class ExplainContext extends StatementContext {
    EXPLAIN() { return this.getToken(SqlBaseParser.EXPLAIN, 0); }
    statement() {
        return this.getRuleContext(0, StatementContext);
    }
    ANALYZE() { return this.tryGetToken(SqlBaseParser.ANALYZE, 0); }
    VERBOSE() { return this.tryGetToken(SqlBaseParser.VERBOSE, 0); }
    explainOption(i) {
        if (i === undefined) {
            return this.getRuleContexts(ExplainOptionContext);
        }
        else {
            return this.getRuleContext(i, ExplainOptionContext);
        }
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterExplain) {
            listener.enterExplain(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitExplain) {
            listener.exitExplain(this);
        }
    }
}
exports.ExplainContext = ExplainContext;
class ShowCreateTableContext extends StatementContext {
    SHOW() { return this.getToken(SqlBaseParser.SHOW, 0); }
    CREATE() { return this.getToken(SqlBaseParser.CREATE, 0); }
    TABLE() { return this.getToken(SqlBaseParser.TABLE, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterShowCreateTable) {
            listener.enterShowCreateTable(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitShowCreateTable) {
            listener.exitShowCreateTable(this);
        }
    }
}
exports.ShowCreateTableContext = ShowCreateTableContext;
class ShowCreateViewContext extends StatementContext {
    SHOW() { return this.getToken(SqlBaseParser.SHOW, 0); }
    CREATE() { return this.getToken(SqlBaseParser.CREATE, 0); }
    VIEW() { return this.getToken(SqlBaseParser.VIEW, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterShowCreateView) {
            listener.enterShowCreateView(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitShowCreateView) {
            listener.exitShowCreateView(this);
        }
    }
}
exports.ShowCreateViewContext = ShowCreateViewContext;
class ShowCreateMaterializedViewContext extends StatementContext {
    SHOW() { return this.getToken(SqlBaseParser.SHOW, 0); }
    CREATE() { return this.getToken(SqlBaseParser.CREATE, 0); }
    MATERIALIZED() { return this.getToken(SqlBaseParser.MATERIALIZED, 0); }
    VIEW() { return this.getToken(SqlBaseParser.VIEW, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterShowCreateMaterializedView) {
            listener.enterShowCreateMaterializedView(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitShowCreateMaterializedView) {
            listener.exitShowCreateMaterializedView(this);
        }
    }
}
exports.ShowCreateMaterializedViewContext = ShowCreateMaterializedViewContext;
class ShowCreateFunctionContext extends StatementContext {
    SHOW() { return this.getToken(SqlBaseParser.SHOW, 0); }
    CREATE() { return this.getToken(SqlBaseParser.CREATE, 0); }
    FUNCTION() { return this.getToken(SqlBaseParser.FUNCTION, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    types() {
        return this.tryGetRuleContext(0, TypesContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterShowCreateFunction) {
            listener.enterShowCreateFunction(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitShowCreateFunction) {
            listener.exitShowCreateFunction(this);
        }
    }
}
exports.ShowCreateFunctionContext = ShowCreateFunctionContext;
class ShowTablesContext extends StatementContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    SHOW() { return this.getToken(SqlBaseParser.SHOW, 0); }
    TABLES() { return this.getToken(SqlBaseParser.TABLES, 0); }
    qualifiedName() {
        return this.tryGetRuleContext(0, QualifiedNameContext);
    }
    LIKE() { return this.tryGetToken(SqlBaseParser.LIKE, 0); }
    FROM() { return this.tryGetToken(SqlBaseParser.FROM, 0); }
    IN() { return this.tryGetToken(SqlBaseParser.IN, 0); }
    string(i) {
        if (i === undefined) {
            return this.getRuleContexts(StringContext);
        }
        else {
            return this.getRuleContext(i, StringContext);
        }
    }
    ESCAPE() { return this.tryGetToken(SqlBaseParser.ESCAPE, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterShowTables) {
            listener.enterShowTables(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitShowTables) {
            listener.exitShowTables(this);
        }
    }
}
exports.ShowTablesContext = ShowTablesContext;
class ShowSchemasContext extends StatementContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    SHOW() { return this.getToken(SqlBaseParser.SHOW, 0); }
    SCHEMAS() { return this.getToken(SqlBaseParser.SCHEMAS, 0); }
    identifier() {
        return this.tryGetRuleContext(0, IdentifierContext);
    }
    LIKE() { return this.tryGetToken(SqlBaseParser.LIKE, 0); }
    FROM() { return this.tryGetToken(SqlBaseParser.FROM, 0); }
    IN() { return this.tryGetToken(SqlBaseParser.IN, 0); }
    string(i) {
        if (i === undefined) {
            return this.getRuleContexts(StringContext);
        }
        else {
            return this.getRuleContext(i, StringContext);
        }
    }
    ESCAPE() { return this.tryGetToken(SqlBaseParser.ESCAPE, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterShowSchemas) {
            listener.enterShowSchemas(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitShowSchemas) {
            listener.exitShowSchemas(this);
        }
    }
}
exports.ShowSchemasContext = ShowSchemasContext;
class ShowCatalogsContext extends StatementContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    SHOW() { return this.getToken(SqlBaseParser.SHOW, 0); }
    CATALOGS() { return this.getToken(SqlBaseParser.CATALOGS, 0); }
    LIKE() { return this.tryGetToken(SqlBaseParser.LIKE, 0); }
    string() {
        return this.tryGetRuleContext(0, StringContext);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterShowCatalogs) {
            listener.enterShowCatalogs(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitShowCatalogs) {
            listener.exitShowCatalogs(this);
        }
    }
}
exports.ShowCatalogsContext = ShowCatalogsContext;
class ShowColumnsContext extends StatementContext {
    SHOW() { return this.tryGetToken(SqlBaseParser.SHOW, 0); }
    COLUMNS() { return this.tryGetToken(SqlBaseParser.COLUMNS, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    FROM() { return this.tryGetToken(SqlBaseParser.FROM, 0); }
    IN() { return this.tryGetToken(SqlBaseParser.IN, 0); }
    DESCRIBE() { return this.tryGetToken(SqlBaseParser.DESCRIBE, 0); }
    DESC() { return this.tryGetToken(SqlBaseParser.DESC, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterShowColumns) {
            listener.enterShowColumns(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitShowColumns) {
            listener.exitShowColumns(this);
        }
    }
}
exports.ShowColumnsContext = ShowColumnsContext;
class ShowStatsContext extends StatementContext {
    SHOW() { return this.getToken(SqlBaseParser.SHOW, 0); }
    STATS() { return this.getToken(SqlBaseParser.STATS, 0); }
    FOR() { return this.getToken(SqlBaseParser.FOR, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterShowStats) {
            listener.enterShowStats(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitShowStats) {
            listener.exitShowStats(this);
        }
    }
}
exports.ShowStatsContext = ShowStatsContext;
class ShowStatsForQueryContext extends StatementContext {
    SHOW() { return this.getToken(SqlBaseParser.SHOW, 0); }
    STATS() { return this.getToken(SqlBaseParser.STATS, 0); }
    FOR() { return this.getToken(SqlBaseParser.FOR, 0); }
    querySpecification() {
        return this.getRuleContext(0, QuerySpecificationContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterShowStatsForQuery) {
            listener.enterShowStatsForQuery(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitShowStatsForQuery) {
            listener.exitShowStatsForQuery(this);
        }
    }
}
exports.ShowStatsForQueryContext = ShowStatsForQueryContext;
class ShowRolesContext extends StatementContext {
    SHOW() { return this.getToken(SqlBaseParser.SHOW, 0); }
    ROLES() { return this.getToken(SqlBaseParser.ROLES, 0); }
    CURRENT() { return this.tryGetToken(SqlBaseParser.CURRENT, 0); }
    identifier() {
        return this.tryGetRuleContext(0, IdentifierContext);
    }
    FROM() { return this.tryGetToken(SqlBaseParser.FROM, 0); }
    IN() { return this.tryGetToken(SqlBaseParser.IN, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterShowRoles) {
            listener.enterShowRoles(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitShowRoles) {
            listener.exitShowRoles(this);
        }
    }
}
exports.ShowRolesContext = ShowRolesContext;
class ShowRoleGrantsContext extends StatementContext {
    SHOW() { return this.getToken(SqlBaseParser.SHOW, 0); }
    ROLE() { return this.getToken(SqlBaseParser.ROLE, 0); }
    GRANTS() { return this.getToken(SqlBaseParser.GRANTS, 0); }
    identifier() {
        return this.tryGetRuleContext(0, IdentifierContext);
    }
    FROM() { return this.tryGetToken(SqlBaseParser.FROM, 0); }
    IN() { return this.tryGetToken(SqlBaseParser.IN, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterShowRoleGrants) {
            listener.enterShowRoleGrants(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitShowRoleGrants) {
            listener.exitShowRoleGrants(this);
        }
    }
}
exports.ShowRoleGrantsContext = ShowRoleGrantsContext;
class ShowFunctionsContext extends StatementContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    SHOW() { return this.getToken(SqlBaseParser.SHOW, 0); }
    FUNCTIONS() { return this.getToken(SqlBaseParser.FUNCTIONS, 0); }
    LIKE() { return this.tryGetToken(SqlBaseParser.LIKE, 0); }
    string(i) {
        if (i === undefined) {
            return this.getRuleContexts(StringContext);
        }
        else {
            return this.getRuleContext(i, StringContext);
        }
    }
    ESCAPE() { return this.tryGetToken(SqlBaseParser.ESCAPE, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterShowFunctions) {
            listener.enterShowFunctions(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitShowFunctions) {
            listener.exitShowFunctions(this);
        }
    }
}
exports.ShowFunctionsContext = ShowFunctionsContext;
class ShowSessionContext extends StatementContext {
    SHOW() { return this.getToken(SqlBaseParser.SHOW, 0); }
    SESSION() { return this.getToken(SqlBaseParser.SESSION, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterShowSession) {
            listener.enterShowSession(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitShowSession) {
            listener.exitShowSession(this);
        }
    }
}
exports.ShowSessionContext = ShowSessionContext;
class SetSessionContext extends StatementContext {
    SET() { return this.getToken(SqlBaseParser.SET, 0); }
    SESSION() { return this.getToken(SqlBaseParser.SESSION, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    EQ() { return this.getToken(SqlBaseParser.EQ, 0); }
    expression() {
        return this.getRuleContext(0, ExpressionContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterSetSession) {
            listener.enterSetSession(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSetSession) {
            listener.exitSetSession(this);
        }
    }
}
exports.SetSessionContext = SetSessionContext;
class ResetSessionContext extends StatementContext {
    RESET() { return this.getToken(SqlBaseParser.RESET, 0); }
    SESSION() { return this.getToken(SqlBaseParser.SESSION, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterResetSession) {
            listener.enterResetSession(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitResetSession) {
            listener.exitResetSession(this);
        }
    }
}
exports.ResetSessionContext = ResetSessionContext;
class StartTransactionContext extends StatementContext {
    START() { return this.getToken(SqlBaseParser.START, 0); }
    TRANSACTION() { return this.getToken(SqlBaseParser.TRANSACTION, 0); }
    transactionMode(i) {
        if (i === undefined) {
            return this.getRuleContexts(TransactionModeContext);
        }
        else {
            return this.getRuleContext(i, TransactionModeContext);
        }
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterStartTransaction) {
            listener.enterStartTransaction(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitStartTransaction) {
            listener.exitStartTransaction(this);
        }
    }
}
exports.StartTransactionContext = StartTransactionContext;
class CommitContext extends StatementContext {
    COMMIT() { return this.getToken(SqlBaseParser.COMMIT, 0); }
    WORK() { return this.tryGetToken(SqlBaseParser.WORK, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterCommit) {
            listener.enterCommit(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitCommit) {
            listener.exitCommit(this);
        }
    }
}
exports.CommitContext = CommitContext;
class RollbackContext extends StatementContext {
    ROLLBACK() { return this.getToken(SqlBaseParser.ROLLBACK, 0); }
    WORK() { return this.tryGetToken(SqlBaseParser.WORK, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterRollback) {
            listener.enterRollback(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitRollback) {
            listener.exitRollback(this);
        }
    }
}
exports.RollbackContext = RollbackContext;
class PrepareContext extends StatementContext {
    PREPARE() { return this.getToken(SqlBaseParser.PREPARE, 0); }
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    FROM() { return this.getToken(SqlBaseParser.FROM, 0); }
    statement() {
        return this.getRuleContext(0, StatementContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterPrepare) {
            listener.enterPrepare(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitPrepare) {
            listener.exitPrepare(this);
        }
    }
}
exports.PrepareContext = PrepareContext;
class DeallocateContext extends StatementContext {
    DEALLOCATE() { return this.getToken(SqlBaseParser.DEALLOCATE, 0); }
    PREPARE() { return this.getToken(SqlBaseParser.PREPARE, 0); }
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterDeallocate) {
            listener.enterDeallocate(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitDeallocate) {
            listener.exitDeallocate(this);
        }
    }
}
exports.DeallocateContext = DeallocateContext;
class ExecuteContext extends StatementContext {
    EXECUTE() { return this.getToken(SqlBaseParser.EXECUTE, 0); }
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    USING() { return this.tryGetToken(SqlBaseParser.USING, 0); }
    expression(i) {
        if (i === undefined) {
            return this.getRuleContexts(ExpressionContext);
        }
        else {
            return this.getRuleContext(i, ExpressionContext);
        }
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterExecute) {
            listener.enterExecute(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitExecute) {
            listener.exitExecute(this);
        }
    }
}
exports.ExecuteContext = ExecuteContext;
class DescribeInputContext extends StatementContext {
    DESCRIBE() { return this.getToken(SqlBaseParser.DESCRIBE, 0); }
    INPUT() { return this.getToken(SqlBaseParser.INPUT, 0); }
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterDescribeInput) {
            listener.enterDescribeInput(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitDescribeInput) {
            listener.exitDescribeInput(this);
        }
    }
}
exports.DescribeInputContext = DescribeInputContext;
class DescribeOutputContext extends StatementContext {
    DESCRIBE() { return this.getToken(SqlBaseParser.DESCRIBE, 0); }
    OUTPUT() { return this.getToken(SqlBaseParser.OUTPUT, 0); }
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterDescribeOutput) {
            listener.enterDescribeOutput(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitDescribeOutput) {
            listener.exitDescribeOutput(this);
        }
    }
}
exports.DescribeOutputContext = DescribeOutputContext;
class QueryContext extends ParserRuleContext_1.ParserRuleContext {
    queryNoWith() {
        return this.getRuleContext(0, QueryNoWithContext);
    }
    queryWith() {
        return this.tryGetRuleContext(0, QueryWithContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_query; }
    // @Override
    enterRule(listener) {
        if (listener.enterQuery) {
            listener.enterQuery(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitQuery) {
            listener.exitQuery(this);
        }
    }
}
exports.QueryContext = QueryContext;
class QueryWithContext extends ParserRuleContext_1.ParserRuleContext {
    WITH() { return this.getToken(SqlBaseParser.WITH, 0); }
    namedQuery(i) {
        if (i === undefined) {
            return this.getRuleContexts(NamedQueryContext);
        }
        else {
            return this.getRuleContext(i, NamedQueryContext);
        }
    }
    RECURSIVE() { return this.tryGetToken(SqlBaseParser.RECURSIVE, 0); }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_queryWith; }
    // @Override
    enterRule(listener) {
        if (listener.enterQueryWith) {
            listener.enterQueryWith(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitQueryWith) {
            listener.exitQueryWith(this);
        }
    }
}
exports.QueryWithContext = QueryWithContext;
class TableElementContext extends ParserRuleContext_1.ParserRuleContext {
    columnDefinition() {
        return this.tryGetRuleContext(0, ColumnDefinitionContext);
    }
    likeClause() {
        return this.tryGetRuleContext(0, LikeClauseContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_tableElement; }
    // @Override
    enterRule(listener) {
        if (listener.enterTableElement) {
            listener.enterTableElement(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitTableElement) {
            listener.exitTableElement(this);
        }
    }
}
exports.TableElementContext = TableElementContext;
class ColumnDefinitionContext extends ParserRuleContext_1.ParserRuleContext {
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    type() {
        return this.getRuleContext(0, TypeContext);
    }
    NOT() { return this.tryGetToken(SqlBaseParser.NOT, 0); }
    NULL() { return this.tryGetToken(SqlBaseParser.NULL, 0); }
    COMMENT() { return this.tryGetToken(SqlBaseParser.COMMENT, 0); }
    string() {
        return this.tryGetRuleContext(0, StringContext);
    }
    WITH() { return this.tryGetToken(SqlBaseParser.WITH, 0); }
    properties() {
        return this.tryGetRuleContext(0, PropertiesContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_columnDefinition; }
    // @Override
    enterRule(listener) {
        if (listener.enterColumnDefinition) {
            listener.enterColumnDefinition(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitColumnDefinition) {
            listener.exitColumnDefinition(this);
        }
    }
}
exports.ColumnDefinitionContext = ColumnDefinitionContext;
class LikeClauseContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    LIKE() { return this.getToken(SqlBaseParser.LIKE, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    PROPERTIES() { return this.tryGetToken(SqlBaseParser.PROPERTIES, 0); }
    INCLUDING() { return this.tryGetToken(SqlBaseParser.INCLUDING, 0); }
    EXCLUDING() { return this.tryGetToken(SqlBaseParser.EXCLUDING, 0); }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_likeClause; }
    // @Override
    enterRule(listener) {
        if (listener.enterLikeClause) {
            listener.enterLikeClause(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitLikeClause) {
            listener.exitLikeClause(this);
        }
    }
}
exports.LikeClauseContext = LikeClauseContext;
class PropertiesContext extends ParserRuleContext_1.ParserRuleContext {
    property(i) {
        if (i === undefined) {
            return this.getRuleContexts(PropertyContext);
        }
        else {
            return this.getRuleContext(i, PropertyContext);
        }
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_properties; }
    // @Override
    enterRule(listener) {
        if (listener.enterProperties) {
            listener.enterProperties(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitProperties) {
            listener.exitProperties(this);
        }
    }
}
exports.PropertiesContext = PropertiesContext;
class PropertyContext extends ParserRuleContext_1.ParserRuleContext {
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    EQ() { return this.getToken(SqlBaseParser.EQ, 0); }
    expression() {
        return this.getRuleContext(0, ExpressionContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_property; }
    // @Override
    enterRule(listener) {
        if (listener.enterProperty) {
            listener.enterProperty(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitProperty) {
            listener.exitProperty(this);
        }
    }
}
exports.PropertyContext = PropertyContext;
class SqlParameterDeclarationContext extends ParserRuleContext_1.ParserRuleContext {
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    type() {
        return this.getRuleContext(0, TypeContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_sqlParameterDeclaration; }
    // @Override
    enterRule(listener) {
        if (listener.enterSqlParameterDeclaration) {
            listener.enterSqlParameterDeclaration(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSqlParameterDeclaration) {
            listener.exitSqlParameterDeclaration(this);
        }
    }
}
exports.SqlParameterDeclarationContext = SqlParameterDeclarationContext;
class RoutineCharacteristicsContext extends ParserRuleContext_1.ParserRuleContext {
    routineCharacteristic(i) {
        if (i === undefined) {
            return this.getRuleContexts(RoutineCharacteristicContext);
        }
        else {
            return this.getRuleContext(i, RoutineCharacteristicContext);
        }
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_routineCharacteristics; }
    // @Override
    enterRule(listener) {
        if (listener.enterRoutineCharacteristics) {
            listener.enterRoutineCharacteristics(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitRoutineCharacteristics) {
            listener.exitRoutineCharacteristics(this);
        }
    }
}
exports.RoutineCharacteristicsContext = RoutineCharacteristicsContext;
class RoutineCharacteristicContext extends ParserRuleContext_1.ParserRuleContext {
    LANGUAGE() { return this.tryGetToken(SqlBaseParser.LANGUAGE, 0); }
    language() {
        return this.tryGetRuleContext(0, LanguageContext);
    }
    determinism() {
        return this.tryGetRuleContext(0, DeterminismContext);
    }
    nullCallClause() {
        return this.tryGetRuleContext(0, NullCallClauseContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_routineCharacteristic; }
    // @Override
    enterRule(listener) {
        if (listener.enterRoutineCharacteristic) {
            listener.enterRoutineCharacteristic(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitRoutineCharacteristic) {
            listener.exitRoutineCharacteristic(this);
        }
    }
}
exports.RoutineCharacteristicContext = RoutineCharacteristicContext;
class AlterRoutineCharacteristicsContext extends ParserRuleContext_1.ParserRuleContext {
    alterRoutineCharacteristic(i) {
        if (i === undefined) {
            return this.getRuleContexts(AlterRoutineCharacteristicContext);
        }
        else {
            return this.getRuleContext(i, AlterRoutineCharacteristicContext);
        }
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_alterRoutineCharacteristics; }
    // @Override
    enterRule(listener) {
        if (listener.enterAlterRoutineCharacteristics) {
            listener.enterAlterRoutineCharacteristics(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitAlterRoutineCharacteristics) {
            listener.exitAlterRoutineCharacteristics(this);
        }
    }
}
exports.AlterRoutineCharacteristicsContext = AlterRoutineCharacteristicsContext;
class AlterRoutineCharacteristicContext extends ParserRuleContext_1.ParserRuleContext {
    nullCallClause() {
        return this.getRuleContext(0, NullCallClauseContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_alterRoutineCharacteristic; }
    // @Override
    enterRule(listener) {
        if (listener.enterAlterRoutineCharacteristic) {
            listener.enterAlterRoutineCharacteristic(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitAlterRoutineCharacteristic) {
            listener.exitAlterRoutineCharacteristic(this);
        }
    }
}
exports.AlterRoutineCharacteristicContext = AlterRoutineCharacteristicContext;
class RoutineBodyContext extends ParserRuleContext_1.ParserRuleContext {
    returnStatement() {
        return this.tryGetRuleContext(0, ReturnStatementContext);
    }
    externalBodyReference() {
        return this.tryGetRuleContext(0, ExternalBodyReferenceContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_routineBody; }
    // @Override
    enterRule(listener) {
        if (listener.enterRoutineBody) {
            listener.enterRoutineBody(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitRoutineBody) {
            listener.exitRoutineBody(this);
        }
    }
}
exports.RoutineBodyContext = RoutineBodyContext;
class ReturnStatementContext extends ParserRuleContext_1.ParserRuleContext {
    RETURN() { return this.getToken(SqlBaseParser.RETURN, 0); }
    expression() {
        return this.getRuleContext(0, ExpressionContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_returnStatement; }
    // @Override
    enterRule(listener) {
        if (listener.enterReturnStatement) {
            listener.enterReturnStatement(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitReturnStatement) {
            listener.exitReturnStatement(this);
        }
    }
}
exports.ReturnStatementContext = ReturnStatementContext;
class ExternalBodyReferenceContext extends ParserRuleContext_1.ParserRuleContext {
    EXTERNAL() { return this.getToken(SqlBaseParser.EXTERNAL, 0); }
    NAME() { return this.tryGetToken(SqlBaseParser.NAME, 0); }
    externalRoutineName() {
        return this.tryGetRuleContext(0, ExternalRoutineNameContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_externalBodyReference; }
    // @Override
    enterRule(listener) {
        if (listener.enterExternalBodyReference) {
            listener.enterExternalBodyReference(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitExternalBodyReference) {
            listener.exitExternalBodyReference(this);
        }
    }
}
exports.ExternalBodyReferenceContext = ExternalBodyReferenceContext;
class LanguageContext extends ParserRuleContext_1.ParserRuleContext {
    SQL() { return this.tryGetToken(SqlBaseParser.SQL, 0); }
    identifier() {
        return this.tryGetRuleContext(0, IdentifierContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_language; }
    // @Override
    enterRule(listener) {
        if (listener.enterLanguage) {
            listener.enterLanguage(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitLanguage) {
            listener.exitLanguage(this);
        }
    }
}
exports.LanguageContext = LanguageContext;
class DeterminismContext extends ParserRuleContext_1.ParserRuleContext {
    DETERMINISTIC() { return this.getToken(SqlBaseParser.DETERMINISTIC, 0); }
    NOT() { return this.tryGetToken(SqlBaseParser.NOT, 0); }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_determinism; }
    // @Override
    enterRule(listener) {
        if (listener.enterDeterminism) {
            listener.enterDeterminism(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitDeterminism) {
            listener.exitDeterminism(this);
        }
    }
}
exports.DeterminismContext = DeterminismContext;
class NullCallClauseContext extends ParserRuleContext_1.ParserRuleContext {
    RETURNS() { return this.tryGetToken(SqlBaseParser.RETURNS, 0); }
    NULL(i) {
        if (i === undefined) {
            return this.getTokens(SqlBaseParser.NULL);
        }
        else {
            return this.getToken(SqlBaseParser.NULL, i);
        }
    }
    ON() { return this.getToken(SqlBaseParser.ON, 0); }
    INPUT() { return this.getToken(SqlBaseParser.INPUT, 0); }
    CALLED() { return this.tryGetToken(SqlBaseParser.CALLED, 0); }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_nullCallClause; }
    // @Override
    enterRule(listener) {
        if (listener.enterNullCallClause) {
            listener.enterNullCallClause(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitNullCallClause) {
            listener.exitNullCallClause(this);
        }
    }
}
exports.NullCallClauseContext = NullCallClauseContext;
class ExternalRoutineNameContext extends ParserRuleContext_1.ParserRuleContext {
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_externalRoutineName; }
    // @Override
    enterRule(listener) {
        if (listener.enterExternalRoutineName) {
            listener.enterExternalRoutineName(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitExternalRoutineName) {
            listener.exitExternalRoutineName(this);
        }
    }
}
exports.ExternalRoutineNameContext = ExternalRoutineNameContext;
class QueryNoWithContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    queryTerm() {
        return this.getRuleContext(0, QueryTermContext);
    }
    ORDER() { return this.tryGetToken(SqlBaseParser.ORDER, 0); }
    BY() { return this.tryGetToken(SqlBaseParser.BY, 0); }
    sortItem(i) {
        if (i === undefined) {
            return this.getRuleContexts(SortItemContext);
        }
        else {
            return this.getRuleContext(i, SortItemContext);
        }
    }
    OFFSET() { return this.tryGetToken(SqlBaseParser.OFFSET, 0); }
    LIMIT() { return this.tryGetToken(SqlBaseParser.LIMIT, 0); }
    INTEGER_VALUE(i) {
        if (i === undefined) {
            return this.getTokens(SqlBaseParser.INTEGER_VALUE);
        }
        else {
            return this.getToken(SqlBaseParser.INTEGER_VALUE, i);
        }
    }
    ALL() { return this.tryGetToken(SqlBaseParser.ALL, 0); }
    ROW() { return this.tryGetToken(SqlBaseParser.ROW, 0); }
    ROWS() { return this.tryGetToken(SqlBaseParser.ROWS, 0); }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_queryNoWith; }
    // @Override
    enterRule(listener) {
        if (listener.enterQueryNoWith) {
            listener.enterQueryNoWith(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitQueryNoWith) {
            listener.exitQueryNoWith(this);
        }
    }
}
exports.QueryNoWithContext = QueryNoWithContext;
class QueryTermContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_queryTerm; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.QueryTermContext = QueryTermContext;
class QueryTermDefaultContext extends QueryTermContext {
    queryPrimary() {
        return this.getRuleContext(0, QueryPrimaryContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterQueryTermDefault) {
            listener.enterQueryTermDefault(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitQueryTermDefault) {
            listener.exitQueryTermDefault(this);
        }
    }
}
exports.QueryTermDefaultContext = QueryTermDefaultContext;
class SetOperationContext extends QueryTermContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    queryTerm(i) {
        if (i === undefined) {
            return this.getRuleContexts(QueryTermContext);
        }
        else {
            return this.getRuleContext(i, QueryTermContext);
        }
    }
    INTERSECT() { return this.tryGetToken(SqlBaseParser.INTERSECT, 0); }
    setQuantifier() {
        return this.tryGetRuleContext(0, SetQuantifierContext);
    }
    UNION() { return this.tryGetToken(SqlBaseParser.UNION, 0); }
    EXCEPT() { return this.tryGetToken(SqlBaseParser.EXCEPT, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterSetOperation) {
            listener.enterSetOperation(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSetOperation) {
            listener.exitSetOperation(this);
        }
    }
}
exports.SetOperationContext = SetOperationContext;
class QueryPrimaryContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_queryPrimary; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.QueryPrimaryContext = QueryPrimaryContext;
class QueryPrimaryDefaultContext extends QueryPrimaryContext {
    querySpecification() {
        return this.getRuleContext(0, QuerySpecificationContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterQueryPrimaryDefault) {
            listener.enterQueryPrimaryDefault(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitQueryPrimaryDefault) {
            listener.exitQueryPrimaryDefault(this);
        }
    }
}
exports.QueryPrimaryDefaultContext = QueryPrimaryDefaultContext;
class TableContext extends QueryPrimaryContext {
    TABLE() { return this.getToken(SqlBaseParser.TABLE, 0); }
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterTable) {
            listener.enterTable(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitTable) {
            listener.exitTable(this);
        }
    }
}
exports.TableContext = TableContext;
class InlineTableContext extends QueryPrimaryContext {
    VALUES() { return this.getToken(SqlBaseParser.VALUES, 0); }
    expression(i) {
        if (i === undefined) {
            return this.getRuleContexts(ExpressionContext);
        }
        else {
            return this.getRuleContext(i, ExpressionContext);
        }
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterInlineTable) {
            listener.enterInlineTable(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitInlineTable) {
            listener.exitInlineTable(this);
        }
    }
}
exports.InlineTableContext = InlineTableContext;
class SubqueryContext extends QueryPrimaryContext {
    queryNoWith() {
        return this.getRuleContext(0, QueryNoWithContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterSubquery) {
            listener.enterSubquery(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSubquery) {
            listener.exitSubquery(this);
        }
    }
}
exports.SubqueryContext = SubqueryContext;
class SortItemContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    expression() {
        return this.getRuleContext(0, ExpressionContext);
    }
    NULLS() { return this.tryGetToken(SqlBaseParser.NULLS, 0); }
    ASC() { return this.tryGetToken(SqlBaseParser.ASC, 0); }
    DESC() { return this.tryGetToken(SqlBaseParser.DESC, 0); }
    FIRST() { return this.tryGetToken(SqlBaseParser.FIRST, 0); }
    LAST() { return this.tryGetToken(SqlBaseParser.LAST, 0); }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_sortItem; }
    // @Override
    enterRule(listener) {
        if (listener.enterSortItem) {
            listener.enterSortItem(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSortItem) {
            listener.exitSortItem(this);
        }
    }
}
exports.SortItemContext = SortItemContext;
class QuerySpecificationContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    SELECT() { return this.getToken(SqlBaseParser.SELECT, 0); }
    selectItem(i) {
        if (i === undefined) {
            return this.getRuleContexts(SelectItemContext);
        }
        else {
            return this.getRuleContext(i, SelectItemContext);
        }
    }
    setQuantifier() {
        return this.tryGetRuleContext(0, SetQuantifierContext);
    }
    FROM() { return this.tryGetToken(SqlBaseParser.FROM, 0); }
    relation(i) {
        if (i === undefined) {
            return this.getRuleContexts(RelationContext);
        }
        else {
            return this.getRuleContext(i, RelationContext);
        }
    }
    WHERE() { return this.tryGetToken(SqlBaseParser.WHERE, 0); }
    GROUP() { return this.tryGetToken(SqlBaseParser.GROUP, 0); }
    BY() { return this.tryGetToken(SqlBaseParser.BY, 0); }
    groupBy() {
        return this.tryGetRuleContext(0, GroupByContext);
    }
    HAVING() { return this.tryGetToken(SqlBaseParser.HAVING, 0); }
    whereExpression() {
        return this.tryGetRuleContext(0, WhereExpressionContext);
    }
    havingExpression() {
        return this.tryGetRuleContext(0, HavingExpressionContext);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_querySpecification; }
    // @Override
    enterRule(listener) {
        if (listener.enterQuerySpecification) {
            listener.enterQuerySpecification(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitQuerySpecification) {
            listener.exitQuerySpecification(this);
        }
    }
}
exports.QuerySpecificationContext = QuerySpecificationContext;
class GroupByContext extends ParserRuleContext_1.ParserRuleContext {
    groupingElement(i) {
        if (i === undefined) {
            return this.getRuleContexts(GroupingElementContext);
        }
        else {
            return this.getRuleContext(i, GroupingElementContext);
        }
    }
    setQuantifier() {
        return this.tryGetRuleContext(0, SetQuantifierContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_groupBy; }
    // @Override
    enterRule(listener) {
        if (listener.enterGroupBy) {
            listener.enterGroupBy(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitGroupBy) {
            listener.exitGroupBy(this);
        }
    }
}
exports.GroupByContext = GroupByContext;
class GroupingElementContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_groupingElement; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.GroupingElementContext = GroupingElementContext;
class SingleGroupingSetContext extends GroupingElementContext {
    groupingSet() {
        return this.getRuleContext(0, GroupingSetContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterSingleGroupingSet) {
            listener.enterSingleGroupingSet(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSingleGroupingSet) {
            listener.exitSingleGroupingSet(this);
        }
    }
}
exports.SingleGroupingSetContext = SingleGroupingSetContext;
class RollupContext extends GroupingElementContext {
    ROLLUP() { return this.getToken(SqlBaseParser.ROLLUP, 0); }
    expression(i) {
        if (i === undefined) {
            return this.getRuleContexts(ExpressionContext);
        }
        else {
            return this.getRuleContext(i, ExpressionContext);
        }
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterRollup) {
            listener.enterRollup(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitRollup) {
            listener.exitRollup(this);
        }
    }
}
exports.RollupContext = RollupContext;
class CubeContext extends GroupingElementContext {
    CUBE() { return this.getToken(SqlBaseParser.CUBE, 0); }
    expression(i) {
        if (i === undefined) {
            return this.getRuleContexts(ExpressionContext);
        }
        else {
            return this.getRuleContext(i, ExpressionContext);
        }
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterCube) {
            listener.enterCube(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitCube) {
            listener.exitCube(this);
        }
    }
}
exports.CubeContext = CubeContext;
class MultipleGroupingSetsContext extends GroupingElementContext {
    GROUPING() { return this.getToken(SqlBaseParser.GROUPING, 0); }
    SETS() { return this.getToken(SqlBaseParser.SETS, 0); }
    groupingSet(i) {
        if (i === undefined) {
            return this.getRuleContexts(GroupingSetContext);
        }
        else {
            return this.getRuleContext(i, GroupingSetContext);
        }
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterMultipleGroupingSets) {
            listener.enterMultipleGroupingSets(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitMultipleGroupingSets) {
            listener.exitMultipleGroupingSets(this);
        }
    }
}
exports.MultipleGroupingSetsContext = MultipleGroupingSetsContext;
class GroupingSetContext extends ParserRuleContext_1.ParserRuleContext {
    expression(i) {
        if (i === undefined) {
            return this.getRuleContexts(ExpressionContext);
        }
        else {
            return this.getRuleContext(i, ExpressionContext);
        }
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_groupingSet; }
    // @Override
    enterRule(listener) {
        if (listener.enterGroupingSet) {
            listener.enterGroupingSet(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitGroupingSet) {
            listener.exitGroupingSet(this);
        }
    }
}
exports.GroupingSetContext = GroupingSetContext;
class NamedQueryContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    AS() { return this.getToken(SqlBaseParser.AS, 0); }
    query() {
        return this.getRuleContext(0, QueryContext);
    }
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    columnAliases() {
        return this.tryGetRuleContext(0, ColumnAliasesContext);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_namedQuery; }
    // @Override
    enterRule(listener) {
        if (listener.enterNamedQuery) {
            listener.enterNamedQuery(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitNamedQuery) {
            listener.exitNamedQuery(this);
        }
    }
}
exports.NamedQueryContext = NamedQueryContext;
class SetQuantifierContext extends ParserRuleContext_1.ParserRuleContext {
    DISTINCT() { return this.tryGetToken(SqlBaseParser.DISTINCT, 0); }
    ALL() { return this.tryGetToken(SqlBaseParser.ALL, 0); }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_setQuantifier; }
    // @Override
    enterRule(listener) {
        if (listener.enterSetQuantifier) {
            listener.enterSetQuantifier(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSetQuantifier) {
            listener.exitSetQuantifier(this);
        }
    }
}
exports.SetQuantifierContext = SetQuantifierContext;
class SelectItemContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_selectItem; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.SelectItemContext = SelectItemContext;
class SelectContext extends SelectItemContext {
    expression() {
        return this.getRuleContext(0, ExpressionContext);
    }
    identifier() {
        return this.tryGetRuleContext(0, IdentifierContext);
    }
    AS() { return this.tryGetToken(SqlBaseParser.AS, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterSelect) {
            listener.enterSelect(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSelect) {
            listener.exitSelect(this);
        }
    }
}
exports.SelectContext = SelectContext;
class SelectAllContext extends SelectItemContext {
    qualifiedName() {
        return this.tryGetRuleContext(0, QualifiedNameContext);
    }
    ASTERISK() { return this.getToken(SqlBaseParser.ASTERISK, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterSelectAll) {
            listener.enterSelectAll(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSelectAll) {
            listener.exitSelectAll(this);
        }
    }
}
exports.SelectAllContext = SelectAllContext;
class RelationContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_relation; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.RelationContext = RelationContext;
class JoinRelationContext extends RelationContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    relation(i) {
        if (i === undefined) {
            return this.getRuleContexts(RelationContext);
        }
        else {
            return this.getRuleContext(i, RelationContext);
        }
    }
    CROSS() { return this.tryGetToken(SqlBaseParser.CROSS, 0); }
    JOIN() { return this.tryGetToken(SqlBaseParser.JOIN, 0); }
    joinType() {
        return this.tryGetRuleContext(0, JoinTypeContext);
    }
    joinCriteria() {
        return this.tryGetRuleContext(0, JoinCriteriaContext);
    }
    NATURAL() { return this.tryGetToken(SqlBaseParser.NATURAL, 0); }
    sampledRelation() {
        return this.tryGetRuleContext(0, SampledRelationContext);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterJoinRelation) {
            listener.enterJoinRelation(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitJoinRelation) {
            listener.exitJoinRelation(this);
        }
    }
}
exports.JoinRelationContext = JoinRelationContext;
class RelationDefaultContext extends RelationContext {
    sampledRelation() {
        return this.getRuleContext(0, SampledRelationContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterRelationDefault) {
            listener.enterRelationDefault(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitRelationDefault) {
            listener.exitRelationDefault(this);
        }
    }
}
exports.RelationDefaultContext = RelationDefaultContext;
class JoinTypeContext extends ParserRuleContext_1.ParserRuleContext {
    INNER() { return this.tryGetToken(SqlBaseParser.INNER, 0); }
    LEFT() { return this.tryGetToken(SqlBaseParser.LEFT, 0); }
    OUTER() { return this.tryGetToken(SqlBaseParser.OUTER, 0); }
    RIGHT() { return this.tryGetToken(SqlBaseParser.RIGHT, 0); }
    FULL() { return this.tryGetToken(SqlBaseParser.FULL, 0); }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_joinType; }
    // @Override
    enterRule(listener) {
        if (listener.enterJoinType) {
            listener.enterJoinType(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitJoinType) {
            listener.exitJoinType(this);
        }
    }
}
exports.JoinTypeContext = JoinTypeContext;
class JoinCriteriaContext extends ParserRuleContext_1.ParserRuleContext {
    ON() { return this.tryGetToken(SqlBaseParser.ON, 0); }
    booleanExpression() {
        return this.tryGetRuleContext(0, BooleanExpressionContext);
    }
    USING() { return this.tryGetToken(SqlBaseParser.USING, 0); }
    identifier(i) {
        if (i === undefined) {
            return this.getRuleContexts(IdentifierContext);
        }
        else {
            return this.getRuleContext(i, IdentifierContext);
        }
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_joinCriteria; }
    // @Override
    enterRule(listener) {
        if (listener.enterJoinCriteria) {
            listener.enterJoinCriteria(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitJoinCriteria) {
            listener.exitJoinCriteria(this);
        }
    }
}
exports.JoinCriteriaContext = JoinCriteriaContext;
class SampledRelationContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    aliasedRelation() {
        return this.getRuleContext(0, AliasedRelationContext);
    }
    TABLESAMPLE() { return this.tryGetToken(SqlBaseParser.TABLESAMPLE, 0); }
    sampleType() {
        return this.tryGetRuleContext(0, SampleTypeContext);
    }
    expression() {
        return this.tryGetRuleContext(0, ExpressionContext);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_sampledRelation; }
    // @Override
    enterRule(listener) {
        if (listener.enterSampledRelation) {
            listener.enterSampledRelation(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSampledRelation) {
            listener.exitSampledRelation(this);
        }
    }
}
exports.SampledRelationContext = SampledRelationContext;
class SampleTypeContext extends ParserRuleContext_1.ParserRuleContext {
    BERNOULLI() { return this.tryGetToken(SqlBaseParser.BERNOULLI, 0); }
    SYSTEM() { return this.tryGetToken(SqlBaseParser.SYSTEM, 0); }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_sampleType; }
    // @Override
    enterRule(listener) {
        if (listener.enterSampleType) {
            listener.enterSampleType(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSampleType) {
            listener.exitSampleType(this);
        }
    }
}
exports.SampleTypeContext = SampleTypeContext;
class AliasedRelationContext extends ParserRuleContext_1.ParserRuleContext {
    relationPrimary() {
        return this.getRuleContext(0, RelationPrimaryContext);
    }
    identifier() {
        return this.tryGetRuleContext(0, IdentifierContext);
    }
    AS() { return this.tryGetToken(SqlBaseParser.AS, 0); }
    columnAliases() {
        return this.tryGetRuleContext(0, ColumnAliasesContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_aliasedRelation; }
    // @Override
    enterRule(listener) {
        if (listener.enterAliasedRelation) {
            listener.enterAliasedRelation(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitAliasedRelation) {
            listener.exitAliasedRelation(this);
        }
    }
}
exports.AliasedRelationContext = AliasedRelationContext;
class ColumnAliasesContext extends ParserRuleContext_1.ParserRuleContext {
    identifier(i) {
        if (i === undefined) {
            return this.getRuleContexts(IdentifierContext);
        }
        else {
            return this.getRuleContext(i, IdentifierContext);
        }
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_columnAliases; }
    // @Override
    enterRule(listener) {
        if (listener.enterColumnAliases) {
            listener.enterColumnAliases(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitColumnAliases) {
            listener.exitColumnAliases(this);
        }
    }
}
exports.ColumnAliasesContext = ColumnAliasesContext;
class RelationPrimaryContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_relationPrimary; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.RelationPrimaryContext = RelationPrimaryContext;
class TableNameContext extends RelationPrimaryContext {
    tableNameWithAliases() {
        return this.getRuleContext(0, TableNameWithAliasesContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterTableName) {
            listener.enterTableName(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitTableName) {
            listener.exitTableName(this);
        }
    }
}
exports.TableNameContext = TableNameContext;
class SubqueryRelationContext extends RelationPrimaryContext {
    query() {
        return this.getRuleContext(0, QueryContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterSubqueryRelation) {
            listener.enterSubqueryRelation(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSubqueryRelation) {
            listener.exitSubqueryRelation(this);
        }
    }
}
exports.SubqueryRelationContext = SubqueryRelationContext;
class UnnestContext extends RelationPrimaryContext {
    UNNEST() { return this.getToken(SqlBaseParser.UNNEST, 0); }
    expression(i) {
        if (i === undefined) {
            return this.getRuleContexts(ExpressionContext);
        }
        else {
            return this.getRuleContext(i, ExpressionContext);
        }
    }
    WITH() { return this.tryGetToken(SqlBaseParser.WITH, 0); }
    ORDINALITY() { return this.tryGetToken(SqlBaseParser.ORDINALITY, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterUnnest) {
            listener.enterUnnest(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitUnnest) {
            listener.exitUnnest(this);
        }
    }
}
exports.UnnestContext = UnnestContext;
class LateralContext extends RelationPrimaryContext {
    LATERAL() { return this.getToken(SqlBaseParser.LATERAL, 0); }
    query() {
        return this.getRuleContext(0, QueryContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterLateral) {
            listener.enterLateral(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitLateral) {
            listener.exitLateral(this);
        }
    }
}
exports.LateralContext = LateralContext;
class ParenthesizedRelationContext extends RelationPrimaryContext {
    relation() {
        return this.getRuleContext(0, RelationContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterParenthesizedRelation) {
            listener.enterParenthesizedRelation(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitParenthesizedRelation) {
            listener.exitParenthesizedRelation(this);
        }
    }
}
exports.ParenthesizedRelationContext = ParenthesizedRelationContext;
class ExpressionContext extends ParserRuleContext_1.ParserRuleContext {
    booleanExpression() {
        return this.getRuleContext(0, BooleanExpressionContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_expression; }
    // @Override
    enterRule(listener) {
        if (listener.enterExpression) {
            listener.enterExpression(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitExpression) {
            listener.exitExpression(this);
        }
    }
}
exports.ExpressionContext = ExpressionContext;
class WhereExpressionContext extends ParserRuleContext_1.ParserRuleContext {
    booleanExpression() {
        return this.getRuleContext(0, BooleanExpressionContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_whereExpression; }
    // @Override
    enterRule(listener) {
        if (listener.enterWhereExpression) {
            listener.enterWhereExpression(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitWhereExpression) {
            listener.exitWhereExpression(this);
        }
    }
}
exports.WhereExpressionContext = WhereExpressionContext;
class UpdateExpressionContext extends ParserRuleContext_1.ParserRuleContext {
    booleanExpression() {
        return this.getRuleContext(0, BooleanExpressionContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_updateExpression; }
    // @Override
    enterRule(listener) {
        if (listener.enterUpdateExpression) {
            listener.enterUpdateExpression(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitUpdateExpression) {
            listener.exitUpdateExpression(this);
        }
    }
}
exports.UpdateExpressionContext = UpdateExpressionContext;
class HavingExpressionContext extends ParserRuleContext_1.ParserRuleContext {
    booleanExpression() {
        return this.getRuleContext(0, BooleanExpressionContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_havingExpression; }
    // @Override
    enterRule(listener) {
        if (listener.enterHavingExpression) {
            listener.enterHavingExpression(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitHavingExpression) {
            listener.exitHavingExpression(this);
        }
    }
}
exports.HavingExpressionContext = HavingExpressionContext;
class BooleanExpressionContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_booleanExpression; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.BooleanExpressionContext = BooleanExpressionContext;
class PredicatedContext extends BooleanExpressionContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    valueExpression() {
        return this.getRuleContext(0, ValueExpressionContext);
    }
    predicate() {
        return this.tryGetRuleContext(0, PredicateContext);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterPredicated) {
            listener.enterPredicated(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitPredicated) {
            listener.exitPredicated(this);
        }
    }
}
exports.PredicatedContext = PredicatedContext;
class LogicalNotContext extends BooleanExpressionContext {
    NOT() { return this.getToken(SqlBaseParser.NOT, 0); }
    booleanExpression() {
        return this.getRuleContext(0, BooleanExpressionContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterLogicalNot) {
            listener.enterLogicalNot(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitLogicalNot) {
            listener.exitLogicalNot(this);
        }
    }
}
exports.LogicalNotContext = LogicalNotContext;
class LogicalBinaryContext extends BooleanExpressionContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    booleanExpression(i) {
        if (i === undefined) {
            return this.getRuleContexts(BooleanExpressionContext);
        }
        else {
            return this.getRuleContext(i, BooleanExpressionContext);
        }
    }
    AND() { return this.tryGetToken(SqlBaseParser.AND, 0); }
    OR() { return this.tryGetToken(SqlBaseParser.OR, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterLogicalBinary) {
            listener.enterLogicalBinary(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitLogicalBinary) {
            listener.exitLogicalBinary(this);
        }
    }
}
exports.LogicalBinaryContext = LogicalBinaryContext;
class PredicateContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState, value) {
        super(parent, invokingState);
        this.value = value;
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_predicate; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
        this.value = ctx.value;
    }
}
exports.PredicateContext = PredicateContext;
class ComparisonContext extends PredicateContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState, ctx.value);
        this.copyFrom(ctx);
    }
    comparisonOperator() {
        return this.getRuleContext(0, ComparisonOperatorContext);
    }
    valueExpression() {
        return this.getRuleContext(0, ValueExpressionContext);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterComparison) {
            listener.enterComparison(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitComparison) {
            listener.exitComparison(this);
        }
    }
}
exports.ComparisonContext = ComparisonContext;
class QuantifiedComparisonContext extends PredicateContext {
    comparisonOperator() {
        return this.getRuleContext(0, ComparisonOperatorContext);
    }
    comparisonQuantifier() {
        return this.getRuleContext(0, ComparisonQuantifierContext);
    }
    query() {
        return this.getRuleContext(0, QueryContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState, ctx.value);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterQuantifiedComparison) {
            listener.enterQuantifiedComparison(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitQuantifiedComparison) {
            listener.exitQuantifiedComparison(this);
        }
    }
}
exports.QuantifiedComparisonContext = QuantifiedComparisonContext;
class BetweenContext extends PredicateContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState, ctx.value);
        this.copyFrom(ctx);
    }
    BETWEEN() { return this.getToken(SqlBaseParser.BETWEEN, 0); }
    AND() { return this.getToken(SqlBaseParser.AND, 0); }
    valueExpression(i) {
        if (i === undefined) {
            return this.getRuleContexts(ValueExpressionContext);
        }
        else {
            return this.getRuleContext(i, ValueExpressionContext);
        }
    }
    NOT() { return this.tryGetToken(SqlBaseParser.NOT, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterBetween) {
            listener.enterBetween(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitBetween) {
            listener.exitBetween(this);
        }
    }
}
exports.BetweenContext = BetweenContext;
class InListContext extends PredicateContext {
    IN() { return this.getToken(SqlBaseParser.IN, 0); }
    expression(i) {
        if (i === undefined) {
            return this.getRuleContexts(ExpressionContext);
        }
        else {
            return this.getRuleContext(i, ExpressionContext);
        }
    }
    NOT() { return this.tryGetToken(SqlBaseParser.NOT, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState, ctx.value);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterInList) {
            listener.enterInList(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitInList) {
            listener.exitInList(this);
        }
    }
}
exports.InListContext = InListContext;
class InSubqueryContext extends PredicateContext {
    IN() { return this.getToken(SqlBaseParser.IN, 0); }
    query() {
        return this.getRuleContext(0, QueryContext);
    }
    NOT() { return this.tryGetToken(SqlBaseParser.NOT, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState, ctx.value);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterInSubquery) {
            listener.enterInSubquery(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitInSubquery) {
            listener.exitInSubquery(this);
        }
    }
}
exports.InSubqueryContext = InSubqueryContext;
class LikeContext extends PredicateContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState, ctx.value);
        this.copyFrom(ctx);
    }
    LIKE() { return this.getToken(SqlBaseParser.LIKE, 0); }
    valueExpression(i) {
        if (i === undefined) {
            return this.getRuleContexts(ValueExpressionContext);
        }
        else {
            return this.getRuleContext(i, ValueExpressionContext);
        }
    }
    NOT() { return this.tryGetToken(SqlBaseParser.NOT, 0); }
    ESCAPE() { return this.tryGetToken(SqlBaseParser.ESCAPE, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterLike) {
            listener.enterLike(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitLike) {
            listener.exitLike(this);
        }
    }
}
exports.LikeContext = LikeContext;
class NullPredicateContext extends PredicateContext {
    IS() { return this.getToken(SqlBaseParser.IS, 0); }
    NULL() { return this.getToken(SqlBaseParser.NULL, 0); }
    NOT() { return this.tryGetToken(SqlBaseParser.NOT, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState, ctx.value);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterNullPredicate) {
            listener.enterNullPredicate(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitNullPredicate) {
            listener.exitNullPredicate(this);
        }
    }
}
exports.NullPredicateContext = NullPredicateContext;
class DistinctFromContext extends PredicateContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState, ctx.value);
        this.copyFrom(ctx);
    }
    IS() { return this.getToken(SqlBaseParser.IS, 0); }
    DISTINCT() { return this.getToken(SqlBaseParser.DISTINCT, 0); }
    FROM() { return this.getToken(SqlBaseParser.FROM, 0); }
    valueExpression() {
        return this.getRuleContext(0, ValueExpressionContext);
    }
    NOT() { return this.tryGetToken(SqlBaseParser.NOT, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterDistinctFrom) {
            listener.enterDistinctFrom(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitDistinctFrom) {
            listener.exitDistinctFrom(this);
        }
    }
}
exports.DistinctFromContext = DistinctFromContext;
class ValueExpressionContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_valueExpression; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.ValueExpressionContext = ValueExpressionContext;
class ValueExpressionDefaultContext extends ValueExpressionContext {
    primaryExpression() {
        return this.getRuleContext(0, PrimaryExpressionContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterValueExpressionDefault) {
            listener.enterValueExpressionDefault(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitValueExpressionDefault) {
            listener.exitValueExpressionDefault(this);
        }
    }
}
exports.ValueExpressionDefaultContext = ValueExpressionDefaultContext;
class AtTimeZoneContext extends ValueExpressionContext {
    valueExpression() {
        return this.getRuleContext(0, ValueExpressionContext);
    }
    AT() { return this.getToken(SqlBaseParser.AT, 0); }
    timeZoneSpecifier() {
        return this.getRuleContext(0, TimeZoneSpecifierContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterAtTimeZone) {
            listener.enterAtTimeZone(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitAtTimeZone) {
            listener.exitAtTimeZone(this);
        }
    }
}
exports.AtTimeZoneContext = AtTimeZoneContext;
class ArithmeticUnaryContext extends ValueExpressionContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    valueExpression() {
        return this.getRuleContext(0, ValueExpressionContext);
    }
    MINUS() { return this.tryGetToken(SqlBaseParser.MINUS, 0); }
    PLUS() { return this.tryGetToken(SqlBaseParser.PLUS, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterArithmeticUnary) {
            listener.enterArithmeticUnary(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitArithmeticUnary) {
            listener.exitArithmeticUnary(this);
        }
    }
}
exports.ArithmeticUnaryContext = ArithmeticUnaryContext;
class ArithmeticBinaryContext extends ValueExpressionContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    valueExpression(i) {
        if (i === undefined) {
            return this.getRuleContexts(ValueExpressionContext);
        }
        else {
            return this.getRuleContext(i, ValueExpressionContext);
        }
    }
    ASTERISK() { return this.tryGetToken(SqlBaseParser.ASTERISK, 0); }
    SLASH() { return this.tryGetToken(SqlBaseParser.SLASH, 0); }
    PERCENT() { return this.tryGetToken(SqlBaseParser.PERCENT, 0); }
    PLUS() { return this.tryGetToken(SqlBaseParser.PLUS, 0); }
    MINUS() { return this.tryGetToken(SqlBaseParser.MINUS, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterArithmeticBinary) {
            listener.enterArithmeticBinary(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitArithmeticBinary) {
            listener.exitArithmeticBinary(this);
        }
    }
}
exports.ArithmeticBinaryContext = ArithmeticBinaryContext;
class ConcatenationContext extends ValueExpressionContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    CONCAT() { return this.getToken(SqlBaseParser.CONCAT, 0); }
    valueExpression(i) {
        if (i === undefined) {
            return this.getRuleContexts(ValueExpressionContext);
        }
        else {
            return this.getRuleContext(i, ValueExpressionContext);
        }
    }
    // @Override
    enterRule(listener) {
        if (listener.enterConcatenation) {
            listener.enterConcatenation(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitConcatenation) {
            listener.exitConcatenation(this);
        }
    }
}
exports.ConcatenationContext = ConcatenationContext;
class PrimaryExpressionContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_primaryExpression; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.PrimaryExpressionContext = PrimaryExpressionContext;
class NullLiteralContext extends PrimaryExpressionContext {
    NULL() { return this.getToken(SqlBaseParser.NULL, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterNullLiteral) {
            listener.enterNullLiteral(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitNullLiteral) {
            listener.exitNullLiteral(this);
        }
    }
}
exports.NullLiteralContext = NullLiteralContext;
class IntervalLiteralContext extends PrimaryExpressionContext {
    interval() {
        return this.getRuleContext(0, IntervalContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterIntervalLiteral) {
            listener.enterIntervalLiteral(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitIntervalLiteral) {
            listener.exitIntervalLiteral(this);
        }
    }
}
exports.IntervalLiteralContext = IntervalLiteralContext;
class TypeConstructorContext extends PrimaryExpressionContext {
    identifier() {
        return this.tryGetRuleContext(0, IdentifierContext);
    }
    string() {
        return this.getRuleContext(0, StringContext);
    }
    DOUBLE_PRECISION() { return this.tryGetToken(SqlBaseParser.DOUBLE_PRECISION, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterTypeConstructor) {
            listener.enterTypeConstructor(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitTypeConstructor) {
            listener.exitTypeConstructor(this);
        }
    }
}
exports.TypeConstructorContext = TypeConstructorContext;
class NumericLiteralContext extends PrimaryExpressionContext {
    number() {
        return this.getRuleContext(0, NumberContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterNumericLiteral) {
            listener.enterNumericLiteral(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitNumericLiteral) {
            listener.exitNumericLiteral(this);
        }
    }
}
exports.NumericLiteralContext = NumericLiteralContext;
class BooleanLiteralContext extends PrimaryExpressionContext {
    booleanValue() {
        return this.getRuleContext(0, BooleanValueContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterBooleanLiteral) {
            listener.enterBooleanLiteral(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitBooleanLiteral) {
            listener.exitBooleanLiteral(this);
        }
    }
}
exports.BooleanLiteralContext = BooleanLiteralContext;
class StringLiteralContext extends PrimaryExpressionContext {
    string() {
        return this.getRuleContext(0, StringContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterStringLiteral) {
            listener.enterStringLiteral(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitStringLiteral) {
            listener.exitStringLiteral(this);
        }
    }
}
exports.StringLiteralContext = StringLiteralContext;
class BinaryLiteralContext extends PrimaryExpressionContext {
    BINARY_LITERAL() { return this.getToken(SqlBaseParser.BINARY_LITERAL, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterBinaryLiteral) {
            listener.enterBinaryLiteral(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitBinaryLiteral) {
            listener.exitBinaryLiteral(this);
        }
    }
}
exports.BinaryLiteralContext = BinaryLiteralContext;
class ParameterContext extends PrimaryExpressionContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterParameter) {
            listener.enterParameter(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitParameter) {
            listener.exitParameter(this);
        }
    }
}
exports.ParameterContext = ParameterContext;
class PositionContext extends PrimaryExpressionContext {
    POSITION() { return this.getToken(SqlBaseParser.POSITION, 0); }
    valueExpression(i) {
        if (i === undefined) {
            return this.getRuleContexts(ValueExpressionContext);
        }
        else {
            return this.getRuleContext(i, ValueExpressionContext);
        }
    }
    IN() { return this.getToken(SqlBaseParser.IN, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterPosition) {
            listener.enterPosition(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitPosition) {
            listener.exitPosition(this);
        }
    }
}
exports.PositionContext = PositionContext;
class RowConstructorContext extends PrimaryExpressionContext {
    expression(i) {
        if (i === undefined) {
            return this.getRuleContexts(ExpressionContext);
        }
        else {
            return this.getRuleContext(i, ExpressionContext);
        }
    }
    ROW() { return this.tryGetToken(SqlBaseParser.ROW, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterRowConstructor) {
            listener.enterRowConstructor(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitRowConstructor) {
            listener.exitRowConstructor(this);
        }
    }
}
exports.RowConstructorContext = RowConstructorContext;
class FunctionCallContext extends PrimaryExpressionContext {
    qualifiedName() {
        return this.getRuleContext(0, QualifiedNameContext);
    }
    ASTERISK() { return this.tryGetToken(SqlBaseParser.ASTERISK, 0); }
    filter() {
        return this.tryGetRuleContext(0, FilterContext);
    }
    over() {
        return this.tryGetRuleContext(0, OverContext);
    }
    expression(i) {
        if (i === undefined) {
            return this.getRuleContexts(ExpressionContext);
        }
        else {
            return this.getRuleContext(i, ExpressionContext);
        }
    }
    ORDER() { return this.tryGetToken(SqlBaseParser.ORDER, 0); }
    BY() { return this.tryGetToken(SqlBaseParser.BY, 0); }
    sortItem(i) {
        if (i === undefined) {
            return this.getRuleContexts(SortItemContext);
        }
        else {
            return this.getRuleContext(i, SortItemContext);
        }
    }
    setQuantifier() {
        return this.tryGetRuleContext(0, SetQuantifierContext);
    }
    nullTreatment() {
        return this.tryGetRuleContext(0, NullTreatmentContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterFunctionCall) {
            listener.enterFunctionCall(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitFunctionCall) {
            listener.exitFunctionCall(this);
        }
    }
}
exports.FunctionCallContext = FunctionCallContext;
class LambdaContext extends PrimaryExpressionContext {
    identifier(i) {
        if (i === undefined) {
            return this.getRuleContexts(IdentifierContext);
        }
        else {
            return this.getRuleContext(i, IdentifierContext);
        }
    }
    expression() {
        return this.getRuleContext(0, ExpressionContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterLambda) {
            listener.enterLambda(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitLambda) {
            listener.exitLambda(this);
        }
    }
}
exports.LambdaContext = LambdaContext;
class SubqueryExpressionContext extends PrimaryExpressionContext {
    query() {
        return this.getRuleContext(0, QueryContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterSubqueryExpression) {
            listener.enterSubqueryExpression(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSubqueryExpression) {
            listener.exitSubqueryExpression(this);
        }
    }
}
exports.SubqueryExpressionContext = SubqueryExpressionContext;
class ExistsContext extends PrimaryExpressionContext {
    EXISTS() { return this.getToken(SqlBaseParser.EXISTS, 0); }
    query() {
        return this.getRuleContext(0, QueryContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterExists) {
            listener.enterExists(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitExists) {
            listener.exitExists(this);
        }
    }
}
exports.ExistsContext = ExistsContext;
class SimpleCaseContext extends PrimaryExpressionContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    CASE() { return this.getToken(SqlBaseParser.CASE, 0); }
    valueExpression() {
        return this.getRuleContext(0, ValueExpressionContext);
    }
    END() { return this.getToken(SqlBaseParser.END, 0); }
    whenClause(i) {
        if (i === undefined) {
            return this.getRuleContexts(WhenClauseContext);
        }
        else {
            return this.getRuleContext(i, WhenClauseContext);
        }
    }
    ELSE() { return this.tryGetToken(SqlBaseParser.ELSE, 0); }
    expression() {
        return this.tryGetRuleContext(0, ExpressionContext);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterSimpleCase) {
            listener.enterSimpleCase(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSimpleCase) {
            listener.exitSimpleCase(this);
        }
    }
}
exports.SimpleCaseContext = SimpleCaseContext;
class SearchedCaseContext extends PrimaryExpressionContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    CASE() { return this.getToken(SqlBaseParser.CASE, 0); }
    END() { return this.getToken(SqlBaseParser.END, 0); }
    whenClause(i) {
        if (i === undefined) {
            return this.getRuleContexts(WhenClauseContext);
        }
        else {
            return this.getRuleContext(i, WhenClauseContext);
        }
    }
    ELSE() { return this.tryGetToken(SqlBaseParser.ELSE, 0); }
    expression() {
        return this.tryGetRuleContext(0, ExpressionContext);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterSearchedCase) {
            listener.enterSearchedCase(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSearchedCase) {
            listener.exitSearchedCase(this);
        }
    }
}
exports.SearchedCaseContext = SearchedCaseContext;
class CastContext extends PrimaryExpressionContext {
    CAST() { return this.tryGetToken(SqlBaseParser.CAST, 0); }
    expression() {
        return this.getRuleContext(0, ExpressionContext);
    }
    AS() { return this.getToken(SqlBaseParser.AS, 0); }
    type() {
        return this.getRuleContext(0, TypeContext);
    }
    TRY_CAST() { return this.tryGetToken(SqlBaseParser.TRY_CAST, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterCast) {
            listener.enterCast(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitCast) {
            listener.exitCast(this);
        }
    }
}
exports.CastContext = CastContext;
class ArrayConstructorContext extends PrimaryExpressionContext {
    ARRAY() { return this.getToken(SqlBaseParser.ARRAY, 0); }
    expression(i) {
        if (i === undefined) {
            return this.getRuleContexts(ExpressionContext);
        }
        else {
            return this.getRuleContext(i, ExpressionContext);
        }
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterArrayConstructor) {
            listener.enterArrayConstructor(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitArrayConstructor) {
            listener.exitArrayConstructor(this);
        }
    }
}
exports.ArrayConstructorContext = ArrayConstructorContext;
class SubscriptContext extends PrimaryExpressionContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    primaryExpression() {
        return this.getRuleContext(0, PrimaryExpressionContext);
    }
    valueExpression() {
        return this.getRuleContext(0, ValueExpressionContext);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterSubscript) {
            listener.enterSubscript(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSubscript) {
            listener.exitSubscript(this);
        }
    }
}
exports.SubscriptContext = SubscriptContext;
class ColumnReferenceContext extends PrimaryExpressionContext {
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterColumnReference) {
            listener.enterColumnReference(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitColumnReference) {
            listener.exitColumnReference(this);
        }
    }
}
exports.ColumnReferenceContext = ColumnReferenceContext;
class DereferenceContext extends PrimaryExpressionContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    primaryExpression() {
        return this.getRuleContext(0, PrimaryExpressionContext);
    }
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterDereference) {
            listener.enterDereference(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitDereference) {
            listener.exitDereference(this);
        }
    }
}
exports.DereferenceContext = DereferenceContext;
class SpecialDateTimeFunctionContext extends PrimaryExpressionContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    CURRENT_DATE() { return this.tryGetToken(SqlBaseParser.CURRENT_DATE, 0); }
    CURRENT_TIME() { return this.tryGetToken(SqlBaseParser.CURRENT_TIME, 0); }
    INTEGER_VALUE() { return this.tryGetToken(SqlBaseParser.INTEGER_VALUE, 0); }
    CURRENT_TIMESTAMP() { return this.tryGetToken(SqlBaseParser.CURRENT_TIMESTAMP, 0); }
    LOCALTIME() { return this.tryGetToken(SqlBaseParser.LOCALTIME, 0); }
    LOCALTIMESTAMP() { return this.tryGetToken(SqlBaseParser.LOCALTIMESTAMP, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterSpecialDateTimeFunction) {
            listener.enterSpecialDateTimeFunction(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSpecialDateTimeFunction) {
            listener.exitSpecialDateTimeFunction(this);
        }
    }
}
exports.SpecialDateTimeFunctionContext = SpecialDateTimeFunctionContext;
class CurrentUserContext extends PrimaryExpressionContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    CURRENT_USER() { return this.getToken(SqlBaseParser.CURRENT_USER, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterCurrentUser) {
            listener.enterCurrentUser(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitCurrentUser) {
            listener.exitCurrentUser(this);
        }
    }
}
exports.CurrentUserContext = CurrentUserContext;
class SubstringContext extends PrimaryExpressionContext {
    SUBSTRING() { return this.getToken(SqlBaseParser.SUBSTRING, 0); }
    valueExpression(i) {
        if (i === undefined) {
            return this.getRuleContexts(ValueExpressionContext);
        }
        else {
            return this.getRuleContext(i, ValueExpressionContext);
        }
    }
    FROM() { return this.getToken(SqlBaseParser.FROM, 0); }
    FOR() { return this.tryGetToken(SqlBaseParser.FOR, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterSubstring) {
            listener.enterSubstring(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSubstring) {
            listener.exitSubstring(this);
        }
    }
}
exports.SubstringContext = SubstringContext;
class NormalizeContext extends PrimaryExpressionContext {
    NORMALIZE() { return this.getToken(SqlBaseParser.NORMALIZE, 0); }
    valueExpression() {
        return this.getRuleContext(0, ValueExpressionContext);
    }
    normalForm() {
        return this.tryGetRuleContext(0, NormalFormContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterNormalize) {
            listener.enterNormalize(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitNormalize) {
            listener.exitNormalize(this);
        }
    }
}
exports.NormalizeContext = NormalizeContext;
class ExtractContext extends PrimaryExpressionContext {
    EXTRACT() { return this.getToken(SqlBaseParser.EXTRACT, 0); }
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    FROM() { return this.getToken(SqlBaseParser.FROM, 0); }
    valueExpression() {
        return this.getRuleContext(0, ValueExpressionContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterExtract) {
            listener.enterExtract(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitExtract) {
            listener.exitExtract(this);
        }
    }
}
exports.ExtractContext = ExtractContext;
class ParenthesizedExpressionContext extends PrimaryExpressionContext {
    expression() {
        return this.getRuleContext(0, ExpressionContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterParenthesizedExpression) {
            listener.enterParenthesizedExpression(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitParenthesizedExpression) {
            listener.exitParenthesizedExpression(this);
        }
    }
}
exports.ParenthesizedExpressionContext = ParenthesizedExpressionContext;
class GroupingOperationContext extends PrimaryExpressionContext {
    GROUPING() { return this.getToken(SqlBaseParser.GROUPING, 0); }
    qualifiedName(i) {
        if (i === undefined) {
            return this.getRuleContexts(QualifiedNameContext);
        }
        else {
            return this.getRuleContext(i, QualifiedNameContext);
        }
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterGroupingOperation) {
            listener.enterGroupingOperation(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitGroupingOperation) {
            listener.exitGroupingOperation(this);
        }
    }
}
exports.GroupingOperationContext = GroupingOperationContext;
class StringContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_string; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.StringContext = StringContext;
class BasicStringLiteralContext extends StringContext {
    STRING() { return this.getToken(SqlBaseParser.STRING, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterBasicStringLiteral) {
            listener.enterBasicStringLiteral(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitBasicStringLiteral) {
            listener.exitBasicStringLiteral(this);
        }
    }
}
exports.BasicStringLiteralContext = BasicStringLiteralContext;
class UnicodeStringLiteralContext extends StringContext {
    UNICODE_STRING() { return this.getToken(SqlBaseParser.UNICODE_STRING, 0); }
    UESCAPE() { return this.tryGetToken(SqlBaseParser.UESCAPE, 0); }
    STRING() { return this.tryGetToken(SqlBaseParser.STRING, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterUnicodeStringLiteral) {
            listener.enterUnicodeStringLiteral(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitUnicodeStringLiteral) {
            listener.exitUnicodeStringLiteral(this);
        }
    }
}
exports.UnicodeStringLiteralContext = UnicodeStringLiteralContext;
class NullTreatmentContext extends ParserRuleContext_1.ParserRuleContext {
    IGNORE() { return this.tryGetToken(SqlBaseParser.IGNORE, 0); }
    NULLS() { return this.getToken(SqlBaseParser.NULLS, 0); }
    RESPECT() { return this.tryGetToken(SqlBaseParser.RESPECT, 0); }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_nullTreatment; }
    // @Override
    enterRule(listener) {
        if (listener.enterNullTreatment) {
            listener.enterNullTreatment(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitNullTreatment) {
            listener.exitNullTreatment(this);
        }
    }
}
exports.NullTreatmentContext = NullTreatmentContext;
class TimeZoneSpecifierContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_timeZoneSpecifier; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.TimeZoneSpecifierContext = TimeZoneSpecifierContext;
class TimeZoneIntervalContext extends TimeZoneSpecifierContext {
    TIME() { return this.getToken(SqlBaseParser.TIME, 0); }
    ZONE() { return this.getToken(SqlBaseParser.ZONE, 0); }
    interval() {
        return this.getRuleContext(0, IntervalContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterTimeZoneInterval) {
            listener.enterTimeZoneInterval(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitTimeZoneInterval) {
            listener.exitTimeZoneInterval(this);
        }
    }
}
exports.TimeZoneIntervalContext = TimeZoneIntervalContext;
class TimeZoneStringContext extends TimeZoneSpecifierContext {
    TIME() { return this.getToken(SqlBaseParser.TIME, 0); }
    ZONE() { return this.getToken(SqlBaseParser.ZONE, 0); }
    string() {
        return this.getRuleContext(0, StringContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterTimeZoneString) {
            listener.enterTimeZoneString(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitTimeZoneString) {
            listener.exitTimeZoneString(this);
        }
    }
}
exports.TimeZoneStringContext = TimeZoneStringContext;
class ComparisonOperatorContext extends ParserRuleContext_1.ParserRuleContext {
    EQ() { return this.tryGetToken(SqlBaseParser.EQ, 0); }
    NEQ() { return this.tryGetToken(SqlBaseParser.NEQ, 0); }
    LT() { return this.tryGetToken(SqlBaseParser.LT, 0); }
    LTE() { return this.tryGetToken(SqlBaseParser.LTE, 0); }
    GT() { return this.tryGetToken(SqlBaseParser.GT, 0); }
    GTE() { return this.tryGetToken(SqlBaseParser.GTE, 0); }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_comparisonOperator; }
    // @Override
    enterRule(listener) {
        if (listener.enterComparisonOperator) {
            listener.enterComparisonOperator(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitComparisonOperator) {
            listener.exitComparisonOperator(this);
        }
    }
}
exports.ComparisonOperatorContext = ComparisonOperatorContext;
class ComparisonQuantifierContext extends ParserRuleContext_1.ParserRuleContext {
    ALL() { return this.tryGetToken(SqlBaseParser.ALL, 0); }
    SOME() { return this.tryGetToken(SqlBaseParser.SOME, 0); }
    ANY() { return this.tryGetToken(SqlBaseParser.ANY, 0); }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_comparisonQuantifier; }
    // @Override
    enterRule(listener) {
        if (listener.enterComparisonQuantifier) {
            listener.enterComparisonQuantifier(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitComparisonQuantifier) {
            listener.exitComparisonQuantifier(this);
        }
    }
}
exports.ComparisonQuantifierContext = ComparisonQuantifierContext;
class BooleanValueContext extends ParserRuleContext_1.ParserRuleContext {
    TRUE() { return this.tryGetToken(SqlBaseParser.TRUE, 0); }
    FALSE() { return this.tryGetToken(SqlBaseParser.FALSE, 0); }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_booleanValue; }
    // @Override
    enterRule(listener) {
        if (listener.enterBooleanValue) {
            listener.enterBooleanValue(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitBooleanValue) {
            listener.exitBooleanValue(this);
        }
    }
}
exports.BooleanValueContext = BooleanValueContext;
class IntervalContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    INTERVAL() { return this.getToken(SqlBaseParser.INTERVAL, 0); }
    string() {
        return this.getRuleContext(0, StringContext);
    }
    intervalField(i) {
        if (i === undefined) {
            return this.getRuleContexts(IntervalFieldContext);
        }
        else {
            return this.getRuleContext(i, IntervalFieldContext);
        }
    }
    TO() { return this.tryGetToken(SqlBaseParser.TO, 0); }
    PLUS() { return this.tryGetToken(SqlBaseParser.PLUS, 0); }
    MINUS() { return this.tryGetToken(SqlBaseParser.MINUS, 0); }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_interval; }
    // @Override
    enterRule(listener) {
        if (listener.enterInterval) {
            listener.enterInterval(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitInterval) {
            listener.exitInterval(this);
        }
    }
}
exports.IntervalContext = IntervalContext;
class IntervalFieldContext extends ParserRuleContext_1.ParserRuleContext {
    YEAR() { return this.tryGetToken(SqlBaseParser.YEAR, 0); }
    MONTH() { return this.tryGetToken(SqlBaseParser.MONTH, 0); }
    DAY() { return this.tryGetToken(SqlBaseParser.DAY, 0); }
    HOUR() { return this.tryGetToken(SqlBaseParser.HOUR, 0); }
    MINUTE() { return this.tryGetToken(SqlBaseParser.MINUTE, 0); }
    SECOND() { return this.tryGetToken(SqlBaseParser.SECOND, 0); }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_intervalField; }
    // @Override
    enterRule(listener) {
        if (listener.enterIntervalField) {
            listener.enterIntervalField(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitIntervalField) {
            listener.exitIntervalField(this);
        }
    }
}
exports.IntervalFieldContext = IntervalFieldContext;
class NormalFormContext extends ParserRuleContext_1.ParserRuleContext {
    NFD() { return this.tryGetToken(SqlBaseParser.NFD, 0); }
    NFC() { return this.tryGetToken(SqlBaseParser.NFC, 0); }
    NFKD() { return this.tryGetToken(SqlBaseParser.NFKD, 0); }
    NFKC() { return this.tryGetToken(SqlBaseParser.NFKC, 0); }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_normalForm; }
    // @Override
    enterRule(listener) {
        if (listener.enterNormalForm) {
            listener.enterNormalForm(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitNormalForm) {
            listener.exitNormalForm(this);
        }
    }
}
exports.NormalFormContext = NormalFormContext;
class TypesContext extends ParserRuleContext_1.ParserRuleContext {
    type(i) {
        if (i === undefined) {
            return this.getRuleContexts(TypeContext);
        }
        else {
            return this.getRuleContext(i, TypeContext);
        }
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_types; }
    // @Override
    enterRule(listener) {
        if (listener.enterTypes) {
            listener.enterTypes(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitTypes) {
            listener.exitTypes(this);
        }
    }
}
exports.TypesContext = TypesContext;
class TypeContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    type(i) {
        if (i === undefined) {
            return this.getRuleContexts(TypeContext);
        }
        else {
            return this.getRuleContext(i, TypeContext);
        }
    }
    ARRAY() { return this.tryGetToken(SqlBaseParser.ARRAY, 0); }
    LT() { return this.tryGetToken(SqlBaseParser.LT, 0); }
    GT() { return this.tryGetToken(SqlBaseParser.GT, 0); }
    MAP() { return this.tryGetToken(SqlBaseParser.MAP, 0); }
    ROW() { return this.tryGetToken(SqlBaseParser.ROW, 0); }
    identifier(i) {
        if (i === undefined) {
            return this.getRuleContexts(IdentifierContext);
        }
        else {
            return this.getRuleContext(i, IdentifierContext);
        }
    }
    baseType() {
        return this.tryGetRuleContext(0, BaseTypeContext);
    }
    typeParameter(i) {
        if (i === undefined) {
            return this.getRuleContexts(TypeParameterContext);
        }
        else {
            return this.getRuleContext(i, TypeParameterContext);
        }
    }
    INTERVAL() { return this.tryGetToken(SqlBaseParser.INTERVAL, 0); }
    TO() { return this.tryGetToken(SqlBaseParser.TO, 0); }
    intervalField(i) {
        if (i === undefined) {
            return this.getRuleContexts(IntervalFieldContext);
        }
        else {
            return this.getRuleContext(i, IntervalFieldContext);
        }
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_type; }
    // @Override
    enterRule(listener) {
        if (listener.enterType) {
            listener.enterType(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitType) {
            listener.exitType(this);
        }
    }
}
exports.TypeContext = TypeContext;
class TypeParameterContext extends ParserRuleContext_1.ParserRuleContext {
    INTEGER_VALUE() { return this.tryGetToken(SqlBaseParser.INTEGER_VALUE, 0); }
    type() {
        return this.tryGetRuleContext(0, TypeContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_typeParameter; }
    // @Override
    enterRule(listener) {
        if (listener.enterTypeParameter) {
            listener.enterTypeParameter(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitTypeParameter) {
            listener.exitTypeParameter(this);
        }
    }
}
exports.TypeParameterContext = TypeParameterContext;
class BaseTypeContext extends ParserRuleContext_1.ParserRuleContext {
    TIME_WITH_TIME_ZONE() { return this.tryGetToken(SqlBaseParser.TIME_WITH_TIME_ZONE, 0); }
    TIMESTAMP_WITH_TIME_ZONE() { return this.tryGetToken(SqlBaseParser.TIMESTAMP_WITH_TIME_ZONE, 0); }
    DOUBLE_PRECISION() { return this.tryGetToken(SqlBaseParser.DOUBLE_PRECISION, 0); }
    qualifiedName() {
        return this.tryGetRuleContext(0, QualifiedNameContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_baseType; }
    // @Override
    enterRule(listener) {
        if (listener.enterBaseType) {
            listener.enterBaseType(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitBaseType) {
            listener.exitBaseType(this);
        }
    }
}
exports.BaseTypeContext = BaseTypeContext;
class WhenClauseContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    WHEN() { return this.getToken(SqlBaseParser.WHEN, 0); }
    THEN() { return this.getToken(SqlBaseParser.THEN, 0); }
    expression(i) {
        if (i === undefined) {
            return this.getRuleContexts(ExpressionContext);
        }
        else {
            return this.getRuleContext(i, ExpressionContext);
        }
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_whenClause; }
    // @Override
    enterRule(listener) {
        if (listener.enterWhenClause) {
            listener.enterWhenClause(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitWhenClause) {
            listener.exitWhenClause(this);
        }
    }
}
exports.WhenClauseContext = WhenClauseContext;
class FilterContext extends ParserRuleContext_1.ParserRuleContext {
    FILTER() { return this.getToken(SqlBaseParser.FILTER, 0); }
    WHERE() { return this.getToken(SqlBaseParser.WHERE, 0); }
    booleanExpression() {
        return this.getRuleContext(0, BooleanExpressionContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_filter; }
    // @Override
    enterRule(listener) {
        if (listener.enterFilter) {
            listener.enterFilter(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitFilter) {
            listener.exitFilter(this);
        }
    }
}
exports.FilterContext = FilterContext;
class OverContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
        this._partition = [];
    }
    OVER() { return this.getToken(SqlBaseParser.OVER, 0); }
    PARTITION() { return this.tryGetToken(SqlBaseParser.PARTITION, 0); }
    BY(i) {
        if (i === undefined) {
            return this.getTokens(SqlBaseParser.BY);
        }
        else {
            return this.getToken(SqlBaseParser.BY, i);
        }
    }
    ORDER() { return this.tryGetToken(SqlBaseParser.ORDER, 0); }
    sortItem(i) {
        if (i === undefined) {
            return this.getRuleContexts(SortItemContext);
        }
        else {
            return this.getRuleContext(i, SortItemContext);
        }
    }
    windowFrame() {
        return this.tryGetRuleContext(0, WindowFrameContext);
    }
    expression(i) {
        if (i === undefined) {
            return this.getRuleContexts(ExpressionContext);
        }
        else {
            return this.getRuleContext(i, ExpressionContext);
        }
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_over; }
    // @Override
    enterRule(listener) {
        if (listener.enterOver) {
            listener.enterOver(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitOver) {
            listener.exitOver(this);
        }
    }
}
exports.OverContext = OverContext;
class WindowFrameContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    RANGE() { return this.tryGetToken(SqlBaseParser.RANGE, 0); }
    frameBound(i) {
        if (i === undefined) {
            return this.getRuleContexts(FrameBoundContext);
        }
        else {
            return this.getRuleContext(i, FrameBoundContext);
        }
    }
    ROWS() { return this.tryGetToken(SqlBaseParser.ROWS, 0); }
    BETWEEN() { return this.tryGetToken(SqlBaseParser.BETWEEN, 0); }
    AND() { return this.tryGetToken(SqlBaseParser.AND, 0); }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_windowFrame; }
    // @Override
    enterRule(listener) {
        if (listener.enterWindowFrame) {
            listener.enterWindowFrame(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitWindowFrame) {
            listener.exitWindowFrame(this);
        }
    }
}
exports.WindowFrameContext = WindowFrameContext;
class FrameBoundContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_frameBound; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.FrameBoundContext = FrameBoundContext;
class UnboundedFrameContext extends FrameBoundContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    UNBOUNDED() { return this.getToken(SqlBaseParser.UNBOUNDED, 0); }
    PRECEDING() { return this.tryGetToken(SqlBaseParser.PRECEDING, 0); }
    FOLLOWING() { return this.tryGetToken(SqlBaseParser.FOLLOWING, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterUnboundedFrame) {
            listener.enterUnboundedFrame(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitUnboundedFrame) {
            listener.exitUnboundedFrame(this);
        }
    }
}
exports.UnboundedFrameContext = UnboundedFrameContext;
class CurrentRowBoundContext extends FrameBoundContext {
    CURRENT() { return this.getToken(SqlBaseParser.CURRENT, 0); }
    ROW() { return this.getToken(SqlBaseParser.ROW, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterCurrentRowBound) {
            listener.enterCurrentRowBound(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitCurrentRowBound) {
            listener.exitCurrentRowBound(this);
        }
    }
}
exports.CurrentRowBoundContext = CurrentRowBoundContext;
class BoundedFrameContext extends FrameBoundContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    expression() {
        return this.getRuleContext(0, ExpressionContext);
    }
    PRECEDING() { return this.tryGetToken(SqlBaseParser.PRECEDING, 0); }
    FOLLOWING() { return this.tryGetToken(SqlBaseParser.FOLLOWING, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterBoundedFrame) {
            listener.enterBoundedFrame(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitBoundedFrame) {
            listener.exitBoundedFrame(this);
        }
    }
}
exports.BoundedFrameContext = BoundedFrameContext;
class ExplainOptionContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_explainOption; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.ExplainOptionContext = ExplainOptionContext;
class ExplainFormatContext extends ExplainOptionContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    FORMAT() { return this.getToken(SqlBaseParser.FORMAT, 0); }
    TEXT() { return this.tryGetToken(SqlBaseParser.TEXT, 0); }
    GRAPHVIZ() { return this.tryGetToken(SqlBaseParser.GRAPHVIZ, 0); }
    JSON() { return this.tryGetToken(SqlBaseParser.JSON, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterExplainFormat) {
            listener.enterExplainFormat(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitExplainFormat) {
            listener.exitExplainFormat(this);
        }
    }
}
exports.ExplainFormatContext = ExplainFormatContext;
class ExplainTypeContext extends ExplainOptionContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    TYPE() { return this.getToken(SqlBaseParser.TYPE, 0); }
    LOGICAL() { return this.tryGetToken(SqlBaseParser.LOGICAL, 0); }
    DISTRIBUTED() { return this.tryGetToken(SqlBaseParser.DISTRIBUTED, 0); }
    VALIDATE() { return this.tryGetToken(SqlBaseParser.VALIDATE, 0); }
    IO() { return this.tryGetToken(SqlBaseParser.IO, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterExplainType) {
            listener.enterExplainType(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitExplainType) {
            listener.exitExplainType(this);
        }
    }
}
exports.ExplainTypeContext = ExplainTypeContext;
class TransactionModeContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_transactionMode; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.TransactionModeContext = TransactionModeContext;
class IsolationLevelContext extends TransactionModeContext {
    ISOLATION() { return this.getToken(SqlBaseParser.ISOLATION, 0); }
    LEVEL() { return this.getToken(SqlBaseParser.LEVEL, 0); }
    levelOfIsolation() {
        return this.getRuleContext(0, LevelOfIsolationContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterIsolationLevel) {
            listener.enterIsolationLevel(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitIsolationLevel) {
            listener.exitIsolationLevel(this);
        }
    }
}
exports.IsolationLevelContext = IsolationLevelContext;
class TransactionAccessModeContext extends TransactionModeContext {
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    READ() { return this.getToken(SqlBaseParser.READ, 0); }
    ONLY() { return this.tryGetToken(SqlBaseParser.ONLY, 0); }
    WRITE() { return this.tryGetToken(SqlBaseParser.WRITE, 0); }
    // @Override
    enterRule(listener) {
        if (listener.enterTransactionAccessMode) {
            listener.enterTransactionAccessMode(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitTransactionAccessMode) {
            listener.exitTransactionAccessMode(this);
        }
    }
}
exports.TransactionAccessModeContext = TransactionAccessModeContext;
class LevelOfIsolationContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_levelOfIsolation; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.LevelOfIsolationContext = LevelOfIsolationContext;
class ReadUncommittedContext extends LevelOfIsolationContext {
    READ() { return this.getToken(SqlBaseParser.READ, 0); }
    UNCOMMITTED() { return this.getToken(SqlBaseParser.UNCOMMITTED, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterReadUncommitted) {
            listener.enterReadUncommitted(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitReadUncommitted) {
            listener.exitReadUncommitted(this);
        }
    }
}
exports.ReadUncommittedContext = ReadUncommittedContext;
class ReadCommittedContext extends LevelOfIsolationContext {
    READ() { return this.getToken(SqlBaseParser.READ, 0); }
    COMMITTED() { return this.getToken(SqlBaseParser.COMMITTED, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterReadCommitted) {
            listener.enterReadCommitted(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitReadCommitted) {
            listener.exitReadCommitted(this);
        }
    }
}
exports.ReadCommittedContext = ReadCommittedContext;
class RepeatableReadContext extends LevelOfIsolationContext {
    REPEATABLE() { return this.getToken(SqlBaseParser.REPEATABLE, 0); }
    READ() { return this.getToken(SqlBaseParser.READ, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterRepeatableRead) {
            listener.enterRepeatableRead(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitRepeatableRead) {
            listener.exitRepeatableRead(this);
        }
    }
}
exports.RepeatableReadContext = RepeatableReadContext;
class SerializableContext extends LevelOfIsolationContext {
    SERIALIZABLE() { return this.getToken(SqlBaseParser.SERIALIZABLE, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterSerializable) {
            listener.enterSerializable(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSerializable) {
            listener.exitSerializable(this);
        }
    }
}
exports.SerializableContext = SerializableContext;
class CallArgumentContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_callArgument; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.CallArgumentContext = CallArgumentContext;
class PositionalArgumentContext extends CallArgumentContext {
    expression() {
        return this.getRuleContext(0, ExpressionContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterPositionalArgument) {
            listener.enterPositionalArgument(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitPositionalArgument) {
            listener.exitPositionalArgument(this);
        }
    }
}
exports.PositionalArgumentContext = PositionalArgumentContext;
class NamedArgumentContext extends CallArgumentContext {
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    expression() {
        return this.getRuleContext(0, ExpressionContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterNamedArgument) {
            listener.enterNamedArgument(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitNamedArgument) {
            listener.exitNamedArgument(this);
        }
    }
}
exports.NamedArgumentContext = NamedArgumentContext;
class PrivilegeContext extends ParserRuleContext_1.ParserRuleContext {
    SELECT() { return this.tryGetToken(SqlBaseParser.SELECT, 0); }
    DELETE() { return this.tryGetToken(SqlBaseParser.DELETE, 0); }
    INSERT() { return this.tryGetToken(SqlBaseParser.INSERT, 0); }
    identifier() {
        return this.tryGetRuleContext(0, IdentifierContext);
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_privilege; }
    // @Override
    enterRule(listener) {
        if (listener.enterPrivilege) {
            listener.enterPrivilege(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitPrivilege) {
            listener.exitPrivilege(this);
        }
    }
}
exports.PrivilegeContext = PrivilegeContext;
class QualifiedNameContext extends ParserRuleContext_1.ParserRuleContext {
    identifier(i) {
        if (i === undefined) {
            return this.getRuleContexts(IdentifierContext);
        }
        else {
            return this.getRuleContext(i, IdentifierContext);
        }
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_qualifiedName; }
    // @Override
    enterRule(listener) {
        if (listener.enterQualifiedName) {
            listener.enterQualifiedName(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitQualifiedName) {
            listener.exitQualifiedName(this);
        }
    }
}
exports.QualifiedNameContext = QualifiedNameContext;
class TableNameWithAliasesContext extends ParserRuleContext_1.ParserRuleContext {
    identifier(i) {
        if (i === undefined) {
            return this.getRuleContexts(IdentifierContext);
        }
        else {
            return this.getRuleContext(i, IdentifierContext);
        }
    }
    AS() { return this.tryGetToken(SqlBaseParser.AS, 0); }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_tableNameWithAliases; }
    // @Override
    enterRule(listener) {
        if (listener.enterTableNameWithAliases) {
            listener.enterTableNameWithAliases(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitTableNameWithAliases) {
            listener.exitTableNameWithAliases(this);
        }
    }
}
exports.TableNameWithAliasesContext = TableNameWithAliasesContext;
class GrantorContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_grantor; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.GrantorContext = GrantorContext;
class CurrentUserGrantorContext extends GrantorContext {
    CURRENT_USER() { return this.getToken(SqlBaseParser.CURRENT_USER, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterCurrentUserGrantor) {
            listener.enterCurrentUserGrantor(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitCurrentUserGrantor) {
            listener.exitCurrentUserGrantor(this);
        }
    }
}
exports.CurrentUserGrantorContext = CurrentUserGrantorContext;
class CurrentRoleGrantorContext extends GrantorContext {
    CURRENT_ROLE() { return this.getToken(SqlBaseParser.CURRENT_ROLE, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterCurrentRoleGrantor) {
            listener.enterCurrentRoleGrantor(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitCurrentRoleGrantor) {
            listener.exitCurrentRoleGrantor(this);
        }
    }
}
exports.CurrentRoleGrantorContext = CurrentRoleGrantorContext;
class SpecifiedPrincipalContext extends GrantorContext {
    principal() {
        return this.getRuleContext(0, PrincipalContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterSpecifiedPrincipal) {
            listener.enterSpecifiedPrincipal(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitSpecifiedPrincipal) {
            listener.exitSpecifiedPrincipal(this);
        }
    }
}
exports.SpecifiedPrincipalContext = SpecifiedPrincipalContext;
class PrincipalContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_principal; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.PrincipalContext = PrincipalContext;
class UserPrincipalContext extends PrincipalContext {
    USER() { return this.getToken(SqlBaseParser.USER, 0); }
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterUserPrincipal) {
            listener.enterUserPrincipal(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitUserPrincipal) {
            listener.exitUserPrincipal(this);
        }
    }
}
exports.UserPrincipalContext = UserPrincipalContext;
class RolePrincipalContext extends PrincipalContext {
    ROLE() { return this.getToken(SqlBaseParser.ROLE, 0); }
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterRolePrincipal) {
            listener.enterRolePrincipal(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitRolePrincipal) {
            listener.exitRolePrincipal(this);
        }
    }
}
exports.RolePrincipalContext = RolePrincipalContext;
class UnspecifiedPrincipalContext extends PrincipalContext {
    identifier() {
        return this.getRuleContext(0, IdentifierContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterUnspecifiedPrincipal) {
            listener.enterUnspecifiedPrincipal(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitUnspecifiedPrincipal) {
            listener.exitUnspecifiedPrincipal(this);
        }
    }
}
exports.UnspecifiedPrincipalContext = UnspecifiedPrincipalContext;
class RolesContext extends ParserRuleContext_1.ParserRuleContext {
    identifier(i) {
        if (i === undefined) {
            return this.getRuleContexts(IdentifierContext);
        }
        else {
            return this.getRuleContext(i, IdentifierContext);
        }
    }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_roles; }
    // @Override
    enterRule(listener) {
        if (listener.enterRoles) {
            listener.enterRoles(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitRoles) {
            listener.exitRoles(this);
        }
    }
}
exports.RolesContext = RolesContext;
class IdentifierContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_identifier; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.IdentifierContext = IdentifierContext;
class UnquotedIdentifierContext extends IdentifierContext {
    IDENTIFIER() { return this.tryGetToken(SqlBaseParser.IDENTIFIER, 0); }
    nonReserved() {
        return this.tryGetRuleContext(0, NonReservedContext);
    }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterUnquotedIdentifier) {
            listener.enterUnquotedIdentifier(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitUnquotedIdentifier) {
            listener.exitUnquotedIdentifier(this);
        }
    }
}
exports.UnquotedIdentifierContext = UnquotedIdentifierContext;
class QuotedIdentifierContext extends IdentifierContext {
    QUOTED_IDENTIFIER() { return this.getToken(SqlBaseParser.QUOTED_IDENTIFIER, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterQuotedIdentifier) {
            listener.enterQuotedIdentifier(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitQuotedIdentifier) {
            listener.exitQuotedIdentifier(this);
        }
    }
}
exports.QuotedIdentifierContext = QuotedIdentifierContext;
class BackQuotedIdentifierContext extends IdentifierContext {
    BACKQUOTED_IDENTIFIER() { return this.getToken(SqlBaseParser.BACKQUOTED_IDENTIFIER, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterBackQuotedIdentifier) {
            listener.enterBackQuotedIdentifier(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitBackQuotedIdentifier) {
            listener.exitBackQuotedIdentifier(this);
        }
    }
}
exports.BackQuotedIdentifierContext = BackQuotedIdentifierContext;
class DigitIdentifierContext extends IdentifierContext {
    DIGIT_IDENTIFIER() { return this.getToken(SqlBaseParser.DIGIT_IDENTIFIER, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterDigitIdentifier) {
            listener.enterDigitIdentifier(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitDigitIdentifier) {
            listener.exitDigitIdentifier(this);
        }
    }
}
exports.DigitIdentifierContext = DigitIdentifierContext;
class NumberContext extends ParserRuleContext_1.ParserRuleContext {
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_number; }
    copyFrom(ctx) {
        super.copyFrom(ctx);
    }
}
exports.NumberContext = NumberContext;
class DecimalLiteralContext extends NumberContext {
    DECIMAL_VALUE() { return this.getToken(SqlBaseParser.DECIMAL_VALUE, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterDecimalLiteral) {
            listener.enterDecimalLiteral(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitDecimalLiteral) {
            listener.exitDecimalLiteral(this);
        }
    }
}
exports.DecimalLiteralContext = DecimalLiteralContext;
class DoubleLiteralContext extends NumberContext {
    DOUBLE_VALUE() { return this.getToken(SqlBaseParser.DOUBLE_VALUE, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterDoubleLiteral) {
            listener.enterDoubleLiteral(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitDoubleLiteral) {
            listener.exitDoubleLiteral(this);
        }
    }
}
exports.DoubleLiteralContext = DoubleLiteralContext;
class IntegerLiteralContext extends NumberContext {
    INTEGER_VALUE() { return this.getToken(SqlBaseParser.INTEGER_VALUE, 0); }
    constructor(ctx) {
        super(ctx.parent, ctx.invokingState);
        this.copyFrom(ctx);
    }
    // @Override
    enterRule(listener) {
        if (listener.enterIntegerLiteral) {
            listener.enterIntegerLiteral(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitIntegerLiteral) {
            listener.exitIntegerLiteral(this);
        }
    }
}
exports.IntegerLiteralContext = IntegerLiteralContext;
class NonReservedContext extends ParserRuleContext_1.ParserRuleContext {
    ADD() { return this.tryGetToken(SqlBaseParser.ADD, 0); }
    ADMIN() { return this.tryGetToken(SqlBaseParser.ADMIN, 0); }
    ALL() { return this.tryGetToken(SqlBaseParser.ALL, 0); }
    ANALYZE() { return this.tryGetToken(SqlBaseParser.ANALYZE, 0); }
    ANY() { return this.tryGetToken(SqlBaseParser.ANY, 0); }
    ARRAY() { return this.tryGetToken(SqlBaseParser.ARRAY, 0); }
    ASC() { return this.tryGetToken(SqlBaseParser.ASC, 0); }
    AT() { return this.tryGetToken(SqlBaseParser.AT, 0); }
    BERNOULLI() { return this.tryGetToken(SqlBaseParser.BERNOULLI, 0); }
    CALL() { return this.tryGetToken(SqlBaseParser.CALL, 0); }
    CALLED() { return this.tryGetToken(SqlBaseParser.CALLED, 0); }
    CASCADE() { return this.tryGetToken(SqlBaseParser.CASCADE, 0); }
    CATALOGS() { return this.tryGetToken(SqlBaseParser.CATALOGS, 0); }
    COLUMN() { return this.tryGetToken(SqlBaseParser.COLUMN, 0); }
    COLUMNS() { return this.tryGetToken(SqlBaseParser.COLUMNS, 0); }
    COMMENT() { return this.tryGetToken(SqlBaseParser.COMMENT, 0); }
    COMMIT() { return this.tryGetToken(SqlBaseParser.COMMIT, 0); }
    COMMITTED() { return this.tryGetToken(SqlBaseParser.COMMITTED, 0); }
    CURRENT() { return this.tryGetToken(SqlBaseParser.CURRENT, 0); }
    CURRENT_ROLE() { return this.tryGetToken(SqlBaseParser.CURRENT_ROLE, 0); }
    DATA() { return this.tryGetToken(SqlBaseParser.DATA, 0); }
    DATE() { return this.tryGetToken(SqlBaseParser.DATE, 0); }
    DAY() { return this.tryGetToken(SqlBaseParser.DAY, 0); }
    DEFINER() { return this.tryGetToken(SqlBaseParser.DEFINER, 0); }
    DESC() { return this.tryGetToken(SqlBaseParser.DESC, 0); }
    DETERMINISTIC() { return this.tryGetToken(SqlBaseParser.DETERMINISTIC, 0); }
    DISTRIBUTED() { return this.tryGetToken(SqlBaseParser.DISTRIBUTED, 0); }
    EXCLUDING() { return this.tryGetToken(SqlBaseParser.EXCLUDING, 0); }
    EXPLAIN() { return this.tryGetToken(SqlBaseParser.EXPLAIN, 0); }
    EXTERNAL() { return this.tryGetToken(SqlBaseParser.EXTERNAL, 0); }
    FILTER() { return this.tryGetToken(SqlBaseParser.FILTER, 0); }
    FIRST() { return this.tryGetToken(SqlBaseParser.FIRST, 0); }
    FOLLOWING() { return this.tryGetToken(SqlBaseParser.FOLLOWING, 0); }
    FORMAT() { return this.tryGetToken(SqlBaseParser.FORMAT, 0); }
    FUNCTION() { return this.tryGetToken(SqlBaseParser.FUNCTION, 0); }
    FUNCTIONS() { return this.tryGetToken(SqlBaseParser.FUNCTIONS, 0); }
    GRANT() { return this.tryGetToken(SqlBaseParser.GRANT, 0); }
    GRANTED() { return this.tryGetToken(SqlBaseParser.GRANTED, 0); }
    GRANTS() { return this.tryGetToken(SqlBaseParser.GRANTS, 0); }
    GRAPHVIZ() { return this.tryGetToken(SqlBaseParser.GRAPHVIZ, 0); }
    HOUR() { return this.tryGetToken(SqlBaseParser.HOUR, 0); }
    IF() { return this.tryGetToken(SqlBaseParser.IF, 0); }
    IGNORE() { return this.tryGetToken(SqlBaseParser.IGNORE, 0); }
    INCLUDING() { return this.tryGetToken(SqlBaseParser.INCLUDING, 0); }
    INPUT() { return this.tryGetToken(SqlBaseParser.INPUT, 0); }
    INTERVAL() { return this.tryGetToken(SqlBaseParser.INTERVAL, 0); }
    INVOKER() { return this.tryGetToken(SqlBaseParser.INVOKER, 0); }
    IO() { return this.tryGetToken(SqlBaseParser.IO, 0); }
    ISOLATION() { return this.tryGetToken(SqlBaseParser.ISOLATION, 0); }
    JSON() { return this.tryGetToken(SqlBaseParser.JSON, 0); }
    LANGUAGE() { return this.tryGetToken(SqlBaseParser.LANGUAGE, 0); }
    LAST() { return this.tryGetToken(SqlBaseParser.LAST, 0); }
    LATERAL() { return this.tryGetToken(SqlBaseParser.LATERAL, 0); }
    LEVEL() { return this.tryGetToken(SqlBaseParser.LEVEL, 0); }
    LIMIT() { return this.tryGetToken(SqlBaseParser.LIMIT, 0); }
    LOGICAL() { return this.tryGetToken(SqlBaseParser.LOGICAL, 0); }
    MAP() { return this.tryGetToken(SqlBaseParser.MAP, 0); }
    MATERIALIZED() { return this.tryGetToken(SqlBaseParser.MATERIALIZED, 0); }
    MINUTE() { return this.tryGetToken(SqlBaseParser.MINUTE, 0); }
    MONTH() { return this.tryGetToken(SqlBaseParser.MONTH, 0); }
    NAME() { return this.tryGetToken(SqlBaseParser.NAME, 0); }
    NFC() { return this.tryGetToken(SqlBaseParser.NFC, 0); }
    NFD() { return this.tryGetToken(SqlBaseParser.NFD, 0); }
    NFKC() { return this.tryGetToken(SqlBaseParser.NFKC, 0); }
    NFKD() { return this.tryGetToken(SqlBaseParser.NFKD, 0); }
    NO() { return this.tryGetToken(SqlBaseParser.NO, 0); }
    NONE() { return this.tryGetToken(SqlBaseParser.NONE, 0); }
    NULLIF() { return this.tryGetToken(SqlBaseParser.NULLIF, 0); }
    NULLS() { return this.tryGetToken(SqlBaseParser.NULLS, 0); }
    OFFSET() { return this.tryGetToken(SqlBaseParser.OFFSET, 0); }
    ONLY() { return this.tryGetToken(SqlBaseParser.ONLY, 0); }
    OPTION() { return this.tryGetToken(SqlBaseParser.OPTION, 0); }
    ORDINALITY() { return this.tryGetToken(SqlBaseParser.ORDINALITY, 0); }
    OUTPUT() { return this.tryGetToken(SqlBaseParser.OUTPUT, 0); }
    OVER() { return this.tryGetToken(SqlBaseParser.OVER, 0); }
    PARTITION() { return this.tryGetToken(SqlBaseParser.PARTITION, 0); }
    PARTITIONS() { return this.tryGetToken(SqlBaseParser.PARTITIONS, 0); }
    POSITION() { return this.tryGetToken(SqlBaseParser.POSITION, 0); }
    PRECEDING() { return this.tryGetToken(SqlBaseParser.PRECEDING, 0); }
    PRIVILEGES() { return this.tryGetToken(SqlBaseParser.PRIVILEGES, 0); }
    PROPERTIES() { return this.tryGetToken(SqlBaseParser.PROPERTIES, 0); }
    RANGE() { return this.tryGetToken(SqlBaseParser.RANGE, 0); }
    READ() { return this.tryGetToken(SqlBaseParser.READ, 0); }
    REFRESH() { return this.tryGetToken(SqlBaseParser.REFRESH, 0); }
    RENAME() { return this.tryGetToken(SqlBaseParser.RENAME, 0); }
    REPEATABLE() { return this.tryGetToken(SqlBaseParser.REPEATABLE, 0); }
    REPLACE() { return this.tryGetToken(SqlBaseParser.REPLACE, 0); }
    RESET() { return this.tryGetToken(SqlBaseParser.RESET, 0); }
    RESPECT() { return this.tryGetToken(SqlBaseParser.RESPECT, 0); }
    RESTRICT() { return this.tryGetToken(SqlBaseParser.RESTRICT, 0); }
    RETURN() { return this.tryGetToken(SqlBaseParser.RETURN, 0); }
    RETURNS() { return this.tryGetToken(SqlBaseParser.RETURNS, 0); }
    REVOKE() { return this.tryGetToken(SqlBaseParser.REVOKE, 0); }
    ROLE() { return this.tryGetToken(SqlBaseParser.ROLE, 0); }
    ROLES() { return this.tryGetToken(SqlBaseParser.ROLES, 0); }
    ROLLBACK() { return this.tryGetToken(SqlBaseParser.ROLLBACK, 0); }
    ROW() { return this.tryGetToken(SqlBaseParser.ROW, 0); }
    ROWS() { return this.tryGetToken(SqlBaseParser.ROWS, 0); }
    SCHEMA() { return this.tryGetToken(SqlBaseParser.SCHEMA, 0); }
    SCHEMAS() { return this.tryGetToken(SqlBaseParser.SCHEMAS, 0); }
    SECOND() { return this.tryGetToken(SqlBaseParser.SECOND, 0); }
    SECURITY() { return this.tryGetToken(SqlBaseParser.SECURITY, 0); }
    SERIALIZABLE() { return this.tryGetToken(SqlBaseParser.SERIALIZABLE, 0); }
    SESSION() { return this.tryGetToken(SqlBaseParser.SESSION, 0); }
    SET() { return this.tryGetToken(SqlBaseParser.SET, 0); }
    SETS() { return this.tryGetToken(SqlBaseParser.SETS, 0); }
    SQL() { return this.tryGetToken(SqlBaseParser.SQL, 0); }
    SHOW() { return this.tryGetToken(SqlBaseParser.SHOW, 0); }
    SOME() { return this.tryGetToken(SqlBaseParser.SOME, 0); }
    START() { return this.tryGetToken(SqlBaseParser.START, 0); }
    STATS() { return this.tryGetToken(SqlBaseParser.STATS, 0); }
    SUBSTRING() { return this.tryGetToken(SqlBaseParser.SUBSTRING, 0); }
    SYSTEM() { return this.tryGetToken(SqlBaseParser.SYSTEM, 0); }
    TABLES() { return this.tryGetToken(SqlBaseParser.TABLES, 0); }
    TABLESAMPLE() { return this.tryGetToken(SqlBaseParser.TABLESAMPLE, 0); }
    TEMPORARY() { return this.tryGetToken(SqlBaseParser.TEMPORARY, 0); }
    TEXT() { return this.tryGetToken(SqlBaseParser.TEXT, 0); }
    TIME() { return this.tryGetToken(SqlBaseParser.TIME, 0); }
    TIMESTAMP() { return this.tryGetToken(SqlBaseParser.TIMESTAMP, 0); }
    TO() { return this.tryGetToken(SqlBaseParser.TO, 0); }
    TRANSACTION() { return this.tryGetToken(SqlBaseParser.TRANSACTION, 0); }
    TRY_CAST() { return this.tryGetToken(SqlBaseParser.TRY_CAST, 0); }
    TYPE() { return this.tryGetToken(SqlBaseParser.TYPE, 0); }
    UNBOUNDED() { return this.tryGetToken(SqlBaseParser.UNBOUNDED, 0); }
    UNCOMMITTED() { return this.tryGetToken(SqlBaseParser.UNCOMMITTED, 0); }
    USE() { return this.tryGetToken(SqlBaseParser.USE, 0); }
    USER() { return this.tryGetToken(SqlBaseParser.USER, 0); }
    VALIDATE() { return this.tryGetToken(SqlBaseParser.VALIDATE, 0); }
    VERBOSE() { return this.tryGetToken(SqlBaseParser.VERBOSE, 0); }
    VIEW() { return this.tryGetToken(SqlBaseParser.VIEW, 0); }
    WORK() { return this.tryGetToken(SqlBaseParser.WORK, 0); }
    WRITE() { return this.tryGetToken(SqlBaseParser.WRITE, 0); }
    YEAR() { return this.tryGetToken(SqlBaseParser.YEAR, 0); }
    ZONE() { return this.tryGetToken(SqlBaseParser.ZONE, 0); }
    constructor(parent, invokingState) {
        super(parent, invokingState);
    }
    // @Override
    get ruleIndex() { return SqlBaseParser.RULE_nonReserved; }
    // @Override
    enterRule(listener) {
        if (listener.enterNonReserved) {
            listener.enterNonReserved(this);
        }
    }
    // @Override
    exitRule(listener) {
        if (listener.exitNonReserved) {
            listener.exitNonReserved(this);
        }
    }
}
exports.NonReservedContext = NonReservedContext;
